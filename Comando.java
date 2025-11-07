public interface Comando {
    void ejecutar();
    Memento getMementoAntes();
    Memento getMementoDespues();
}