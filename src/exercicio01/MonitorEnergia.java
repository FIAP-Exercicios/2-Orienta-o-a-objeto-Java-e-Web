package exercicio01;

public class MonitorEnergia {

    double[] consumoDiario;
    int contador;

    public MonitorEnergia(int tamanho) {
        this.consumoDiario = new double[tamanho];

    }

    public void regitrarNumeros(double valor){
        if (contador<consumoDiario.length) {
            consumoDiario[contador] = valor;
            contador++;
        }
    }

    public double calcularMedia(){
        double media=0;
        for (double valor : consumoDiario){

            media += valor;
        }
        return media/ consumoDiario.length;
    }
    public double calcularMedia(int inicio, int fim){
        double media=0;

        for (int i = inicio; i < fim; i++) {

            media += i;

        }
        return media / (fim - inicio);

    }
}
