package CRUD

import java.sql.DriverManager


fun createTableM(tabla:String,id:Int,nombre:String,user:String,password:String,telefono:String,email:String){
    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()



    val sentSQL = "CREATE TABLE $tabla(" +
            "$id INTEGER CONSTRAINT cp_id PRIMARY KEY, " +
            "$nombre TEXT, " +
            "$user TEXT, " +
            "$password TEXT, " +
            "$telefono TEXT, " +
            "$email  TEXT" +
            ")"


    st.executeUpdate(sentSQL)
    st.close();

    con.close()

}

fun insertarDatosTablaM(){


    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("INSERT INTO USUARIO VALUES (1,'Iker','Iker1','contrasenaDeIker','987654321','iker@gmail.com')")
    st.executeUpdate("INSERT INTO USUARIO VALUES (2,'Isaac','Isaac1','contrasenaDeIsaac','456123789','isaac@gmail.com')")

    st.close()
    con.close()

}


fun updateTableM(){

    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("UPDATE USUARIO SET telefono = '123456789' WHERE id = 1")

    st.close();
    con.close()
}

fun consultaTableM(){
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

fun dropTableM(){

    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("DROP TABLE USUARIO")

    st.close();
    con.close()
}


fun deleteTableM(){

    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("DELETE FROM USUARIO where telefono = '123456789'")

    st.close();
    con.close()
}