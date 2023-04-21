package tp04.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp02.ejercicio2.ListaGenerica;

class ArbolGeneralTest {
	private ArbolGeneral<Integer> arbol;

	@BeforeEach
	void setUp() throws Exception {
		arbol = new ArbolGeneral<Integer>(1);
	}

	@Test
	void testAltura() {
		assertEquals(0, arbol.altura());
		arbol.agregarHijo(new ArbolGeneral<Integer>(2));
		assertEquals(1, arbol.altura());
		arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(3));
		assertEquals(2, arbol.altura());
	}

	@Test
	void testNivel() {
		assertEquals(0, arbol.nivel(1));
		arbol.agregarHijo(new ArbolGeneral<Integer>(2));
		assertEquals(1, arbol.nivel(2));
		arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(3));
		assertEquals(2, arbol.nivel(3));
		assertEquals(-1, arbol.nivel(99));
	}

	@Test
	void testAncho() {
		assertEquals(1, arbol.ancho());
		arbol.setDato(null);
		assertEquals(0, arbol.ancho());
		arbol.agregarHijo(new ArbolGeneral<Integer>(2));
		arbol.agregarHijo(new ArbolGeneral<Integer>(3));
		arbol.agregarHijo(new ArbolGeneral<Integer>(4));
		assertEquals(3, arbol.ancho());
	}

	@Test
	void testPreOrden() {
		arbol.agregarHijo(new ArbolGeneral<Integer>(2));
		arbol.agregarHijo(new ArbolGeneral<Integer>(3));
		arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(4));
		ListaGenerica<Integer> listaPreOrden = arbol.preOrden();
		listaPreOrden.comenzar();
		assertEquals(1, listaPreOrden.proximo());
		assertEquals(2, listaPreOrden.proximo());
		assertEquals(3, listaPreOrden.proximo());
		assertEquals(4, listaPreOrden.proximo());
		assertTrue(listaPreOrden.fin());
	}

	@Test
	void testEsAncestro() {
		arbol.agregarHijo(new ArbolGeneral<Integer>(2));
		assertTrue(arbol.esAncestro(1, 2));
		assertFalse(arbol.esAncestro(2, 1));

		arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(3));
		assertTrue(arbol.esAncestro(1, 3));
		assertTrue(arbol.esAncestro(2, 3));
	}

}
