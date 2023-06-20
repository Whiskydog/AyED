package tp06.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Dijkstra<T> {
	private Grafo<T> grafo;
	private Bookkeeper<T> bookkeeper;

	public Dijkstra(Grafo<T> grafo, Vertice<T> origen, int pesoMaximo) {
		this.grafo = grafo;
		bookkeeper = new Bookkeeper<>(grafo);
		bookkeeper.setDistancia(origen.getPosicion(), 0);
		bookkeeper.setPrevio(origen.getPosicion(), origen.getPosicion());

		calcular(pesoMaximo);
	}

	public void calcular(int pesoMaximo) {
		int indiceVerticeMasCercano;
		while ((indiceVerticeMasCercano = bookkeeper.indiceNoVisitadoMinimaDistancia()) != -1) {
			bookkeeper.marcarVisitado(indiceVerticeMasCercano);
			Vertice<T> verticeMasCercano = grafo.vetice(indiceVerticeMasCercano);
			ListaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(verticeMasCercano);
			aristas.comenzar();
			while (!aristas.fin()) {
				Arista<T> arista = aristas.proximo();
				Vertice<T> adyacente = arista.verticeDestino();
				if (!bookkeeper.esVisitado(adyacente.getPosicion())) {
					int distancia = arista.peso() + bookkeeper.getDistancia(indiceVerticeMasCercano);
					if (arista.peso() <= pesoMaximo && bookkeeper.getDistancia(adyacente.getPosicion()) > distancia) {
						bookkeeper.setDistancia(adyacente.getPosicion(), distancia);
						bookkeeper.setPrevio(adyacente.getPosicion(), indiceVerticeMasCercano);
					}
				}
			}
		}
	}
	
	public int distanciaHasta(Vertice<T> destino) {
		return bookkeeper.getDistancia(destino.getPosicion());
	}

	public ListaGenerica<T> obtenerCamino(Vertice<T> destino) {
		return bookkeeper.obtenerCamino(destino.getPosicion());
	}
}
