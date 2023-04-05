package tp03.ejercicio5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp03.ejercicio1.ArbolBinario;

class ProfundidadDeArbolBinarioTest {
	private ArbolBinario<Integer> arbol;
	private ProfundidadDeArbolBinario profundidad;

	@BeforeEach
	void setUp() throws Exception {
		arbol = new ArbolBinario<>(1);

		ArbolBinario<Integer> n1 = new ArbolBinario<>(2);
		ArbolBinario<Integer> n2 = new ArbolBinario<>(3);
		ArbolBinario<Integer> n3 = new ArbolBinario<>(4);
		ArbolBinario<Integer> n4 = new ArbolBinario<>(5);
		ArbolBinario<Integer> n5 = new ArbolBinario<>(6);
		ArbolBinario<Integer> n6 = new ArbolBinario<>(7);
		ArbolBinario<Integer> n7 = new ArbolBinario<>(8);
		ArbolBinario<Integer> n8 = new ArbolBinario<>(9);
		ArbolBinario<Integer> n9 = new ArbolBinario<>(10);
		ArbolBinario<Integer> n10 = new ArbolBinario<>(11);
		ArbolBinario<Integer> n11 = new ArbolBinario<>(12);
		ArbolBinario<Integer> n12 = new ArbolBinario<>(13);
		ArbolBinario<Integer> n13 = new ArbolBinario<>(14);
		ArbolBinario<Integer> n14 = new ArbolBinario<>(15);

		n3.agregarHijoIzquierdo(n7);
		n3.agregarHijoDerecho(n8);
		n4.agregarHijoIzquierdo(n9);
		n4.agregarHijoDerecho(n10);
		n5.agregarHijoIzquierdo(n11);
		n5.agregarHijoDerecho(n12);
		n6.agregarHijoIzquierdo(n13);
		n6.agregarHijoDerecho(n14);
		n1.agregarHijoIzquierdo(n3);
		n1.agregarHijoDerecho(n4);
		n2.agregarHijoIzquierdo(n5);
		n2.agregarHijoDerecho(n6);
		arbol.agregarHijoIzquierdo(n1);
		arbol.agregarHijoDerecho(n2);

		profundidad = new ProfundidadDeArbolBinario(arbol);
	}

	@Test
	void testSumaElementosProfundidad() {
		assertEquals(1, profundidad.sumaElementosProfundidad(0));
		assertEquals(5, profundidad.sumaElementosProfundidad(1));
		assertEquals(22, profundidad.sumaElementosProfundidad(2));
		assertEquals(92, profundidad.sumaElementosProfundidad(3));
	}

}
