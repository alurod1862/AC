package CRUD_SQLITE

import java.sql.DriverManager


fun createTableM(){
    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()


    val sentSQL = "CREATE TABLE USUARIO(" +
            "id TEXT CONSTRAINT cp_id PRIMARY KEY, " +
            "nombre TEXT, " +
            "user TEXT, " +
            "password TEXT, " +
            "telefono TEXT, " +
            "email  TEXT" +
            ")"


    st.executeUpdate(sentSQL)
    st.close();

    con.close()

}

fun insertarDatosTablaM(){


    println("Introduce la talba donde se va a insertar: ")
    var tabla = readln()
    println("Introduce el id del usuario: ")
    var id = readln()
    println("Introduce el nombre: ")
    var nombre = readln()
    println("Introduce el nombre del usuario: ")
    var user = readln()
    println("Introduce el telefono del usuario: ")
    var telefono = readln()
    println("Introduce el email del usuario: ")
    var email = readln()
    println("Introduce la contraseña del usuario: ")
    var password = readln()

    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("INSERT INTO $tabla VALUES ('$id','$nombre','$user','$password','$telefono','$email')")

    st.close()
    con.close()

}


fun updateTableM(){

    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()


    println("Introduce la talba a actualizar: ")
    var tabla = readln()
    println("Introduce el telefono nuevo: ")
    var telefono = readln()
    println("Introduce el id del usuario: ")
    var id = readln()


    st.executeUpdate("UPDATE $tabla SET telefono = $telefono WHERE $id=1")

    st.close();
    con.close()
}

fun consultaTableM(){
    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    println("Introduce la talba a consultar: ")
    var tabla = readln()
    println("Introduce el id del usuario: ")
    var id = readln()

    val sentenciaSQL = "SELECT * FROM $tabla WHERE $id = 1"
    val rs = st.executeQuery(sentenciaSQL)

    while (rs.next()) {
        print("" + rs.getString(1) + "\t")
        print(rs.getString(2) + "\t")
        print("" + rs.getString(3) + "\t")
        print("" + rs.getString(4) + "\t")
        print("" + rs.getString(5) + "\t")
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

    println("Introduce la talba a eliminar: ")
    var tabla = readln()

    st.executeUpdate("DROP TABLE $tabla")

    st.close();
    con.close()
}


fun deleteTableM(){

    val url = "jdbc:sqlite:crud.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    println("Introduce la talba: ")
    var tabla = readln()
    println("Introduce el id del usuario: ")
    var id = readln()


    st.executeUpdate("DELETE FROM $tabla where $id = 2")

    st.close();
    con.close()
}