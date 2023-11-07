package PRUEBAS

import java.lang.reflect.Type
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Types

object Examen4 {
    @Throws(ClassNotFoundException::class,SQLException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        Class.forName("org.postgresql.Driver")
        val url = "jdbc:postgresql://89.36.214.106:5432/biblio2"
        val usuario = "biblio2"
        val password = "biblio2"
        val con = DriverManager.getConnection(url,usuario,password)
        val c5mt = con.prepareCall(
            "{call listaaautores(?)}"
        )
        c5mt.registerOutParameter(1, Types.INTEGER)
        c5mt.setString(1,"R%")
        c5mt.execute()
        val resultado = c5mt.getString(1)
        println("Resultado: $resultado")
        con.close()
    }
}


/*
create or replace function listaaautoresiker(comodin character varying) returns SETOF autor
    language plpgsql
as
$$
DECLARE
    registro autor;
BEGIN
    SELECT * FROM autor WHERE nom LIKE comodin;
            RETURN  registro;
END;
$$;



 */