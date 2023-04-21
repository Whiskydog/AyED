package tp04.ejercicio7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp04.ejercicio1.ArbolGeneral;

class RedDeAguaPotableTest {
	private RedDeAguaPotable red;

	@BeforeEach
	void setUp() throws Exception {
		ArbolGeneral<String> tuberia = new ArbolGeneral<String>("A");
		tuberia.agregarHijo(new ArbolGeneral<String>("B"));
		tuberia.agregarHijo(new ArbolGeneral<String>("C"));
		tuberia.agregarHijo(new ArbolGeneral<String>("D"));
		tuberia.agregarHijo(new ArbolGeneral<String>("E"));

		tuberia.getHijos().elemento(2).agregarHijo(new ArbolGeneral<String>("F"));
		tuberia.getHijos().elemento(2).agregarHijo(new ArbolGeneral<String>("G"));
		tuberia.getHijos().elemento(2).getHijos().elemento(2).agregarHijo(new ArbolGeneral<String>("L"));

		tuberia.getHijos().elemento(3).agregarHijo(new ArbolGeneral<String>("H"));
		tuberia.getHijos().elemento(3).agregarHijo(new ArbolGeneral<String>("I"));
		tuberia.getHijos().elemento(3).agregarHijo(new ArbolGeneral<String>("J"));
		tuberia.getHijos().elemento(3).agregarHijo(new ArbolGeneral<String>("K"));
		tuberia.getHijos().elemento(3).agregarHijo(new ArbolGeneral<String>("O"));
		tuberia.getHijos().elemento(3).getHijos().elemento(3).agregarHijo(new ArbolGeneral<String>("M"));
		tuberia.getHijos().elemento(3).getHijos().elemento(3).agregarHijo(new ArbolGeneral<String>("N"));

		red = new RedDeAguaPotable(tuberia);
	}

	@Test
	void testMinimoCaudal() {
		assertEquals(25d, red.minimoCaudal(1000d));
	}

}
