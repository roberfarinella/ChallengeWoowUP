package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelos.*;

class TestUsuario {
	
	@Test
	void testObternerUsuario() {
		Usuario u1 = new Usuario("Robertino");
		assertEquals("Robertino",u1.getNombreDeUsuario());
		
		Tema t1 = new Tema("Deportes");
		u1.agregarUnTema(t1);
		assertEquals(1,u1.getTemas().size());

		Alerta a1 = new AlertaInformativa(t1);
		u1.agregarUnaAlerta(a1);
		assertEquals(1,u1.getAlertas().size());
	}
	
	@Test
	void testMarcarAlertaComoLeida() {
		Usuario u1 = new Usuario("Robertino");
		
		Tema t1 = new Tema("Deportes");
		u1.agregarUnTema(t1);
		
		Alerta a1 = new AlertaInformativa(t1);
		u1.agregarUnaAlerta(a1);
		
		assertEquals(1,u1.getAlertas().size());
		
		assertEquals(false,u1.getAlertas().get(0).getLeida());
		
		u1.marcarAlertaComoLeida(a1);
		assertEquals(true,u1.getAlertas().get(0).getLeida());
	}
	
	@Test
	void obternerAlertasNoLeidas() {
		Usuario u1 = new Usuario("Robertino");
		
		Tema t1 = new Tema("Deportes");
		Tema t2 = new Tema("Lenguajes de programacion");
		u1.agregarUnTema(t1);
		u1.agregarUnTema(t2);
		
		Alerta a1 = new AlertaInformativa(t1);
		u1.agregarUnaAlerta(a1);
		Alerta a2 = new AlertaInformativa(t2);
		u1.agregarUnaAlerta(a2);
		
		assertEquals(2,u1.obternerAlertasNoLeidas().size());
		
		u1.marcarAlertaComoLeida(a1);
		assertEquals(1,u1.obternerAlertasNoLeidas().size());
		
		assertEquals(2,u1.getAlertas().size());
		
	}
}
