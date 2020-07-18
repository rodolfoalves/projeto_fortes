package database;

import classes.Carro;
import classes.Cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "aluguel")

public class Dao_Aluguel {
    @Id
    private String ID;
    @Column
    private Cliente cliente;
    @Column
    private Carro carro;
    @Column
    private Date data_de_locacao;
    @Column
    private Date data_de_devolucao;
    @Column
    private int valor;
    @Column
    private String desc;

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
}
