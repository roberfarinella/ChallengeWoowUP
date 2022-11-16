package Modelos;

import java.util.Date;
import java.util.List;

public class AlertaUrgente extends Alerta{
	public AlertaUrgente(Tema unTema) {
		super(unTema);
	}
	public AlertaUrgente(Tema unTema, Date unaExp) {
		super(unTema, unaExp);
	}
	@Override
	public void enviarAlerta(List<Usuario> usuarios) {
		for (Usuario usuario :usuarios) {
			usuario.agregarUnaAlerta(this);
		}
	}
}
