package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelos.*;

class TestTema {


	@Test
	void testEnviarAlertaAMisUsuarios() {
		Usuario u1 = new Usuario("Robertino");
		Usuario u2 = new Usuario("Juan");
		
		Tema t1 = new Tema("Java");
		u1.agregarUnTema(t1);
		u2.agregarUnTema(t1);

		Alerta a1 = new AlertaInformativa(t1);
		
		t1.enviarAlertaAMisUsuarios(a1);
		
		assertEquals(1,u1.getAlertas().size());
		assertEquals(1,u2.getAlertas().size());
		assertNotEquals(2,u2.getAlertas().size());
	}

}
