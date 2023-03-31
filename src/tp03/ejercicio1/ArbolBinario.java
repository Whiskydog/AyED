package tp03.ejercicio1;

import tp02.ejercicio3.ColaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * 
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	public int contarHojas() {
		if (this.esHoja())
			return 1;

		int cantHojas = 0;
		if (this.tieneHijoIzquierdo())
			cantHojas += hijoIzquierdo.contarHojas();
		if (this.tieneHijoDerecho())
			cantHojas += hijoDerecho.contarHojas();
		return cantHojas;
	}

	public ArbolBinario<T> espejo() {
		ArbolBinario<T> espejado = new ArbolBinario<>(getDato());
		if (this.tieneHijoDerecho())
			espejado.agregarHijoIzquierdo(hijoDerecho.espejo());
		if (this.tieneHijoIzquierdo())
			espejado.agregarHijoDerecho(hijoIzquierdo.espejo());

		return espejado;
	}

	public void entreNiveles(int n, int m) {
		StringBuilder sb = new StringBuilder();
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);

		int nivel = 0;
		while (!cola.esVacia()) {
			ArbolBinario<T> actual;
			while (!cola.esVacia() && (actual = cola.desencolar()) != null) {
				if (nivel >= n)
					sb.append(String.format("%s, ", actual.getDato()));
				if (actual.tieneHijoIzquierdo())
					cola.encolar(actual.getHijoIzquierdo());
				if (actual.tieneHijoDerecho())
					cola.encolar(actual.getHijoDerecho());
			}
			if (sb.length() >= 2)
				sb.delete(sb.length() - 2, sb.length());

			if (!cola.esVacia()) {
				if (++nivel > m)
					break;
				if (!sb.isEmpty())
					sb.append('\n');
				cola.encolar(null);
			}
		}

		System.out.println(sb.toString());
	}
}
