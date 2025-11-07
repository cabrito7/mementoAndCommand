public class BorrarComando extends ComandoAbstracto {

    public BorrarComando(Calculadora calculadora) {
        super(calculadora);
    }

    @Override
    protected void accion() {
        calculadora.borrar();
    }
}