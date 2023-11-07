
import java.sql.DriverManager


fun main(){
    val url = "jdbc:postgresql://89.36.214.106:5432/biblio2"
    val usuari = "biblio2"
    val password = "biblio2"

    val con = DriverManager.getConnection(url, usuari, password)
    val st = con.createStatement()

    val preparedStatement = con.prepareStatement("select editorial,titol,max(pagines)from llibre group by editorial, titol")


    val rs = preparedStatement.executeQuery()

    while (rs.next()) {
        print("ISBN " + rs.getString(1) + "\n")
        print("Titol " + rs.getString(2) + "\n")
        print("Pagines " + rs.getString(3) + "\n")
        println("---------------------------------------------")
    }

    rs.close()
    preparedStatement.close()
    con.close()
}






