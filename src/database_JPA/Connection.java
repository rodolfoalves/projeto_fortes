package database_JPA;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Connection {
    public static void main( String args[] ) {
        java.sql.Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "arquivo41");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from cliente" );

            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  nome = rs.getString("nome");
                String  login = rs.getString("login");
                String  senha = rs.getString("senha");
                String  cpf = rs.getString("cpf");
                String  email = rs.getString("email");

                System.out.println( "ID = " + id );
                System.out.println( "Nome = " + nome );
                System.out.println( "Login = " + login );
                System.out.println( "Senha = " + senha );
                System.out.println( "Email = " + email );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}