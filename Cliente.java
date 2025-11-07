public class Cliente {
    private final HistorialComandos gestor;
    private final Calculadora calculadora;

    public Cliente(Calculadora calculadora, HistorialComandos gestor) {
        this.calculadora = calculadora;
        this.gestor = gestor;
    }

    public void botonSumar(double valor) {
        Comando comando = new SumarComando(calculadora, valor);
        gestor.ejecutarComando(comando);
    }

    public void botonRestar(double valor) {
        Comando comando = new RestarComando(calculadora, valor);
        gestor.ejecutarComando(comando);
    }

    public void botonMultiplicar(double valor) {
        Comando comando = new MultiplicarComando(calculadora, valor);
        gestor.ejecutarComando(comando);
    }

    public void botonDividir(double valor) {
        Comando comando = new DividirComando(calculadora, valor);
        gestor.ejecutarComando(comando);
    }

    public void botonBorrar() {
        Comando comando = new BorrarComando(calculadora);
        gestor.ejecutarComando(comando);
    }

    public void botonDeshacer() {
        gestor.deshacer();
    }

    public void botonRehacer() {
        gestor.rehacer();
    }

    public void limpiarRehacer() {
        gestor.limpiarRehacer();
    }
}