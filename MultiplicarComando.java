public class MultiplicarComando extends ComandoAbstracto {
    private final double valor;

    public MultiplicarComando(Calculadora calculadora, double valor) {
        super(calculadora);
        this.valor = valor;
    }

    @Override
    protected void accion() {
        calculadora.multiplicar(valor);
    }
}