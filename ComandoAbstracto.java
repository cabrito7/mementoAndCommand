public abstract class ComandoAbstracto implements Comando {
    protected final Calculadora calculadora;
    protected Memento mementoAntes;
    protected Memento mementoDespues;

    public ComandoAbstracto(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    @Override
    public void ejecutar() {
        // Captura estado antes
        mementoAntes = calculadora.crearMemento();
        // Ejecuta la acción concreta
        accion();
        // Captura estado después
        mementoDespues = calculadora.crearMemento();
    }

    protected abstract void accion();

    @Override
    public Memento getMementoAntes() {
        return mementoAntes;
    }

    @Override
    public Memento getMementoDespues() {
        return mementoDespues;
    }
}