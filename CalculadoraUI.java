import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * UI simple con Swing para manipular la calculadora.
 * Ahora delega la creación/ejecución de comandos al Cliente.
 */
public class CalculadoraUI extends JFrame {
    private final Calculadora calculadora = new Calculadora();
    private final HistorialComandos gestor = new HistorialComandos(calculadora);
    private final Cliente cliente = new Cliente(calculadora, gestor);

    private final JLabel resultadoLabel = new JLabel("0.0");
    private final JTextField valorField = new JTextField("0", 10);

    private JButton deshacerBtn;
    private JButton rehacerBtn;

    public CalculadoraUI() {
        super("Calculadora (Memento + Command) - UI separada del Cliente");
        initUI();
    }

    private void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 180);
        setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout(8, 8));
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));

        resultadoLabel.setFont(resultadoLabel.getFont().deriveFont(24f));
        top.add(new JLabel("Resultado: "));
        top.add(resultadoLabel);

        center.add(new JLabel("Valor: "));
        center.add(valorField);

        JButton sumarBtn = new JButton("+");
        JButton restarBtn = new JButton("-");
        JButton multBtn = new JButton("*");
        JButton divBtn = new JButton("/");
        JButton borrarBtn = new JButton("Borrar");

        deshacerBtn = new JButton("Deshacer");
        rehacerBtn = new JButton("Rehacer");

        sumarBtn.addActionListener(e -> botonAccion(() -> cliente.botonSumar(obtenerValor())));
        restarBtn.addActionListener(e -> botonAccion(() -> cliente.botonRestar(obtenerValor())));
        multBtn.addActionListener(e -> botonAccion(() -> cliente.botonMultiplicar(obtenerValor())));
        divBtn.addActionListener(e -> {
            double v = obtenerValor();
            if (v == 0.0) {
                JOptionPane.showMessageDialog(this, "División por cero no permitida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            cliente.botonDividir(v);
            actualizarResultado();
            actualizarBotones();
        });
        borrarBtn.addActionListener(e -> {
            cliente.botonBorrar();
            actualizarResultado();
            actualizarBotones();
        });

        deshacerBtn.addActionListener(e -> {
            cliente.botonDeshacer();
            actualizarResultado();
            actualizarBotones();
        });

        rehacerBtn.addActionListener(e -> {
            cliente.botonRehacer();
            actualizarResultado();
            actualizarBotones();
        });

        bottom.add(sumarBtn);
        bottom.add(restarBtn);
        bottom.add(multBtn);
        bottom.add(divBtn);
        bottom.add(borrarBtn);
        bottom.add(deshacerBtn);
        bottom.add(rehacerBtn);

        main.add(top, BorderLayout.NORTH);
        main.add(center, BorderLayout.CENTER);
        main.add(bottom, BorderLayout.SOUTH);

        setContentPane(main);

        actualizarBotones();
    }

    private double obtenerValor() {
        try {
            return Double.parseDouble(valorField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valor no válido", "Error", JOptionPane.ERROR_MESSAGE);
            throw ex;
        }
    }

    private void botonAccion(Runnable accion) {
        try {
            accion.run();
            actualizarResultado();
            actualizarBotones();
        } catch (NumberFormatException ex) {
            // ya mostrado en obtenerValor()
        }
    }

    private void actualizarResultado() {
        resultadoLabel.setText(String.valueOf(calculadora.getResultado()));
    }

    private void actualizarBotones() {
        deshacerBtn.setEnabled(gestor.puedeDeshacer());
        rehacerBtn.setEnabled(gestor.puedeRehacer());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraUI ui = new CalculadoraUI();
            ui.setVisible(true);
        });
    }
}