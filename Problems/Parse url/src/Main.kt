fun main() {
    val url = readLine()!!
    val temp = url.substring(url.indexOf("?") + 1).split("&")
    var password = ""
    for (i in temp) {
        val strKeyValue = i.split("=")
        if (strKeyValue[1].isNotEmpty()) {
            println("${strKeyValue[0]} : ${strKeyValue[1]}")
            if (strKeyValue[0] == "pass") password = strKeyValue[1]
        } else println("${strKeyValue[0]} : not found")

    }
    if (password.isNotEmpty()) print("password : $password")
}