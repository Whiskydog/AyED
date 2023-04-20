package tp04.ejercicio5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp04.ejercicio1.ArbolGeneral;

class AnalizadorArbolTest {
	private AnalizadorArbol analizador;
	private ArbolGeneral<AreaEmpresa> arbol;

	@BeforeEach
	void setUp() throws Exception {
		analizador = new AnalizadorArbol();
		arbol = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("M", 14));
		ArbolGeneral<AreaEmpresa> arbolAreaJ = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("J", 13));
		arbolAreaJ.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("A", 4)));
		arbolAreaJ.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("B", 7)));
		arbolAreaJ.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("C", 5)));
		ArbolGeneral<AreaEmpresa> arbolAreaK = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("K", 25));
		arbolAreaK.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("D", 6)));
		arbolAreaK.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("E", 10)));
		arbolAreaK.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("F", 18)));
		ArbolGeneral<AreaEmpresa> arbolAreaL = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("L", 10));
		arbolAreaL.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("G", 9)));
		arbolAreaL.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("H", 12)));
		arbolAreaL.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("I", 19)));
		arbol.agregarHijo(arbolAreaJ);
		arbol.agregarHijo(arbolAreaK);
		arbol.agregarHijo(arbolAreaL);
	}

	@Test
	void testDevolverMaximoPromedio() {
		assertEquals(16, analizador.devolverMaximoPromedio(arbol));
	}

}
