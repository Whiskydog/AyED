package tp04.ejercicio3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

class RecorridosAGTest {
	private ArbolGeneral<Integer> arbol;
	private RecorridosAG recorridos;

	@BeforeEach
	void setUp() throws Exception {
		recorridos = new RecorridosAG();
		arbol = new ArbolGeneral<Integer>(13);
		arbol.agregarHijo(new ArbolGeneral<Integer>(33));
		arbol.agregarHijo(new ArbolGeneral<Integer>(41));
	}

	@Test
	void testNumerosImparesMayoresQuePreOrden() {
		ListaGenerica<Integer> listaPreOrden = recorridos.numerosImparesMayoresQuePreOrden(arbol, 10);
		listaPreOrden.comenzar();
		assertEquals(13, listaPreOrden.proximo());
		assertEquals(33, listaPreOrden.proximo());
		assertEquals(41, listaPreOrden.proximo());
		listaPreOrden = recorridos.numerosImparesMayoresQuePreOrden(arbol, 45);
		assertTrue(listaPreOrden.esVacia());
	}

	@Test
	void testNumerosImparesMayoresQueInOrden() {
		ListaGenerica<Integer> listaInOrden = recorridos.numerosImparesMayoresQueInOrden(arbol, 10);
		listaInOrden.comenzar();
		assertEquals(33, listaInOrden.proximo());
		assertEquals(13, listaInOrden.proximo());
		assertEquals(41, listaInOrden.proximo());
		listaInOrden = recorridos.numerosImparesMayoresQueInOrden(arbol, 45);
		assertTrue(listaInOrden.esVacia());
	}

	@Test
	void testNumerosImparesMayoresQuePostOrden() {
		ListaGenerica<Integer> listaPostOrden = recorridos.numerosImparesMayoresQuePostOrden(arbol, 10);
		listaPostOrden.comenzar();
		assertEquals(33, listaPostOrden.proximo());
		assertEquals(41, listaPostOrden.proximo());
		assertEquals(13, listaPostOrden.proximo());
		listaPostOrden = recorridos.numerosImparesMayoresQuePostOrden(arbol, 45);
		assertTrue(listaPostOrden.esVacia());
	}
	
	@Test
	void testNumerosImparesMayoresQuePorNiveles() {
		ListaGenerica<Integer> listaPorNiveles = recorridos.numerosImparesMayoresQuePorNiveles(arbol, 10);
		listaPorNiveles.comenzar();
		assertEquals(13, listaPorNiveles.proximo());
		assertEquals(33, listaPorNiveles.proximo());
		assertEquals(41, listaPorNiveles.proximo());
		listaPorNiveles = recorridos.numerosImparesMayoresQuePorNiveles(arbol, 45);
		assertTrue(listaPorNiveles.esVacia());
	}

}
