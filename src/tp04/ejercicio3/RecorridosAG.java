package tp04.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RecorridosAG {

	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> imparesMayoresQueN = new ListaEnlazadaGenerica<>();

		Integer dato = a.getDato();
		if (dato % 2 != 0 && dato > n)
			imparesMayoresQueN.agregarFinal(dato);

		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while (!hijos.fin())
				combinarListas(imparesMayoresQueN, numerosImparesMayoresQuePreOrden(hijos.proximo(), n));
		}

		return imparesMayoresQueN;
	}

	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> imparesMayoresQueN = new ListaEnlazadaGenerica<>();
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.tieneHijos() ? a.getHijos() : null;
		if (hijos != null) {
			hijos.comenzar();
			combinarListas(imparesMayoresQueN, numerosImparesMayoresQueInOrden(hijos.proximo(), n));
		}

		Integer dato = a.getDato();
		if (dato % 2 != 0 && dato > n)
			imparesMayoresQueN.agregarFinal(dato);

		if (hijos != null) {
			while (!hijos.fin())
				combinarListas(imparesMayoresQueN, numerosImparesMayoresQueInOrden(hijos.proximo(), n));
		}

		return imparesMayoresQueN;
	}

	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> imparesMayoresQueN = new ListaEnlazadaGenerica<>();

		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while (!hijos.fin())
				combinarListas(imparesMayoresQueN, numerosImparesMayoresQuePostOrden(hijos.proximo(), n));
		}

		Integer dato = a.getDato();
		if (dato % 2 != 0 && dato > n)
			imparesMayoresQueN.agregarFinal(dato);

		return imparesMayoresQueN;
	}

	private void combinarListas(ListaGenerica<Integer> destino, ListaGenerica<Integer> origen) {
		origen.comenzar();
		while (!origen.fin())
			destino.agregarFinal(origen.proximo());
	}
}
