package classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Aluguel {
    private String ID;
    private Cliente cliente;
    private Carro carro;
    private Date data_de_locacao;
    private Date data_de_devolucao;
    private int valor;
    private String desc;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Date getData_de_locacao() {
        return data_de_locacao;
    }

    public void setData_de_locacao(Date data_de_locacao) {
        this.data_de_locacao = data_de_locacao;
    }

    public Date getData_de_devolucao() {
        return data_de_devolucao;
    }

    public void setData_de_devolucao(Date data_de_devolucao) {
        this.data_de_devolucao = data_de_devolucao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public void baixaCarro(ArrayList <Carro> carros, ArrayList <Aluguel> alugueis, String carro, String cor){
        if (carros.isEmpty()){
            System.out.println("Carro não cadastrado");
        }
        else {
            for (int i =0; i<carros.size();i++){
                if (carros.get(i).getNome().equals(carro) && carros.get(i).getCor().equals(cor)){
                    if (carros.get(i).isRua()){
                        System.out.println("Carro já alugado");
                    }
                    else {
                        carros.get(i).setRua(true);
                        System.out.println("Carro Alugado com Sucesso");
                    }
                }
            }
        }
    }

    public void baixaCarroDB(){
        Scanner in = new Scanner(System.in);

        System.out.println("informe o login do cliente para consultar cadastro");
        String login_cliente = in.nextLine();

        System.out.println("informe o nome do carro para conultar cadastro");
        String nome_carro = in.nextLine();

        System.out.println("informe a descricao do aluguel");
        String desc = in.nextLine();

        System.out.println("informe a data do aluguel");
        String data = in.nextLine();


        System.out.println("informe o valor estimado de pagamento");
        int valor = in.nextInt();


        java.sql.Connection c = null;
        Statement stmt = null;

        String id_carro = null;
        String rua = null;

        String id_cliente = null;
        String id_aluguel = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "arquivo41");
            c.setAutoCommit(false);
//            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select id from cliente where cliente.login = '" + login_cliente + "';" );

            while (rs.next()){
              id_cliente = String.valueOf(rs.getString("id"));
              //System.out.println( "ID = " + id_cliente );
            }

            stmt = c.createStatement();
            rs = stmt.executeQuery( "select id,rua from carros where carros.nome = '" + nome_carro + "';" );

            while (rs.next()){
                id_carro = String.valueOf(rs.getString("id"));
                rua = String.valueOf(rs.getString("rua"));
                //System.out.println( "ID = " + id_carro );
                //System.out.println( "disponibilidade = " + rua );
            }

            if (rua.equals("true")){
                System.out.println("carro nao disponivel para aluguel");
            }
            else{
                UUID uuid = UUID.randomUUID();


                stmt = c.createStatement();
                String sqlInsert = "Insert Into aluguel values ('" + uuid.toString() + "', '" + id_cliente + "', '" + id_carro + "', '"
                        + data + "', '" + valor + "', '" + desc + "');";
                stmt.executeUpdate(sqlInsert);

                String sqlUpdate = "UPDATE carros set rua = 'true' where nome = '" + nome_carro + "';";
                stmt.executeUpdate(sqlUpdate);
                c.commit();
            }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }

    }

    public void retirarAluguel(){

    }
}
