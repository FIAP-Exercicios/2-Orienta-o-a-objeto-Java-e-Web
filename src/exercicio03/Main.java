package exercicio03;

import java.util.Scanner;

public class Main {
    static BilheteUnico[] bilheteUnicos= new BilheteUnico[3];
    static Scanner sc= new Scanner(System.in);
    static int indice;


    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("-------------------------------------------------------------");
            System.out.println("1- Cadastrar Bilhete");
            System.out.println("2- Carregar Bilhete");
            System.out.println("3- Consultar saldo");
            System.out.println("4- Passar na catraca");
            System.out.println("5- Finalizar");
            System.out.print("Escreva--> ");
            System.out.println("-------------------------------------------------------------");
            opcao= sc.nextInt();


            switch (opcao){

                case 1-> cadastrar();
                case 2-> carregar();
                case 3-> consultar();
                case 4-> passar();
                case 5-> System.out.println("Até Breve!");
                default -> System.out.println("Opção inválida");

            }
            System.out.println();
        } while (opcao !=5);



    }

    public static void passar() {
        BilheteUnico bilheteP= pesquisar();
        if (bilheteP !=null) {
            if (! bilheteP.passarNaCatraca()){
                System.out.println("Saldo Insuficiente, sofra e carregue o bilhete");
            }
            System.out.println("Saldo atual: "+bilheteP.saldo);

        }

    }

    public static void consultar() {
        BilheteUnico bilheteP= pesquisar();
        if (bilheteP !=null) {
            System.out.print("Seu saldo é: " + bilheteP.saldo);
        }
    }

    public static void carregar() {
        BilheteUnico bilheteP= pesquisar();
        if (bilheteP != null){
            System.out.println("Quanto você deseja carregar? ");
            double valor=sc.nextDouble();
            bilheteP.carregar(valor);
        }

    }

    public static void cadastrar() {
        String nome;
        long cpf;
        String tipoTarifa;

        if (indice < bilheteUnicos.length){
            System.out.println("Nome do usuário: ");
            nome=sc.next();
            System.out.println("Me informe CPF: ");
            cpf=sc.nextLong();
            System.out.println("Me informe o tipo da sua tarifa(estudante | professor | comum)");
            tipoTarifa=sc.next();

            bilheteUnicos[indice] = new BilheteUnico(new Usuario(nome, cpf, tipoTarifa));
            indice++;
        }
        else {

            System.out.println("Por favor procure um posto de atendimento e sofra eternamente.");
        }

    }
    public static BilheteUnico pesquisar(){
        long cpf;
        System.out.println("CPF para pesquisa--> ");
        cpf=sc.nextLong();

        for (int i = 0; i < indice; i++) {

            if (bilheteUnicos[i].usuario.cpf ==cpf){
                return bilheteUnicos[i];
            }
        }
        System.out.println("CPF NÃO ENCONTRADO...");
        return null;
    }
}
