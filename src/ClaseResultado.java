import java.text.DecimalFormat;

public class ClaseResultado {
    public String currencyCodeEntrada;
    public String currencyCodeSalida;
    public double montoInicial;
    public double montoFinal;

    public ClaseResultado(Resultado resultado){
        this.currencyCodeEntrada = resultado.base_code();
        this.currencyCodeSalida = resultado.target_code();
        this.montoFinal =  Double.parseDouble(resultado.conversion_result());
        this.montoInicial = (this.montoFinal/Double.parseDouble(resultado.conversion_rate()));
    }


    @Override
    public String toString() {
        return "El currency code inicial es: "
                + currencyCodeEntrada
                + "\n"
                + "El monto de entrada es: "
                + montoInicial
                + "\n"
                + "El currency code de salida es: "
                + currencyCodeSalida
                + "\n"
                + "El monto final es: "
                + montoFinal;
    }
}
