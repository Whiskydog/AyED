package tp06.ejercicio4;

import java.io.IOException;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.GraphBuilder;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Recorridos<T> {
	public static void main(String[] args) throws IOException {
		Recorridos<String> recorridos = new Recorridos<String>(new GraphBuilder("map.json").build());
		System.out.println(String.format("DFS: %s", recorridos.dfs()));
		System.out.println(String.format("BFS: %s", recorridos.bfs()));
	}

	private Grafo<T> grafo;

	public Recorridos(Grafo<T> grafo) {
		this.grafo = grafo;
	}

	public ListaGenerica<Vertice<T>> bfs() {
		ListaGenerica<Vertice<T>> search = new ListaEnlazadaGenerica<>();
		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
		boolean[] visitados = new boolean[vertices.tamanio() + 1];
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<>();

		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<T> vertice = vertices.proximo();
			if (!visitados[vertice.getPosicion()]) {
				breadthFirstSearch(vertice, search, visitados, cola);
			}
		}

		return search;
	}

	private void breadthFirstSearch(Vertice<T> origen, ListaGenerica<Vertice<T>> search, boolean[] visitados,
			ColaGenerica<Vertice<T>> cola) {
		visitados[origen.getPosicion()] = true;
		cola.encolar(origen);
		while (!cola.esVacia()) {
			Vertice<T> vertice = cola.desencolar();
			search.agregarFinal(vertice);
			ListaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(vertice);
			aristas.comenzar();
			while (!aristas.fin()) {
				Vertice<T> destino = aristas.proximo().verticeDestino();
				if (!visitados[destino.getPosicion()]) {
					visitados[destino.getPosicion()] = true;
					cola.encolar(destino);
				}
			}
		}
	}

	public ListaGenerica<Vertice<T>> dfs() {
		ListaGenerica<Vertice<T>> search = new ListaEnlazadaGenerica<>();
		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
		boolean[] visitados = new boolean[vertices.tamanio() + 1];

		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<T> vertice = vertices.proximo();
			if (!visitados[vertice.getPosicion()])
				depthFirstSearch(vertice, search, visitados);
		}

		return search;
	}

	private void depthFirstSearch(Vertice<T> origen, ListaGenerica<Vertice<T>> search, boolean[] visitados) {
		search.agregarFinal(origen);
		visitados[origen.getPosicion()] = true;
		ListaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(origen);
		aristas.comenzar();
		while (!aristas.fin()) {
			Vertice<T> adyacente = aristas.proximo().verticeDestino();
			if (!visitados[adyacente.getPosicion()])
				depthFirstSearch(adyacente, search, visitados);
		}
	}
}
