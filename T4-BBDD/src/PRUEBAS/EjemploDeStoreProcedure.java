package PRUEBAS;

import java.sql.*;

public class EjemploDeStoreProcedure {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");

        String url="jbdc:postgresql://172.17.0.2:5432/postgres";
        String usuario="postgres";
        String password="secret";
        Connection con = DriverManager.getConnection(url,usuario,password);

        CallableStatement c5tmt = con.prepareCall(
                "{call CantidadPerosnas(?)}");
        c5tmt.registerOutParameter(1, Types.INTEGER);
        c5tmt.setString(1,"iker%");

        c5tmt.execute();
        int resultado = c5tmt.getInt(1);
        System.out.println("Resultado: " +  resultado);
        con.close();



    }

}
