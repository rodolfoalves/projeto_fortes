package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;

public class Cliente {
    private String Id;
    private String nome;
    private String login;
    private String senha;
    private String cpf;
    private String email;

    public String getID() {
        return Id;
    }

    public void setID(String ID) {
        this.Id = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void cadastrarCliente(){
        Scanner in = new Scanner(System.in);
        UUID uuid = UUID.randomUUID();

        Cliente cliente = new Cliente();

        cliente.setID(uuid.toString());

        System.out.println("Infome o nome do Cliente");
        cliente.setNome(in.nextLine());

        System.out.println("Informe o Login do Cliente");
        cliente.setLogin(in.nextLine());

        System.out.println("Informe a Senha do Cliente");
        cliente.setSenha(in.nextLine());

        System.out.println("Informe o CPF do Cliente");
        cliente.setCpf(in.nextLine());

        System.out.println("Informe o Email do Cliente");
        cliente.setEmail(in.nextLine());

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "arquivo41");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "Insert Into cliente values ('" + cliente.getID() + "', '" + cliente.getNome() + "', '" + cliente.getLogin() + "', '"
                    + cliente.getSenha() + "', '" + cliente.getCpf() + "', '" + cliente.getEmail() + "');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");

    }

    public void mostrarCadastrosCliente(){
        java.sql.Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "arquivo41");
            c.setAutoCommit(false);
//            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from cliente" );

            while ( rs.next() ) {
                String id = String.valueOf(rs.getString("id"));
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
//        System.out.println("Operation done successfully");

    }
}
