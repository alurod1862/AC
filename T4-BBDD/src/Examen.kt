package CRUD_PostgreSQL

import java.sql.DriverManager


fun main() {
    menuPostrgeSQL()
}

fun menuPostrgeSQL(){

    var elecion:Int =0
    var sige = true

    while (sige) {


        println("Bienvenido al menu ")
        println("1.CREATE")
        println("2.INSERT")
        println("3.UPDATE")
        println("4.CONSULT por teclado")
        println("5.CONSULT Todo")
        println("6.DROP por teclado")
        println("7.DROP Todo")
        println("8.Eliminar Tabla")
        println("9.SALIR")
        println("Introduce una opcion(1-7): ")


        elecion = readln()!!.toInt()

        if (elecion == 1) {
            createTableMPE()
        } else if (elecion == 2) {
            insertarDatosTablaMPE()
        } else if (elecion == 3) {
            updateTableMPE()
        } else if (elecion == 4) {
            consultaTablePorTecladoMPE()
        } else if (elecion == 5) {
            consultaTableTodoMPE()
        } else if (elecion == 6) {
            deleteTablePorTecladoMPE()
        }else if(elecion == 7){
            deleteTableTodoMPE()
        } else if (elecion == 8){
            //deleteTableTotalMPE()
        } else if (elecion == 9) {
            sige = false
        } else {
            "Opcion no valida"
        }
    }

}

fun createTableMPE() {
    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val password = "secret"

    val con = DriverManager.getConnection(url, usuari, password)
    val st = con.createStatement()

    val sentSQL = "CREATE TABLE Nadador(nom text primary key ,num_federat text,pais text,edad int,genere text)"

    st.executeUpdate(sentSQL)
    st.close()
    con.close()
}

fun insertarDatosTablaMPE() {
    println("Introduce la tabla donde se va a insertar: ")
    var tabla = readLine()
    println("Introduce el nom del usuario: ")
    var nom = readLine()
    println("Introduce el num federat: ")
    var num_federat = readLine()
    println("Introduce el pais: ")
    var pais = readLine()
    println("Introduce la edad: ")
    var edat = readLine()!!.toInt()
    println("Introduce el genero: ")
    var genere = readLine()



    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val passwordb = "secret"


    val con = DriverManager.getConnection(url, usuari, passwordb)
    val st = con.createStatement()
    val preparedStatement = con.prepareStatement("INSERT INTO $tabla VALUES (?,?,?,?,?)")

    preparedStatement.setString(1, nom)
    preparedStatement.setString(2, num_federat)
    preparedStatement.setString(3, pais)
    preparedStatement.setInt(4, edat)
    preparedStatement.setString(5, genere)


    preparedStatement.executeUpdate()

    preparedStatement.close()
    con.close()
}

fun updateTableMPE() {
    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val password1 = "secret"

    val con = DriverManager.getConnection(url, usuari, password1)
    val st = con.createStatement()

    println("Introduce la tabla donde se va a insertar: ")
    var tabla = readLine()
    println("Introduce el nom del usuario: ")
    var nom = readLine()
    println("Introduce la nueva edad: ")
    var edad = readLine()!!.toInt()

    if (edad > 15){
        val preparedStatement = con.prepareStatement("UPDATE $tabla SET edad = ? WHERE nom = '$nom' ")

        preparedStatement.setInt(1, edad)
        preparedStatement.executeUpdate()
        preparedStatement.close()

    }else{
        println("Edad menor a 15")
    }


    con.close()
}

fun consultaTablePorTecladoMPE() {
    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val password = "secret"

    val con = DriverManager.getConnection(url, usuari, password)
    val st = con.createStatement()

    println("Introduce la tabla a consultar: ")
    var tabla = readLine()
    println("Introduce el nom del usuario: ")
    var nom = readLine()

    val preparedStatement = con.prepareStatement("SELECT * FROM $tabla WHERE nom = ?")

    preparedStatement.setString(1, nom)

    val rs = preparedStatement.executeQuery()


    while (rs.next()) {
        print("" + rs.getString(1) + "\t")
        print(rs.getString(2) + "\t")
        print("" + rs.getString(3) + "\t")
        print("" + rs.getString(4) + "\t")
        println(rs.getString(5))
    }

    rs.close()
    preparedStatement.close()
    con.close()
}


fun consultaTableTodoMPE() {
    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val password = "secret"

    val con = DriverManager.getConnection(url, usuari, password)
    val st = con.createStatement()


    val preparedStatement = con.prepareStatement("SELECT * FROM Nadador")


    val rs = preparedStatement.executeQuery()

    while (rs.next()) {
        print("" + rs.getString(1) + "\t")
        print(rs.getString(2) + "\t")
        print("" + rs.getString(3) + "\t")
        print("" + rs.getString(4) + "\t")
        println(rs.getString(5))
    }

    rs.close()
    preparedStatement.close()
    con.close()
}

fun deleteTableTodoMPE() {
    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val password = "secret"

    val con = DriverManager.getConnection(url, usuari, password)
    val st = con.createStatement()

    val preparedStatement = con.prepareStatement("DROP TABLE Nadador")

    preparedStatement.executeUpdate()

    preparedStatement.close()
    con.close()
}

fun deleteTablePorTecladoMPE() {
    val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
    val usuari = "postgres"
    val password = "secret"

    val con = DriverManager.getConnection(url, usuari, password)
    val st = con.createStatement()

    println("Introduce la tabla: ")
    var tabla = readLine()
    println("Introduce el nom del usuario: ")
    var id = readLine()

    val preparedStatement = con.prepareStatement("DELETE FROM $tabla WHERE nom = ?")

    preparedStatement.setString(1, id)

    preparedStatement.executeUpdate()

    preparedStatement.close()
    con.close()
}


