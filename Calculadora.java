public class Calculadora {
    private double resultado = 0.0;

    public void sumar(double valor) {
        resultado += valor;
    }

    public void restar(double valor) {
        resultado -= valor;
    }

    public void multiplicar(double valor) {
        resultado *= valor;
    }

    public void dividir(double valor) {
        resultado /= valor;
    }

    public void borrar() {
        resultado = 0.0;
    }

    public Memento crearMemento() {
        return new Memento(resultado);
    }

    public void restaurar(Memento m) {
        if (m != null) {
            this.resultado = m.getEstado();
        }
    }

    public double getResultado() {
        return resultado;
    }
}