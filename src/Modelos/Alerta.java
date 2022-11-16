package Modelos;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Alerta {
	private Date expiracion;
	private Boolean leida;
	private Tema tema;
	private Boolean alertaParaTodos;
	
	public Alerta(Tema unTema) {
		this.setTema(unTema);
		this.setLeida(false);
		this.setAlertaParaTodos(true);
		
		//SETEO UNA FECHA REMOTA PORQUE, EN PRINCIPIO, NO TIENE UNA FECHA DE EXPIRACION
		Calendar fecha = Calendar.getInstance();
		fecha.set(Calendar.YEAR, 2200);
		fecha.set(Calendar.MONTH, Calendar.DECEMBER);
		fecha.set(Calendar.DAY_OF_MONTH, 1);
		Date date = fecha.getTime();
		this.setExpiracion(date);
	}
	
	public Alerta(Tema unTema, Date unaExpiracion) {
		this(unTema);
		this.setExpiracion(unaExpiracion);
	}
	
	public Date getExpiracion() {
		return expiracion;
	}
	public void setExpiracion(Date unaExpiracion) {
		this.expiracion = unaExpiracion;
	}
	public Boolean getLeida() {
		return leida;
	}
	public void setLeida(Boolean leida) {
		this.leida = leida;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema unTema) {
		this.tema = unTema;
	}

	public Boolean getAlertaParaTodos() {
		return alertaParaTodos;
	}

	public void setAlertaParaTodos(Boolean bool) {
		this.alertaParaTodos = bool;
	}
	
	public abstract void enviarAlerta(List<Usuario> usuarios);

}
