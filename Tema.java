package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Tema {
	private String nombreDelTema;
	private List<Usuario> usuariosConEsteTema;

	public Tema(String nombreTema) {
		this.setNombreDelTema(nombreTema);
		usuariosConEsteTema = new ArrayList<Usuario>();
	}
	
	public String getNombreDelTema() {
		return nombreDelTema;
	}

	public void setNombreDelTema(String nombreDelTema) {
		this.nombreDelTema = nombreDelTema;
	}

	public List<Usuario> getUsuariosConEsteTema() {
		return usuariosConEsteTema;
	}
	
	public void agregarUsuario(Usuario unUsuario) {
		this.getUsuariosConEsteTema().add(unUsuario);
	}

	public void enviarAlertaAMisUsuarios(Alerta unaAlerta) {
		this.getUsuariosConEsteTema().forEach(usuario -> usuario.agregarUnaAlerta(unaAlerta));
	}
}
