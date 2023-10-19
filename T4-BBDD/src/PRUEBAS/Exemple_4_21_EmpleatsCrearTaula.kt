package PRUEBAS

import java.sql.DriverManager

fun main(args: Array<String>) {
    val url = "jdbc:sqlite:proveta.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    val sentSQL = "CREATE TABLE EMPLEAT(" +
            "num INTEGER CONSTRAINT cp_emp PRIMARY KEY, " +
            "nom TEXT, " +
            "depart INTEGER, " +
            "edat INTEGER, " +
            "sou REAL " +
            ")"

    st.executeUpdate(sentSQL)
    st.close();
    con.close()
}