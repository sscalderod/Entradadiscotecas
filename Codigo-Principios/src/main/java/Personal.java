import java.util.ArrayList;
import java.util.List;
public class Personal{
	private int numeroDocumento;
	private boolean capacitado;
	private List<String> personalAutorizado;

	public Personal() {
			this.personalAutorizado = new ArrayList<>();
			this.personalAutorizado.add("98456");
			this.personalAutorizado.add("71254"); 
	}

	public void registrarDocumentoPersonal(int numeroDocumento) {
			this.numeroDocumento = numeroDocumento;
	}
	
	public boolean mostrarCapacitacionPersonal() {
		return capacitado;	
	}

	public List<String> getPersonalAutorizado() {
			return personalAutorizado;
	}
}

