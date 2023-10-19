package PRUEBAS

import java.sql.DriverManager
fun main(args: Array<String>) {
    val url = "jdbc:sqlite:proveta.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("INSERT INTO EMPLEAT VALUES (1,'Iker',33,33,3333.0)")

    st.close()
    con.close()
}