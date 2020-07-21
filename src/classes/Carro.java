package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Carro {
    private String ID;
    private String nome;
    private String marca;
    private String cor;
    private String desc;
    private int ano;
    private boolean rua;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isRua() {
        return rua;
    }

    public void setRua(boolean rua) {
        this.rua = rua;
    }

    public Carro cadastrar_carro(){
        Scanner in = new Scanner(System.in);
        UUID uuid = UUID.randomUUID();

        Carro carro = new Carro();

        carro.setID(String.valueOf(uuid));
        carro.setRua(false);

        System.out.println("Infome o nome do Carro");
        carro.setNome(in.nextLine());

        System.out.println("Informe a marca do Carro");
        carro.setMarca(in.nextLine());

        System.out.println("Informe a cor do Carro");
        carro.setCor(in.nextLine());

        System.out.println("Informe a descrição do Carro");
        carro.setDesc(in.nextLine());

        System.out.println("Informe o ano do Carro");
        carro.setAno(in.nextInt());


        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "arquivo41");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "Insert Into carros values ('" + carro.getID() + "', '" + carro.getNome() + "', '" + carro.getMarca() + "', '"
                    + carro.getCor() + "', '" + carro.getDesc() + "', " + carro.getAno() + ", '" + carro.isRua() + "');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");



        return carro;
    }

    public void listarCarros(ArrayList<Carro> carros){

        /*
        for (int i=0;i < carros.size();i++){
            System.out.println(carros.get(i).getNome() + " da marca " + carros.get(i).getMarca() + " da cor " + carros.get(i).getCor() + " cuja descrição é " + carros.get(i).getDesc() + "\n");
        }
        */

        java.sql.Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "arquivo41");
            c.setAutoCommit(false);
//            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from carros" );

            while ( rs.next() ) {
                String id = (rs.getString("id"));
                String  nome = rs.getString("nome");
                String  marca = rs.getString("marca");
                String  cor = rs.getString("cor");
                String  descricao = rs.getString("descricao");
                int ano = rs.getInt("ano");
                String  rua = rs.getString("rua");

                System.out.println( "ID = " + id );
                System.out.println( "Nome = " + nome );
                System.out.println( "Marca = " + marca );
                System.out.println( "Cor = " + cor );
                System.out.println( "Descricao = " + descricao );
                System.out.println( "Ano = " + ano );
                System.out.println( "Disponivel = " + rua );

                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
}
