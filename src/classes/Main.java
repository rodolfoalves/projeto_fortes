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

                    }
                }
            }

            if (menu == 2){

            }

        }while (saida!= 0);
    }
}
