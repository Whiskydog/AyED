package tp03.ejercicio3;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

class ContadorArbolPostOrdenTest {
	private ArbolBinario<Integer> arbol;
	private ContadorArbol contador;

	@BeforeEach
	void setUp() throws Exception {
		arbol = new ArbolBinario<>(1);
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<>(2);
		ArbolBinario<Integer> hijoDer = new ArbolBinario<>(3);
		hijoIzq.agregarHijoIzquierdo(new ArbolBinario<>(4));
		hijoIzq.agregarHijoDerecho(new ArbolBinario<>(8));
		hijoDer.agregarHijoIzquierdo(new ArbolBinario<>(6));
		arbol.agregarHijoIzquierdo(hijoIzq);
		arbol.agregarHijoDerecho(hijoDer);

		contador = new ContadorArbolPostOrden(arbol);
	}

	@Test
	void testNumerosPares() {
		ListaGenerica<Integer> lista = contador.numerosPares();
		lista.comenzar();
		assertEquals(4, lista.proximo());
		assertEquals(8, lista.proximo());
		assertEquals(2, lista.proximo());
		assertEquals(6, lista.proximo());
		assertTrue(lista.fin());
	}

}
