
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplicacion extends JPanel implements ActionListener {
		private JButton boton_confirmar;
		private JTextField texto_id;
		private JLabel label_numerodocumento;
		private JTextField texto_respuesta;
		private JLabel label_edad;
		private JLabel verificarper;
		private JLabel preguntacapacitado;
		private JTextField estacapacitado;
		private JTextField separador;
		private JTextField docusuario;
		private JLabel verifiusuari;
		private JLabel numerodoc;
		private JLabel nombre;
		private JTextField nombreusuario;
		private JButton confirmar;
		private JLabel notif;
		private JTextField sep;
		private JTextField notificando;
		private JTextField informa;
		private JLabel preguntaIngreso;
		private JTextField respuestaIngreso;
		private JLabel audycomp;
		private JLabel aud;
		private JLabel comp;
		private JLabel guardacomp;
		private JLabel guardarnomb;

		public Aplicacion() {
				
			boton_confirmar = new JButton ("Confirmar");
			texto_id = new JTextField (5);
			label_numerodocumento = new JLabel ("Numero de documento:");
			texto_respuesta = new JTextField (5);
			label_edad = new JLabel ("Edad:");
			verificarper = new JLabel ("Verificacion personal");
			preguntacapacitado = new JLabel ("¿Esta capacitado?");
			estacapacitado = new JTextField (5);
			separador = new JTextField (5);
			docusuario = new JTextField (5);
			verifiusuari = new JLabel ("Verificacion usuario");
			numerodoc = new JLabel ("Numero de documento:");
			nombre = new JLabel ("Nombre:");
			nombreusuario = new JTextField (5);
			confirmar = new JButton ("Confirmar");
			notif = new JLabel ("Notificar");
			sep = new JTextField (5);
			notificando = new JTextField (5);
			informa = new JTextField (5);
			preguntaIngreso = new JLabel ("¿Puede ingresar?");
			respuestaIngreso = new JTextField (5);
			audycomp = new JLabel ("Auditorias y comparendos");
			aud = new JLabel ("Registrar auditoria");
			comp = new JLabel ("Registrar comparendo (si es necesario)");
			guardacomp = new JLabel ("Guardando comparendos");
			guardarnomb = new JLabel ("Guardando nombre y documento");

			texto_respuesta.setEnabled (false);
			estacapacitado.setEnabled (false);
			respuestaIngreso.setEnabled (false);
			notificando.setEnabled(false);
			informa.setEnabled(false);

			setPreferredSize (new Dimension (944, 557));
			setLayout (null);

			add (boton_confirmar);
			boton_confirmar.addActionListener(this);
			add (texto_id);
			add (label_numerodocumento);
			add (texto_respuesta);
			add (label_edad);
			add (verificarper);
			add (preguntacapacitado);
			add (estacapacitado);
			add (separador);
			add (docusuario);
			add (verifiusuari);
			add (numerodoc);
			add (nombre);
			add (nombreusuario);
			add (confirmar);
			confirmar.addActionListener(this);
			add (notif);
			add (sep);
			add (notificando);
			add (informa);
			add (preguntaIngreso);
			add (respuestaIngreso);
			add (audycomp);
			add (aud);
			add (comp);
			add (guardacomp);
			add (guardarnomb);

			boton_confirmar.setBounds (180, 95, 100, 20);
			texto_id.setBounds (180, 55, 100, 25);
			label_numerodocumento.setBounds (25, 50, 139, 25);
			texto_respuesta.setBounds (180, 370, 100, 25);
			label_edad.setBounds (125, 370, 36, 25);
			verificarper.setBounds (110, 5, 126, 25);
			preguntacapacitado.setBounds (50, 135, 108, 25);
			estacapacitado.setBounds (180, 135, 100, 25);
			separador.setBounds (-60, 180, 400, 10);
			docusuario.setBounds (180, 235, 100, 25);
			verifiusuari.setBounds (110, 195, 149, 25);
			numerodoc.setBounds (25, 235, 135, 25);
			nombre.setBounds (110, 280, 57, 25);
			nombreusuario.setBounds (180, 280, 100, 25);
			confirmar.setBounds (180, 325, 100, 25);
			notif.setBounds (135, 460, 100, 25);
			sep.setBounds (-10, 450, 344, 10);
			notificando.setBounds (30, 495, 125, 25);
			informa.setBounds (180, 495, 125, 25);
			preguntaIngreso.setBounds (60, 415, 104, 25);
			respuestaIngreso.setBounds (180, 415, 100, 25);
			audycomp.setBounds (105, 535, 100, 25);
			aud.setBounds (15, 570, 100, 25);
			comp.setBounds (190, 570, 100, 25);
			guardacomp.setBounds (190, 605, 100, 25);
			guardarnomb.setBounds (330, 325, 100, 25);
		}
	
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == boton_confirmar) {
				handleBotonConfirmar();
			} else if (e.getSource() == confirmar) {
				handleConfirmarButton();
			}

		}
	
		private void handleBotonConfirmar() {
			Personal personal = new Personal(); 
			List<String> personalAutorizado = personal.getPersonalAutorizado(); 
			String id = texto_id.getText(); 
			boolean encontrado = false;

			for (String idPersonalAutorizado : personalAutorizado) {
				if (idPersonalAutorizado.equals(id)) {
					encontrado = true;
					estacapacitado.setText("Si"); 
					break;
				} else {
					encontrado = false;
					estacapacitado.setText("No"); 
				}
			} 
		}

		private void handleConfirmarButton() {
			String nombre = nombreusuario.getText(); 
			String idText = docusuario.getText(); 
			if (!idText.isEmpty()) { 
				int id = Integer.parseInt(idText); 
				boolean encontrado = false;
				List<Usuario> usuariosMenores = Usuario.getUsuariosMenoresEdad();
				if (usuariosMenores != null) {
					for (Usuario usuario : usuariosMenores) {
						if (usuario.getNombre().equals(nombre) && usuario.getDocumento() == id) {
							encontrado = true;
							String edad = String.valueOf(usuario.getEdad());
							texto_respuesta.setText(edad); 
							respuestaIngreso.setText("No");
							notificando.setText("Notificando Adultos");
							informa.setText("Notificando Autoridades");
							break;
						}
					}
				} else {
					return; 
				}
				if (!encontrado) {
					List<Usuario> usuariosMayores = Usuario.getUsuariosMayoresEdad();
					if (usuariosMayores != null) {
						for (Usuario usuario : usuariosMayores) {
							if (usuario.getNombre().equals(nombre) && usuario.getDocumento() == id) {
								encontrado = true;
								String edad = String.valueOf(usuario.getEdad());
								texto_respuesta.setText(edad); 
								respuestaIngreso.setText("Si");
								notificando.setText("No notificando Adultos");
								informa.setText("No notificando Autoridades");
								break;
							}
						}
					} else {
						return; 
					}
			}
			if (!encontrado) {
				texto_respuesta.setText("Usuario no encontrado en la base de datos."); 
				respuestaIngreso.setText("No");
				notificando.setText("No notificando Adultos");
				informa.setText("No notificando Autoridades");
			}
		} else {
			texto_respuesta.setText("Por favor ingrese un número de documento."); 
			respuestaIngreso.setText("No");
			notificando.setText("No notificando Adultos");
			informa.setText("No notificando Autoridades");
		}
	}

		public static void main (String[] args) {
				JFrame frame = new JFrame ("Aplicacion");
				frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add (new Aplicacion());
				frame.pack();
				frame.setVisible (true);
		}
}
