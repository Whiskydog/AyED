package tp03.ejercicio4;

import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
	private ArbolBinario<Integer> red;

	public RedBinariaLlena(ArbolBinario<Integer> red) {
		this.red = red;
	}

	public int retardoReenvio() {
		return retardoMaximo(red);
	}

	private int retardoMaximo(ArbolBinario<Integer> subred) {
		if (subred.esHoja())
			return subred.getDato();

		// No necesitamos preguntar por cada hijo ya que en un arbol
		// binario lleno si un nodo no es hoja DEBE tener dos hijos.
		int retardoIzq = retardoMaximo(subred.getHijoIzquierdo());
		int retardoDer = retardoMaximo(subred.getHijoDerecho());
		return Math.max(retardoIzq, retardoDer) + subred.getDato();
	}
}
