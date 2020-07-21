package classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Administrador {
    private int ID;
    private String nome;
    private String login;
    private String senha;
    private String email;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int validarADM(String login, String senha){


        Scanner in = new Scanner(System.in);

        java.sql.Connection c = null;
        Statement stmt = null;

        String login_teste = "";
        String senha_teste = "";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "arquivo41");
            c.setAutoCommit(false);

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery( "select login,senha from administrador where administrador.login = '" + login + "';" );

            while (rs.next()){
                login_teste = String.valueOf(rs.getString("login"));
                senha_teste = String.valueOf(rs.getString("senha"));
                System.out.println( "Login = " + login_teste );
                System.out.println( "Senha = " + senha_teste );
            }

            if (login.equals(login_teste) && senha.equals(senha_teste)){
                return 1;
            }

            System.out.println("Login Ou Senha Incorretas");

            rs.close();
            stmt.close();
            c.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }

        return 0;
    }
}
