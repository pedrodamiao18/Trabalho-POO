import java.time.LocalDate;
import java.util.ArrayList;

public class Fatura {
    private int numFatura;
    private static int ultimo = 0;
    private LocalDate data;
    private Cliente cliente;
    private double valorTotal;


    public Fatura(Cliente cliente, double valorTotal){
        ultimo++;
        numFatura = ultimo;
        data = LocalDate.now();
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }
}
