import java.util.Stack;

public class HistorialComandos {
    private final Stack<Comando> historialDeshacer = new Stack<>();
    private final Stack<Comando> historialRehacer = new Stack<>();
    private final Calculadora calculadora;

    public HistorialComandos(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public void ejecutarComando(Comando comando) {
        comando.ejecutar();
        historialDeshacer.push(comando);
        historialRehacer.clear();
    }

    public void deshacer() {
        if (historialDeshacer.isEmpty()) {
            return;
        }
        Comando comando = historialDeshacer.pop();
        Memento antes = comando.getMementoAntes();
        calculadora.restaurar(antes);
        historialRehacer.push(comando);
    }

    public void rehacer() {
        if (historialRehacer.isEmpty()) {
            return;
        }
        Comando comando = historialRehacer.pop();

        comando.ejecutar();
        historialDeshacer.push(comando);
    }

    public void limpiarRehacer() {
        historialRehacer.clear();
    }

    public boolean puedeDeshacer() {
        return !historialDeshacer.isEmpty();
    }

    public boolean puedeRehacer() {
        return !historialRehacer.isEmpty();
    }
}