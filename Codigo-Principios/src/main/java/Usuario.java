import java.util.ArrayList;
import java.util.List;

public class Usuario {
		private String nombre;
		private int edad;
		private int numeroDocumento;
		private String tipoDocumento;

		public Usuario(String nombre, int edad, int documento) {
				this.nombre = nombre;
				this.edad = edad;
				this.numeroDocumento = documento;
		}

		public int getDocumento() {
				return numeroDocumento;
		}

		public String getNombre() {
				return nombre;
		}

		public int getEdad() {
				return edad;
		}

		public void registrarDocumentoUsuario(int numeroDocumento) {
				this.numeroDocumento = numeroDocumento;
		}

		public void guardarDocumentoUsuario(int numeroDocumento) {
				this.numeroDocumento = numeroDocumento;
		}

		public void registrarNombreUsuario(String nombre) {
				this.nombre = nombre;
		}

		public void guardarNombreUsuario(String nombre) {
				this.nombre = nombre;
		}

		public void verificarEdadUsuario(int edad) {
				
		}

		public int mostrarEdadUsuario() {
				return edad;
		}

		public boolean permitirIngresoUsuario() {
				return false; 
		}

	public static List<Usuario> getUsuariosMenoresEdad() {
			
			List<Usuario> usuariosMenores = new ArrayList<>();
			
			usuariosMenores.add(new Usuario("Juan", 16, 33154));
			usuariosMenores.add(new Usuario("María", 17, 98745));
			
			return usuariosMenores;
	}

	public static List<Usuario> getUsuariosMayoresEdad() {

			List<Usuario> usuariosMayores = new ArrayList<>();
			
			usuariosMayores.add(new Usuario("Pedro", 20, 12345));
			usuariosMayores.add(new Usuario("Ana", 25, 32165));
			
			return usuariosMayores;
	}
}
