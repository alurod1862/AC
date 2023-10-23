package CRUD

import java.sql.DriverManager

fun main(){
    createTable()
    insertarDatosTabla()
    updateTable()
    consultaTable()
    deleteTable()
}
fun createTable(){
    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()


    val sentSQL = "CREATE TABLE USUARIO(" +
            "id INTEGER CONSTRAINT cp_id PRIMARY KEY, " +
            "nombre TEXT, " +
            "user TEXT, " +
            "password TEXT, " +
            "telefono INTEGER, " +
            "email  TEXT" +
            ")"


    st.executeUpdate(sentSQL)
    st.close();
    con.close()

}

fun insertarDatosTabla(){


    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("INSERT INTO USUARIO VALUES (1,'Iker','Iker1','contrasenaDeIker',987654321,'iker@gmail.com')")
    st.executeUpdate("INSERT INTO USUARIO VALUES (2,'Isaac','Isaac1','contrasenaDeIsaac',456123789,'isaac@gmail.com')")

    st.close()
    con.close()

}


fun updateTable(){

    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("UPDATE USUARIO SET telefono = 123456789")

    st.close();
    con.close()
}

fun consultaTable(){
    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    val sentenciaSQL = "SELECT * FROM USUARIO WHERE id = 1"
    val rs = st.executeQuery(sentenciaSQL)

    while (rs.next()) {
        print("" + rs.getInt(1) + "\t")
        print(rs.getString(2) + "\t")
        print("" + rs.getString(3) + "\t")
        print("" + rs.getString(4) + "\t")
        print("" + rs.getInt(5) + "\t")
        println(rs.getString(6))
    }

    rs.close()
    st.close()
    con.close()

}

fun dropTable(){

    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("DROP TABLE USUARIO")

    st.close();
    con.close()
}


fun deleteTable(){

    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("DELETE FROM USUARIO where telefono = 123456789")

    st.close();
    con.close()
}