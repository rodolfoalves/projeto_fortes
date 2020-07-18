package classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        ArrayList<Carro> carros = new ArrayList<>();
        ArrayList<Administrador> administradors = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();

        int saida = 1;

        do{
            System.out.println("Informe o que desejas fazer");
            System.out.println("1 para visualizar Carros cadastrados");
            System.out.println("2 para cadastrar Carro");
            System.out.println("3 para marcar uma tarefa como concluída");
            System.out.println("4 para pesquisar uma tarefa pelo título");
            System.out.println("5 para mostrar todas as tarefas concluídas");
            System.out.println("6 para mostrar todas as tarefas pendentes");
            System.out.println("0 para sair do programa");
            int menu = Integer.parseInt(in.nextLine());

            if (menu == 1){
                if (carros.isEmpty()){
                    System.out.println("nenhum carro cadastrado");
                }
                else{
                    for (int i=0;i < carros.size();i++){
                        System.out.println(carros.get(i).getNome() + " da marca " + carros.get(i).getMarca() + " da cor " + carros.get(i).getCor() + " cuja descrição é " + carros.get(i).getDesc() + "\n");
                    }
                }
            }

            if (menu == 2){
                Carro carro =new Carro();
                carro = carro.cadastrar_carro();

                carros.add(carro);
                System.out.println("Carro " + carro.getNome() + " de ID " + carro.getID() + " cadastrado com sucesso");
            }

            if (menu == 0){
                saida = 0;
            }

        }while (saida!= 0);
    }
}
