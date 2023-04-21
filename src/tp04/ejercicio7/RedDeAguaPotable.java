package tp04.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {
	private ArbolGeneral<String> red;

	public RedDeAguaPotable(ArbolGeneral<String> tuberia) {
		this.red = tuberia;
	}

	public double minimoCaudal(double caudal) {
		return calcularCaudalMinimo(red, caudal);
	}

	private double calcularCaudalMinimo(ArbolGeneral<String> subred, double caudal) {
		if (!subred.tieneHijos())
			return caudal;

		double caudalActual = caudal / subred.getHijos().tamanio();
		double caudalMinimo = caudalActual;
		ListaGenerica<ArbolGeneral<String>> hijos = subred.getHijos();
		hijos.comenzar();
		while (!hijos.fin())
			caudalMinimo = Math.min(caudalMinimo, calcularCaudalMinimo(hijos.proximo(), caudalActual));
		return caudalMinimo;
	}
}
