package tp03.ejercicio1;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArbolBinarioTest {
	private ArbolBinario<Integer> arbol;
	private PrintStream systemOutputStream = System.out;
	private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() throws Exception {
		arbol = new ArbolBinario<Integer>(1);
		System.setOut(new PrintStream(outputStream));
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setOut(systemOutputStream);
	}

	@Test
	void testContarHojas() {
		assertEquals(1, arbol.contarHojas());
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<>(2);
		arbol.agregarHijoIzquierdo(hijoIzq);
		assertEquals(1, arbol.contarHojas());
		ArbolBinario<Integer> hijoDer = new ArbolBinario<>(3);
		arbol.agregarHijoDerecho(hijoDer);
		assertEquals(2, arbol.contarHojas());

		hijoIzq.agregarHijoIzquierdo(new ArbolBinario<>(4));
		assertEquals(2, arbol.contarHojas());
		hijoIzq.agregarHijoDerecho(new ArbolBinario<>(5));
		assertEquals(3, arbol.contarHojas());

		hijoDer.agregarHijoIzquierdo(new ArbolBinario<>(6));
		assertEquals(3, arbol.contarHojas());
		hijoDer.agregarHijoDerecho(new ArbolBinario<>(7));
		assertEquals(4, arbol.contarHojas());
	}

	@Test
	void testEspejo() {
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<>(2);
		ArbolBinario<Integer> hijoDer = new ArbolBinario<>(3);
		hijoIzq.agregarHijoIzquierdo(new ArbolBinario<>(4));
		hijoIzq.agregarHijoDerecho(new ArbolBinario<>(5));
		hijoDer.agregarHijoIzquierdo(new ArbolBinario<>(6));
		arbol.agregarHijoIzquierdo(hijoIzq);
		arbol.agregarHijoDerecho(hijoDer);

		ArbolBinario<Integer> espejo = arbol.espejo();
		ArbolBinario<Integer> espejoHijoIzq = espejo.getHijoIzquierdo();
		ArbolBinario<Integer> espejoHijoDer = espejo.getHijoDerecho();
		assertEquals(3, espejoHijoIzq.getDato());
		assertEquals(2, espejoHijoDer.getDato());
		assertFalse(espejoHijoIzq.tieneHijoIzquierdo());
		assertEquals(6, espejoHijoIzq.getHijoDerecho().getDato());
		assertEquals(5, espejoHijoDer.getHijoIzquierdo().getDato());
		assertEquals(4, espejoHijoDer.getHijoDerecho().getDato());
	}

	@Test
	void testEntreNiveles() {
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<>(2);
		ArbolBinario<Integer> hijoDer = new ArbolBinario<>(3);
		hijoIzq.agregarHijoIzquierdo(new ArbolBinario<>(4));
		hijoIzq.agregarHijoDerecho(new ArbolBinario<>(5));
		hijoDer.agregarHijoIzquierdo(new ArbolBinario<>(6));
		arbol.agregarHijoIzquierdo(hijoIzq);
		arbol.agregarHijoDerecho(hijoDer);

		arbol.entreNiveles(0, 0);
		assertEquals("1\r\n", outputStream.toString());
		outputStream.reset();

		arbol.entreNiveles(0, 1);
		assertEquals("1\n2, 3\r\n", outputStream.toString());
		outputStream.reset();

		arbol.entreNiveles(0, 2);
		assertEquals("1\n2, 3\n4, 5, 6\r\n", outputStream.toString());
		outputStream.reset();

		arbol.entreNiveles(1, 1);
		assertEquals("2, 3\r\n", outputStream.toString());
		outputStream.reset();

		arbol.entreNiveles(2, 2);
		assertEquals("4, 5, 6\r\n", outputStream.toString());
	}

}
