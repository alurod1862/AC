package ExamenAC

import java.sql.DriverManager

fun main(){

    val url = "jdbc:postgresql://89.36.214.106:5432/autoescola"
    val usuario = "autoescola"
    val password = "autoescola"
    val con = DriverManager.getConnection(url, usuario, password)
    val st = con.createStatement()


    val sentenciaSQL = "select dni,nom,data_n,baixa from alumne where baixa = 'No' order by data_n desc"
    val sentenciaSQL2 = "select dni, count(practiques.val),sum(km) as kmtotal from practiques group by dni order by kmtotal desc"
    val rs = st.executeQuery(sentenciaSQL)

    println("Alumnos de baja")

    while (rs.next()) {
        print("DNI: " + rs.getString(1) + "\t")
        print("Nombre: " + rs.getString(2) + "\t")
        print("Fecha: " + rs.getString(3) + "\t")
        print("Baja: " + rs.getString(4) + "\t")
    }

    st.close();
    con.close()
}




