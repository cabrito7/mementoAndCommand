public class SumarComando extends ComandoAbstracto {
    private final double valor;

    public SumarComando(Calculadora calculadora, double valor) {
        super(calculadora);
        this.valor = valor;
    }

    @Override
    protected void accion() {
        calculadora.sumar(valor);
    }
}