package Modelos;

import java.util.Date;
import java.util.List;

public class AlertaInformativa extends Alerta{

	public AlertaInformativa(Tema unTema) {
		super(unTema);
	}
	public AlertaInformativa(Tema unTema, Date unaExp) {
		super(unTema, unaExp);
	}
	@Override
	public void enviarAlerta(List<Usuario> usuarios) {
		this.getTema().enviarAlertaAMisUsuarios(this);
	}
	
}
