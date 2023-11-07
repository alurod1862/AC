import java.sql.DriverManager


fun main(){
    var registros=0
    val url = "jdbc:postgresql://89.36.214.106:5432/biblio2"
    val usuari = "biblio2"
    val password = "biblio2"

    val con = DriverManager.getConnection(url, usuari, password)
    val st = con.createStatement()

    val preparedStatement = con.prepareStatement("select isbn,titol,pagines,editorial from llibre where pagines > 100")


    val rs = preparedStatement.executeQuery()

    while (rs.next()) {
        print("ISBN " + rs.getString(1) + "\n")
        print("Titol " + rs.getString(2) + "\n")
        print("Pagines " + rs.getString(3) + "\n")
        print("Editorial " + rs.getString(4) + "\n")
        registros++
        println("---------------------------------------------")
    }

    println("Registros: $registros")

    rs.close()
    preparedStatement.close()
    con.close()
}


