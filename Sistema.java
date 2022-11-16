package Modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Sistema {
	private List<Usuario> usuarios;
	private List<Tema> temas;
	private List<Alerta> alertas;
	
	public Sistema() {
		usuarios = new ArrayList<Usuario>();
		temas = new ArrayList<Tema>();
		alertas= new ArrayList<Alerta>();
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public List<Tema> getTemas() {
		return temas;
	}
	public List<Alerta> getAlertas() {
		return alertas;
	}
	
	public List<Alerta> getAlertasNoExpiradas() {
		List<Alerta> alertasNoExpiradas = this.getAlertas();
		Calendar hoy = Calendar.getInstance();
		alertasNoExpiradas.removeIf(alerta -> alerta.getExpiracion().before(hoy.getTime()));
		return alertasNoExpiradas;
	}
	
	//1 Se pueden registrar usuarios que recibirán alertas. 
	public void registrarUnUsuario(String nombreDeUsuario) {
		Usuario usuarioNuevo = new Usuario(nombreDeUsuario);
		this.getUsuarios().add(usuarioNuevo);
	}
	
	//2 Se pueden registrar temas sobre los cuales se enviarán alertas.
	public void registrarUnTema(String nombreDeTema) {
		Tema temaNuevo = new Tema(nombreDeTema);
		this.getTemas().add(temaNuevo);
	}
	
	//3 Los usuarios pueden optar sobre cuales temas quieren recibir alertas.
	public void agregarUnTemaParaUnUsuario(Tema unTema, Usuario unUsuario) {
		unUsuario.agregarUnTema(unTema);
	}
	
	//4 Se puede enviar una alerta sobre un tema y lo reciben todos los usuarios que han optado recibir alertas de ese tema. 
	//7 Hay dos tipos de alertas:
	//	Informativas: Solo le llega al usuario si ha optado recibir alertas de ese tema
	//	Urgentes: Siempre le llega al usuario la alerta, sin importar si ha optado recibir alertas de ese tema o no.Urgentes: Siempre le llega al usuario la alerta, sin importar si ha optado recibir alertas de ese tema o no.
	public void enviarAlerta(Alerta unaAlerta) {
		unaAlerta.enviarAlerta(getUsuarios());
		this.getAlertas().add(unaAlerta);
	}

	//5 Se puede enviar una alerta sobre un tema a un usuario específico, solo lo recibe ese único usuario.
	//ASUMO QUE EL ENVIO DE UNA ALERTA A UN USUARIO ESPECIFICO, EL USUARIO NO NECESARIAMENTE TIENE EL TEMA ELEGIDO
	public void enviarAlertaA(Usuario unUsuario, Alerta unaAlerta) {
		unaAlerta.setAlertaParaTodos(false);
		unUsuario.agregarUnaAlerta(unaAlerta);
		this.getAlertas().add(unaAlerta);
	}
	
	//6 Una alerta puede tener una fecha y hora de expiración. Las alertas que tienen expiración, no se muestran al usuario si han expirado.
	public List<Alerta> verLasAlertasDeUnUsuario(Usuario unUsuario) {
		return unUsuario.getAlertasNoExpiradas();
	}
	
	//8 Un usuario puede marcar una alerta como leída.
	public void marcarAlertaComoLeidaParaUnUsuario(Usuario unUsuario, Alerta unaAlerta) {
		unUsuario.marcarAlertaComoLeida(unaAlerta);
	}
	
	//9 Se pueden obtener todas las alertas no expiradas de un usuario que aún no ha leído, ordenadas por fecha de la más reciente a la más antigua
	public List<Alerta> verAlertasNoLeidasDeUnUsuario(Usuario unUsuario){
		return unUsuario.obternerAlertasNoLeidas();
	}
	
	//10 Se pueden obtener todas las alertas no expiradas para un tema (de la más reciente a la más antigua). Se muestra para cada alerta si es para todos los usuarios o para uno específico).
	//ASUMO QUE SI ES PARA UN USUARIO ESPECIFICO LA ALERTA NO NECESITO SABER QUIEN, SOLO QUE NO FUE PARA TODOS
	public List<Alerta> obtenerAlertasDeUnTema(Tema unTema){
		List<Alerta> alertaDeUnTema = new ArrayList<Alerta>();
		for (Alerta alerta :this.getAlertasNoExpiradas()) {
			if (alerta.getTema() == unTema) {
				alertaDeUnTema.add(alerta);
			}
		}
		alertaDeUnTema.sort((alerta1, alerta2) -> alerta1.getExpiracion().compareTo(alerta2.getExpiracion()));
		return alertaDeUnTema;
	}

}
