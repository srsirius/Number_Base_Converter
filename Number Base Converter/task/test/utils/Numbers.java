package utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.math.RoundingMode.HALF_EVEN;

public final class Numbers {
    public static final String DIGITS = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static final Pattern DOT_PATTERN = Pattern.compile(".", Pattern.LITERAL);
    static final int MINIMUM_BASE = 2;
    static final int MAXIMUM_BASE = DIGITS.length();
    private static final int MAX_WHOLE_LENGTH = 20;
    private static final int MAX_FRACTION_LENGTH = 10;
    private static final int MAX_TARGET_FRACTION_LENGTH = 5;
    private static final int SCALE = 10;
    private static final MathContext MC = new MathContext(10, HALF_EVEN);

    private static final Random random = new Random();

    public static String generateNumber(final int radix) {
        final var sourceWhole = IntStream.concat(
                random.ints(1, 1, radix),
                random.ints(random.nextInt(MAX_WHOLE_LENGTH), 0, radix))
                .map(DIGITS::charAt)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());

        if (random.nextBoolean()) {
            return sourceWhole;
        }

        final var sourceFraction = random
                .ints(1 + random.nextInt(MAX_FRACTION_LENGTH), 0, radix)
                .map(DIGITS::charAt)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());

        return sourceWhole + '.' + sourceFraction;
    }

    public static int getRandomBase() {
        return MINIMUM_BASE + random.nextInt(MAXIMUM_BASE - MINIMUM_BASE);
    }

    public static boolean isWholeNumber(final String number) {
        return !number.contains(".");
    }

    private static String addZeros(final String fraction) {
        return (fraction + "0".repeat(MAX_TARGET_FRACTION_LENGTH)).substring(0, MAX_TARGET_FRACTION_LENGTH);
    }

    public static String convert(final String sourceNumber, final int sourceBase, final int targetBase) {
        if (isWholeNumber(sourceNumber)) {
            return sourceBase == targetBase
                    ? sourceNumber
                    : new BigInteger(sourceNumber, sourceBase).toString(targetBase);
        }

        final var numberParts = DOT_PATTERN.split(sourceNumber);
        if (sourceBase == targetBase) {
            return numberParts[0] + '.' + addZeros(numberParts[1]);
        }

        final var targetWhole = new BigInteger(numberParts[0], sourceBase).toString(targetBase);
        final var targetFraction = new StringBuilder();

        var bigTargetBase = new BigDecimal(targetBase).setScale(SCALE, HALF_EVEN);
        var decimalFraction = convertFractionToDecimal(numberParts[1], sourceBase);

        for (int i = 0; i < MAX_TARGET_FRACTION_LENGTH; ++i) {
            decimalFraction = decimalFraction.multiply(bigTargetBase);
            final int index = decimalFraction.intValue();
            targetFraction.append(DIGITS.charAt(index));
            decimalFraction = decimalFraction.subtract(new BigDecimal(index));
        }
        return targetWhole + '.' + targetFraction.substring(0, MAX_TARGET_FRACTION_LENGTH);
    }

    public static BigDecimal convertFractionToDecimal(final String sourceFraction, final int sourceBase) {
        final var sourceFractionArray = sourceFraction.chars().map(DIGITS::indexOf).toArray();
        final var bigSourceBase = new BigDecimal(sourceBase).setScale(SCALE, HALF_EVEN);

        var fraction = BigDecimal.ZERO.setScale(SCALE, HALF_EVEN);
        var divider = new BigDecimal(sourceBase).setScale(SCALE, HALF_EVEN);

        for (final int digit : sourceFractionArray) {
            final var delta = new BigDecimal(digit)
                    .setScale(SCALE, HALF_EVEN)
                    .divide(divider, HALF_EVEN);
            fraction = fraction.add(delta);
            divider = divider.multiply(bigSourceBase);
        }
        return fraction;
    }

}
