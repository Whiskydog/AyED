package tp04.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {

	public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
		cola.encolar(arbol);
		cola.encolar(null);

		int promedioMaximo = 0;
		while (!cola.esVacia()) {
			ArbolGeneral<AreaEmpresa> actual;
			int promedioActual = 0;
			int cantidadActual = 0;
			while (!cola.esVacia() && (actual = cola.desencolar()) != null) {
				if (actual.esVacio())
					continue;

				promedioActual += actual.getDato().getTardanza();
				if (actual.tieneHijos()) {
					ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = actual.getHijos();
					hijos.comenzar();
					while (!hijos.fin())
						cola.encolar(hijos.proximo());
				}
				cantidadActual++;
			}
			promedioActual /= cantidadActual;
			promedioMaximo = Math.max(promedioMaximo, promedioActual);
			if (!cola.esVacia())
				cola.encolar(null);
		}

		return promedioMaximo;
	}
}
