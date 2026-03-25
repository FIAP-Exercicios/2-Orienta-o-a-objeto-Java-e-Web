package exercicioGeral;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Scanner sc= new Scanner(System.in);
    static Veiculos[] veiculos = new Veiculos[10];
    static Controle[] controle = new Controle[10];
    static int indexVeiculo;
    static int indexControle;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("""
                    
                    #### Estacionamento ParkEasy ####
                    [1] Entrada de veículo
                    [2] Saída de veículo
                    [3] Imprimir veículos estacionados
                    [4] Imprimir a receita
                    [5] Finalizar
                    
                    """);
            opcao=sc.nextInt();

            switch (opcao){

                case 1-> registrarEntrada();
                case 3-> veiculosEstacionados();

            }

        }while(opcao!=5);

    }

    private static void veiculosEstacionados() {

        for (int i = 0; i < indexControle; i++) {
            System.out.println(controle[i].veiculos.placa);
        }

    }

    public static void registrarEntrada(){
        String placa, marca, modelo;
        String nome;
        long cpf;
        String horaEntrada;
        Veiculos veiculoLocal=pesquisar();

        if (veiculoLocal==null){
            System.out.println("------------------VEÍCULOS------------------");
            System.out.println("Placa--> ");
            placa = sc.next().toUpperCase();
            System.out.println("Modelo--> ");
            modelo= sc.next();
            System.out.println("Marca--> ");
            marca= sc.next();
            System.out.println();
            System.out.println("Nome do proprietário--> ");
            nome= sc.next();
            System.out.println("CPF do proprietários--> ");
            cpf = sc.nextLong();

            Proprietario proprietario= new Proprietario(nome, cpf);
            veiculos[indexVeiculo]= new Veiculos(marca, modelo, placa, proprietario);
            indexVeiculo++;
        }
        System.out.println("Hora de entrada (hh:mm) --> ");
        horaEntrada=sc.next();
        controle[indexControle]= new Controle(veiculoLocal, horaEntrada);
        indexControle++;

    }

    public static Veiculos pesquisar(){
        String placa;
        System.out.println("Placa para pesquisa--> ");
        placa = sc.next().toUpperCase();
        for (int i = 0; i < indexControle; i++) {
            if (veiculos[i].placa.equals(placa)){
                return veiculos[i];
            }

        }
        System.out.println("Placa não encontrada");
        return null;
    }


}
