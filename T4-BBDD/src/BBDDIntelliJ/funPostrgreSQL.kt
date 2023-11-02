package BBDDIntelliJ

import java.sql.DriverManager

fun createTableMP() {
    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val password = "secret"

    val con = DriverManager.getConnection(url, usuari, password)
    val st = con.createStatement()

    val sentSQL = "CREATE TABLE USUARIO(id int primary key auto_increment,nombre text,user text,telefono text,email varchar(50 ),password text)"


    st.executeUpdate(sentSQL)
    st.close()
    con.close()
}

fun insertarDatosTablaMP() {
    println("Introduce la tabla donde se va a insertar: ")
    var tabla = readLine()
    println("Introduce el id del usuario: ")
    var id = readLine()
    println("Introduce el nombre: ")
    var nombre = readLine()
    println("Introduce el nombre del usuario: ")
    var user = readLine()
    println("Introduce el telefono del usuario: ")
    var telefono = readLine()
    println("Introduce el email del usuario: ")
    var email = readLine()
    println("Introduce la contraseña del usuario: ")
    var password = readLine()


    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val passwordb = "secret"


    val con = DriverManager.getConnection(url, usuari, passwordb)
    val st = con.createStatement()
    val preparedStatement = con.prepareStatement("INSERT INTO $tabla VALUES (?,?,?,?,?,?)")

    preparedStatement.setString(1, id)
    preparedStatement.setString(2, nombre)
    preparedStatement.setString(3, user)
    preparedStatement.setString(4, password)
    preparedStatement.setString(5, telefono)
    preparedStatement.setString(6, email)

    preparedStatement.executeUpdate()

    preparedStatement.close()
    con.close()
}

fun updateTableMP() {
    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val password1 = "secret"

    val con = DriverManager.getConnection(url, usuari, password1)
    val st = con.createStatement()

    println("Introduce la tabla donde se va a insertar: ")
    var tabla = readLine()
    println("Introduce el id del usuario: ")
    var idp = readLine()
    println("Introduce el id nuevo del usuario: ")
    var id = readLine()
    println("Introduce el nuevo nombre: ")
    var nombre = readLine()
    println("Introduce el nuevo nombre del usuario: ")
    var user = readLine()
    println("Introduce el nuevo telefono del usuario: ")
    var telefono = readLine()
    println("Introduce el neuvo email del usuario: ")
    var email = readLine()
    println("Introduce la nueva contraseña del usuario: ")
    var password = readLine()


    val preparedStatement = con.prepareStatement("UPDATE $tabla SET id = ? ,nombre = ?,user = ?,password = ?, telefono = ?,email = ? WHERE id = $idp")

    preparedStatement.setString(1, id)
    preparedStatement.setString(2, nombre)
    preparedStatement.setString(3, user)
    preparedStatement.setString(4, password)
    preparedStatement.setString(5, telefono)
    preparedStatement.setString(6, email)
    preparedStatement.executeUpdate()

    preparedStatement.close()
    con.close()
}

fun consultaTableMP() {
    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val password = "secret"

    val con = DriverManager.getConnection(url, usuari, password)
    val st = con.createStatement()

    println("Introduce la tabla a consultar: ")
    var tabla = readLine()
    println("Introduce el id del usuario: ")
    var id = readLine()

    val preparedStatement = con.prepareStatement("SELECT * FROM $tabla WHERE id = ?")

    preparedStatement.setString(1, id)

    val rs = preparedStatement.executeQuery()

    while (rs.next()) {
        print("" + rs.getString(1) + "\t")
        print(rs.getString(2) + "\t")
        print("" + rs.getString(3) + "\t")
        print("" + rs.getString(4) + "\t")
        print("" + rs.getString(5) + "\t")
        println(rs.getString(6))
    }

    rs.close()
    preparedStatement.close()
    con.close()
}

fun dropTableMP() {
    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val password = "secret"

    val con = DriverManager.getConnection(url, usuari, password)
    val st = con.createStatement()

    println("Introduce la tabla a eliminar: ")
    var tabla = readLine()

    val preparedStatement = con.prepareStatement("DROP TABLE $tabla")

    preparedStatement.executeUpdate()

    preparedStatement.close()
    con.close()
}

fun deleteTableMP() {
    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "root"
    val password = "secret"

    val con = DriverManager.getConnection(url, usuari, password)
    val st = con.createStatement()

    println("Introduce la tabla: ")
    var tabla = readLine()
    println("Introduce el id del usuario: ")
    var id = readLine()

    val preparedStatement = con.prepareStatement("DELETE FROM $tabla WHERE id = ?")

    preparedStatement.setString(1, id)

    preparedStatement.executeUpdate()

    preparedStatement.close()
    con.close()
}