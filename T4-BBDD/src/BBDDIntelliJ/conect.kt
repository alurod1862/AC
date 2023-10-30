package BBDDIntelliJ


import java.sql.DriverManager

fun main(args: Array<String>) {
    val url = "jdbc:mysql://172.17.0.2:3306/Gestion"
    val usuari = "root"
    val password = "secret"

    val con = DriverManager.getConnection(url, usuari, password)
    System.out.println("Connexió completada")
    con.close()
}
