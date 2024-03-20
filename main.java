import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Main extends JPanel {
    private JButton boton_confirmar;
    private JTextField texto_id;
    private JLabel label_numerodocumento;
    private JLabel label_resultado;
    private JLabel label_edad;
    private JLabel verificarper;
    private JLabel preguntacapacitado;
    private JTextField estacapacitado;
    private JTextField separador;
    private JTextField docusuario;
    private JLabel verifisuauri;
    private JLabel numerodoc;
    private JLabel nombre;
    private JTextField nombreusuario;
    private JButton confirmar;
    private JLabel notif;
    private JTextField sep;
    private JLabel notificando;
    private JLabel informa;

    public Main() {
        // Set layout
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Add components
        // Número de documento
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        add(label_numerodocumento = new JLabel("Número de documento:"), constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(texto_id = new JTextField(10), constraints);

        // Botón confirmar
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(boton_confirmar = new JButton("Confirmar"), constraints);

        // Resultado
        constraints.gridx = 0;constraints.gridy = 2;
        constraints.gridwidth = 2;
        add(label_resultado = new JLabel(), constraints);

        // Verificación personal
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        add(verificarper = new JLabel("Verificación personal"), constraints);

        // Pregunta capacitado
        constraints.gridx = 0;
        constraints.gridy = 4;
        add(preguntacapacitado = new JLabel("¿Está capacitado?"), constraints);

        // Capacitado
        constraints.gridx = 1;
        constraints.gridy = 4;
        add(estacapacitado = new JTextField(5), constraints);

        // Verificación usuario
        constraints.gridx = 0;
        constraints.gridy = 5;
        add(verifisuauri = new JLabel("Verificación usuario"), constraints);

        // Número de documento
        constraints.gridx = 0;
        constraints.gridy = 6;
        add(numerodoc = new JLabel("Número de documento:"), constraints);

        // Nombre
        constraints.gridx = 1;
        constraints.gridy = 6;
        add(nombre = new JLabel("Nombre:"), constraints);

        // Documento usuario
        constraints.gridx = 0;
        constraints.gridy = 7;
        add(docusuario = new JTextField(5), constraints);

        // Nombre usuario
        constraints.gridx = 1;
        constraints.gridy = 7;
        add(nombreusuario = new JTextField(5), constraints);

        // Confirmar
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 2;
        add(confirmar = new JButton("Confirmar"), constraints);

        // Notificar
        constraints.gridx = 0;
        constraints.gridy = 9;
constraints.gridwidth = 1;
        add(notif = new JLabel("Notificar"), constraints);

        // Separador
        constraints.gridx = 1;
        constraints.gridy = 9;
        add(sep = new JTextField(5), constraints);

        // Notificando
        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.gridwidth = 2;
        add(notificando = new JLabel("Si es menor de edad:"), constraints);

        // Información
        constraints.gridx = 0;
        constraints.gridy = 11;
        constraints.gridwidth = 2;
        add(informa = new JLabel("Notificando..."), constraints);

        // Asignar IDs específicas con valores definidos

        // Asignar edades específicas para IDs seleccionadas
        Map<String, Integer> idAges = new HashMap<>();
        idAges.put("1034989237", 18);
        idAges.put("2034989236", 25);
        idAges.put("3034989235", 32);

        // ActionListener para el botón confirmar
        boton_confirmar.addActionListener(e -> {
            String id = texto_id.getText();
            boolean isValidId = id.matches("\\d{9}");
            if (isValidId) {
                if (idAges.containsKey(id)) {
                    int age = idAges.get(id);
                    if (age >= 18) {
                        label_resultado.setText("Es mayor de edad");
                    } else {
                        label_resultado.setText("Es menor de edad");
                    }
                } else {
                    label_resultado.setText("No hay información disponible para esta ID");
                }
            } else {
                label_resultado.setText("ID inválida");
            }
        });
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Entrega2codigo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Main());
        frame.pack();
        frame.setVisible(true);
    }
}
