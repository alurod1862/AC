import java.lang.reflect.Type
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Types

object storePorcedure {
    @Throws(ClassNotFoundException::class,SQLException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        Class.forName("org.postgresql.Driver")
        val url = "jdbc:postgresql://172.17.0.2:5432/postgres"
        val usuario = "postgres"
        val password = "secret"
        val con = DriverManager.getConnection(url,usuario,password)
        val c5mt = con.prepareCall(
            "{call cantidadnadadores}"
        )
        c5mt.registerOutParameter(1, Types.INTEGER)
        c5mt.execute()
        val resultado = c5mt.getInt(1)
        println("Resultado: $resultado")
        con.close()
    }
}


/*
CREATE OR REPLACE FUNCTION CantidadNadadores() RETURNS INTEGER
AS
$$
    DECLARE
        cantidad INTEGER;
    BEGIN
        SELECT count(nom) INTO cantidad FROM nadador;
        RETURN cantidad;
end;
$$
LANGUAGE plpgsql;
 */