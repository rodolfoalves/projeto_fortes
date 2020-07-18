package classes;

import java.util.ArrayList;
import java.util.Date;

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
}
