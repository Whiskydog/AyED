package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos == null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos == null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}

	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}

	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo))
				hijos.eliminar(hijo);
		}
	}

	public ListaEnlazadaGenerica<T> preOrden() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();
		if (this.esVacio())
			return lista;

		lista.agregarFinal(dato);
		if (this.tieneHijos()) {
			hijos.comenzar();
			while (!hijos.fin()) {
				ListaEnlazadaGenerica<T> listaHijo = hijos.proximo().preOrden();
				listaHijo.comenzar();
				while (!listaHijo.fin())
					lista.agregarFinal(listaHijo.proximo());
			}
		}

		return lista;
	}

	public Integer altura() {
		if (this.esVacio() || this.esHoja())
			return 0;

		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		int alturaMaxima = 0;
		hijos.comenzar();
		while (!hijos.fin())
			alturaMaxima = Math.max(alturaMaxima, hijos.proximo().altura());
		return 1 + alturaMaxima;
	}

	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		if (!this.esVacio())
			cola.encolar(this);
		cola.encolar(null);

		int nivel = 0;
		while (!cola.esVacia()) {
			ArbolGeneral<T> actual;
			while (!cola.esVacia() && (actual = cola.desencolar()) != null) {
				if (actual.getDato().equals(dato))
					return nivel;
				if (actual.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = actual.getHijos();
					hijos.comenzar();
					while (!hijos.fin())
						cola.encolar(hijos.proximo());
				}
			}
			if (!cola.esVacia()) {
				cola.encolar(null);
				nivel++;
			}
		}

		return -1;
	}

	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		if (!this.esVacio())
			cola.encolar(this);
		cola.encolar(null);

		int anchoMaximo = 0;
		while (!cola.esVacia()) {
			int anchoActual = 0;
			ArbolGeneral<T> actual;
			while (!cola.esVacia() && (actual = cola.desencolar()) != null) {
				anchoActual++;
				if (actual.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = actual.getHijos();
					hijos.comenzar();
					while (!hijos.fin())
						cola.encolar(hijos.proximo());
				}
			}
			anchoMaximo = Math.max(anchoMaximo, anchoActual);
			if (!cola.esVacia()) {
				cola.encolar(null);
			}
		}

		return anchoMaximo;
	}

	public Boolean esAncestro(T a, T b) {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		while (!cola.esVacia()) {
			ArbolGeneral<T> actual = cola.desencolar();
			if (!actual.esVacio() && actual.getDato().equals(a))
				return actual.nivel(b) != -1;
			if (actual.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos = actual.getHijos();
				hijos.comenzar();
				while (!hijos.fin())
					cola.encolar(hijos.proximo());
			}
		}

		return false;
	}

}