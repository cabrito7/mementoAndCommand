public class DividirComando extends ComandoAbstracto {
    private final double valor;

    public DividirComando(Calculadora calculadora, double valor) {
        super(calculadora);
        this.valor = valor;
    }

    @Override
    protected void accion() {
        calculadora.dividir(valor);
    }
}