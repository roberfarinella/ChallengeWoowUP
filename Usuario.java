package Modelos;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Usuario {
	private String nombreDeUsuario;
	private List<Alerta> alertas;
	private List<Tema> temas;
	
	public Usuario(String nombreDeUsuario) {
		this.setNombreDeUsuario(nombreDeUsuario);
		alertas = new ArrayList<Alerta>();
		temas = new ArrayList<Tema>();
	}
	
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}
	public List<Alerta> getAlertas() {
		return alertas;
	}
	public List<Alerta> getAlertasNoExpiradas() {
		List<Alerta> alertasNoExpiradas = this.getAlertas();
		Calendar hoy = Calendar.getInstance();
		alertasNoExpiradas.removeIf(alerta -> hoy.getTime().after(alerta.getExpiracion()));
		return alertasNoExpiradas;
	}
	
	public void agregarUnaAlerta(Alerta unaAlerta) {
		this.getAlertas().add(unaAlerta);
	}
	
	public List<Tema> getTemas() {
		return temas;
	}
	
	public void agregarUnTema(Tema unTema) {
		this.getTemas().add(unTema);
		unTema.agregarUsuario(this);
	}
	
	public void marcarAlertaComoLeida(Alerta unaAlerta) {
		this.getAlertas().remove(unaAlerta);
		unaAlerta.setLeida(true);
		this.getAlertas().add(unaAlerta);	
		}
	
	public List<Alerta> obternerAlertasNoLeidas(){
		List<Alerta> alertasNoLeidas = new ArrayList<Alerta>();
		for (Alerta alerta :this.getAlertasNoExpiradas()) {
			if (!alerta.getLeida()) {
				alertasNoLeidas.add(alerta);
			}
		}
		alertasNoLeidas.sort((alerta1, alerta2) -> alerta1.getExpiracion().compareTo(alerta2.getExpiracion()));
		return alertasNoLeidas;
	}
	
}
