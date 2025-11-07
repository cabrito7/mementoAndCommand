public class RestarComando extends ComandoAbstracto {
    private final double valor;

    public RestarComando(Calculadora calculadora, double valor) {
        super(calculadora);
        this.valor = valor;
    }

    @Override
    protected void accion() {
        calculadora.restar(valor);
    }
}