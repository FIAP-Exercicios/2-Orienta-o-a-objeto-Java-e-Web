package exercicio01;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MonitorEnergia monitor= new MonitorEnergia(3);
        monitor.regitrarNumeros(1);
        monitor.regitrarNumeros(3);

        System.out.print(monitor.calcularMedia());
    }
}