package tp03.ejercicio3;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbolPostOrden extends ContadorArbol {

	public ContadorArbolPostOrden(ArbolBinario<Integer> arbol) {
		super(arbol);
	}

	@Override
	protected void coleccionarPares(ArbolBinario<Integer> arbol, ListaGenerica<Integer> lista) {
		if (arbol.tieneHijoIzquierdo())
			coleccionarPares(arbol.getHijoIzquierdo(), lista);
		if (arbol.tieneHijoDerecho())
			coleccionarPares(arbol.getHijoDerecho(), lista);
		if (arbol.getDato() % 2 == 0)
			lista.agregarFinal(arbol.getDato());
	}

}
