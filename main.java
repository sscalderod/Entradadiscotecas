import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Main extends JPanel {
    private JButton boton_confirmar;
    private JTextField texto_id;
    private JLabel label_numerodocumento;
    private JTextField texto_respuesta;
    private JLabel label_edad;

    // Simulación de una base de datos de identificaciones y edades
    private Map<String, Integer> baseDeDatos = new HashMap<>();

    public Main() {
        
        boton_confirmar = new JButton("Confirmar");
        texto_id = new JTextField(5);
        label_numerodocumento = new JLabel("Número de documento:");
        texto_respuesta = new JTextField(5);
        label_edad = new JLabel("Edad:");

        boton_confirmar.setToolTipText("Presione para confirmar el numero de identidad y buscarlo");
        label_numerodocumento.setToolTipText("Ingrese el numero de documento:");
        texto_respuesta.setEnabled(false);

        setPreferredSize(new Dimension(307, 132));
        setLayout(null);

        add(boton_confirmar);
        add(texto_id);
        add(label_numerodocumento);
        add(texto_respuesta);
        add(label_edad);

      
        boton_confirmar.setBounds(180, 55, 100, 20);
        texto_id.setBounds(180, 15, 100, 25);
        label_numerodocumento.setBounds(15, 15, 139, 25);
        texto_respuesta.setBounds(180, 90, 100, 25);
        label_edad.setBounds(115, 90, 36, 25);

        // Generar identificaciones aleatorias para simular la base de datos
        generarBaseDeDatos();

        // Add action listener to the button
        boton_confirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = texto_id.getText();

                // Verificar si la identificación existe en la base de datos
                if (baseDeDatos.containsKey(id)) {
                    int age = baseDeDatos.get(id);

                    // Verificar si la persona es mayor de edad
                    if (age >= 18) {
                        texto_respuesta.setText("Acceso permitido");
                    } else {
                        texto_respuesta.setText("Acceso denegado (menor de edad)");
                    }
                } else {
                    texto_respuesta.setText("Identificación no válida");
                }
            }
        });
    }

    // generar una base de datos simulada con identificaciones aleatorias y edades
    private void generarBaseDeDatos() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            String id = generarIdentificacionAleatoria();
            int age = random.nextInt(100); // Edad aleatoria entre 0 y 99
            baseDeDatos.put(id, age);
        }
    }

    // Método para generar una identificación aleatoria simulada
    private String generarIdentificacionAleatoria() {
        Random random = new Random();
        StringBuilder idBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) { // Longitud de la identificación
            idBuilder.append(random.nextInt(4)); // Dígitos aleatorios
        }
        return idBuilder.toString();
    }

    public static void main(String[] args) {
      
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Main());
        frame.pack();
        frame.setVisible(true);
    }
}
