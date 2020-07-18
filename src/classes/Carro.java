package classes;

import jdk.internal.cmm.SystemResourcePressureImpl;

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

        return carro;
    }

    public void listarCarros(ArrayList<Carro> carros){
        for (int i=0;i < carros.size();i++){
            System.out.println(carros.get(i).getNome() + " da marca " + carros.get(i).getMarca() + " da cor " + carros.get(i).getCor() + " cuja descrição é " + carros.get(i).getDesc() + "\n");
        }
    }
}
