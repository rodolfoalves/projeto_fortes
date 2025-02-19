package classes;

import Front.TelaCadastro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args)throws IOException{
        Scanner in = new Scanner(System.in);


        ArrayList<Carro> carros = new ArrayList<>();
        ArrayList<Aluguel> alugueis = new ArrayList<>();
        Administrador administrador = new Administrador();


        System.out.println("Bem Vindos ao Demo Loja de Aluguel de carros");
        System.out.println("Rodolfo Sobreira Alves");

        int ok = 0;

        do {
            System.out.println("Informe Login");
            String login = in.nextLine();
            System.out.println("Informe Senha");
            String senha = in.nextLine();

            ok = administrador.validarADM(login, senha);

        }while (ok == 0);


        int saida = 1;

        do{
            System.out.println("Informe o que desejas fazer");
            System.out.println("1 para visualizar Carros cadastrados");
            System.out.println("2 para cadastrar Carro");
            System.out.println("3 para dar entrada em um aluguel");
            System.out.println("4 para fechar um aluguel");
            //System.out.println("5 tela demo");
            System.out.println("6 para cadastrar clientes");
            System.out.println("7 para mostrar clientes");
            //System.out.println("8 para cadastrar administradores");
            //System.out.println("9 para mostrar administradores");
            System.out.println("0 para sair do programa");
            int menu = Integer.parseInt(in.nextLine());

            if (menu == 1){
                /*
                if (carros.isEmpty()){
                    System.out.println("nenhum carro cadastrado");
                }
                else{
                    Carro carro = new Carro();
                    carro.listarCarros(carros);
                }
                */

                Carro carro = new Carro();
                carro.listarCarros(carros);

            }

            if (menu == 2){
                Carro carro =new Carro();
                carro = carro.cadastrar_carro();

                carros.add(carro);
                System.out.println("Carro " + carro.getNome() + " de ID " + carro.getID() + " cadastrado com sucesso");
            }

            if (menu == 3){
                /*
                if (carros.isEmpty()){
                    System.out.println("nenhum carro cadastrado");
                }
                else{
                    Carro carro = new Carro();
                    Aluguel aluguel = new Aluguel();

                    System.out.println("Lista de todos os carros cadastrados");
                    carro.listarCarros(carros);



                    System.out.println("Infome qual carro e cor você quer alugar");
                    String carro_alugar = in.nextLine();
                    String cor_alugar = in.nextLine();

                    aluguel.baixaCarro(carros, alugueis, carro_alugar, cor_alugar);
                }
                */

                Aluguel aluguel = new Aluguel();
                aluguel.baixaCarroDB();
            }

            if (menu == 5){
                TelaCadastro executar = new TelaCadastro("Cadastro de Cliente");
                //executar.mostrarTela();
            }

            if (menu == 6){
                Cliente cliente = new Cliente();
                cliente.cadastrarCliente();
            }

            if (menu == 7){
                Cliente cliente = new Cliente();
                cliente.mostrarCadastrosCliente();
            }

            if (menu == 0){
                saida = 0;
            }

        }while (saida!= 0);
    }
}
