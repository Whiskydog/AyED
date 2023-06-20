package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Bookkeeper<T> {
	private boolean[] visitados;
	private int[] previos;
	private int[] distancias;
	private ListaGenerica<Vertice<T>> vertices;

	public Bookkeeper(Grafo<T> grafo) {
		vertices = grafo.listaDeVertices();
		visitados = new boolean[vertices.tamanio() + 1];
		previos = new int[vertices.tamanio() + 1];
		distancias = new int[vertices.tamanio() + 1];
		for (int i = 1; i < distancias.length; i++)
			distancias[i] = Integer.MAX_VALUE;
	}

	public ListaGenerica<T> obtenerCamino(int posicionDestino) {
		ListaGenerica<T> camino = new ListaEnlazadaGenerica<>();
		if (previos[posicionDestino] != 0)
			obtenerCamino(camino, posicionDestino);
		return camino;
	}

	private void obtenerCamino(ListaGenerica<T> camino, int previo) {
		camino.agregarInicio(vertices.elemento(previo).dato());
		if (previo != previos[previo])
			obtenerCamino(camino, previos[previo]);
	}

	public int indiceNoVisitadoMinimaDistancia() {
		int minimo = Integer.MAX_VALUE;
		int indiceMinimo = -1;
		for (int i = 1; i < distancias.length; i++) {
			if (!visitados[i] && distancias[i] < minimo) {
				minimo = distancias[i];
				indiceMinimo = i;
			}
		}

		return indiceMinimo;
	}

	public void setDistancia(int indice, int distancia) {
		distancias[indice] = distancia;
	}

	public int getDistancia(int indice) {
		return distancias[indice];
	}

	public void setPrevio(int indice, int indicePrevio) {
		previos[indice] = indicePrevio;
	}

	public void marcarVisitado(int indice) {
		visitados[indice] = true;
	}

	public boolean esVisitado(int indice) {
		return visitados[indice];
	}

}
