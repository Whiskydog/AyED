package tp06.ejercicio6;

import java.io.IOException;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.GraphBuilder;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Solucion {
	public static void main(String[] args) throws IOException {
		Grafo<String> lugares = new GraphBuilder("src/tp06/ejercicio6/lugares.json").build();
		ListaGenerica<String> lugaresRestringidos = new ListaEnlazadaGenerica<>();
		lugaresRestringidos.agregarFinal("Palacio Real");
		lugaresRestringidos.agregarFinal("Akker Brigge");
		System.out.println(new Solucion().paseoEnBici(lugares, "Museo Vikingo", 120, lugaresRestringidos));
	}

	ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo,
			ListaGenerica<String> lugaresRestringidos) {
		boolean[] visitados = new boolean[lugares.listaDeVertices().tamanio() + 1];
		lugaresRestringidos.comenzar();
		while (!lugaresRestringidos.fin())
			visitados[obtenerVertice(lugares, lugaresRestringidos.proximo()).getPosicion()] = true;
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> caminoAct = new ListaEnlazadaGenerica<>();

		buscarCamino(lugares, obtenerVertice(lugares, "Ayuntamiento"), destino, camino, caminoAct, visitados, 0,
				maxTiempo);

		return camino;
	}

	private void buscarCamino(Grafo<String> lugares, Vertice<String> origen, String destino,
			ListaGenerica<String> camino, ListaGenerica<String> caminoAct, boolean[] visitados, int tiempoAct,
			int maxTiempo) {
		caminoAct.agregarFinal(origen.dato());
		visitados[origen.getPosicion()] = true;
		if (origen.dato().equals(destino) && tiempoAct <= maxTiempo) {
			copiarCamino(caminoAct, camino);
		} else {
			ListaGenerica<Arista<String>> aristas = lugares.listaDeAdyacentes(origen);
			aristas.comenzar();
			while (camino.esVacia() && !aristas.fin()) {
				Arista<String> arista = aristas.proximo();
				if (!visitados[arista.verticeDestino().getPosicion()])
					buscarCamino(lugares, arista.verticeDestino(), destino, camino, caminoAct, visitados,
							tiempoAct + arista.peso(), maxTiempo);
			}
			visitados[origen.getPosicion()] = false;
		}
		caminoAct.eliminarEn(caminoAct.tamanio());
	}

	private void copiarCamino(ListaGenerica<String> caminoOrigen, ListaGenerica<String> caminoDestino) {
		caminoOrigen.comenzar();
		while (!caminoOrigen.fin())
			caminoDestino.agregarFinal(caminoOrigen.proximo());
	}

	private Vertice<String> obtenerVertice(Grafo<String> lugares, String lugar) {
		Vertice<String> vLugar = null;
		ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();
		vertices.comenzar();
		while (vLugar == null && !vertices.fin()) {
			Vertice<String> vertice = vertices.proximo();
			if (vertice.dato().equals(lugar))
				vLugar = vertice;
		}
		return vLugar;
	}

}
