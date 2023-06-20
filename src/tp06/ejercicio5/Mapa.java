package tp06.ejercicio5;

import java.io.IOException;
import java.util.Scanner;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.GraphBuilder;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Mapa {
	public static void main(String[] args) throws IOException {
		Mapa mapa = new Mapa(new GraphBuilder("map.json").build());

		System.out.println("devolverCamino La Plata a Poblet");
		System.out.println(mapa.devolverCamino("La Plata", "Poblet"));

		System.out
				.println("\ndevolverCaminoExceptuando La Plata a General Mansilla exceptuando Lomas de Copello, Arana");
		ListaGenerica<String> excepciones = new ListaEnlazadaGenerica<>();
		excepciones.agregar(new String[] { "Lomas de Copello", "Arana" });
		System.out.println(mapa.devolverCaminoExceptuando("La Plata", "General Mansilla", excepciones));

		System.out.println("\ndevolverCaminoExceptuando Magdalena a La Plata exceptuando Vieytes, General Mansilla");
		excepciones = new ListaEnlazadaGenerica<>();
		excepciones.agregar(new String[] { "Vieytes", "General Mansilla" });
		System.out.println(mapa.devolverCaminoExceptuando("Magdalena", "La Plata", excepciones));

		System.out.println("\ncaminoMasCorto introduzca origen & destino");
		String origen, destino;
		Scanner scanner = new Scanner(System.in);
		while (!(origen = scanner.nextLine()).isBlank()) {
			destino = scanner.nextLine();
			System.out.println(mapa.caminoMasCorto(origen, destino));
		}
		scanner.close();
		
		System.out.println(mapa.caminoSinCargarCombustible("La Plata", "Magdalena", 50));
		System.out.println(mapa.caminoSinCargarCombustible("La Plata", "Magdalena", 45));
		
		System.out.println(mapa.caminoConMenorCargaDeCombustible("La Plata", "Arana", 15));
	}

	private Grafo<String> mapaCiudades;

	public Mapa(Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}

	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();
		boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		Vertice<String> origen = obtenerVertice(ciudad1);
		if (origen == null)
			return camino;

		buscarCamino(origen, ciudad2, visitados, camino, caminoActual);

		return camino;
	}

	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
			ListaGenerica<String> ciudades) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();
		boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		Vertice<String> origen = obtenerVertice(ciudad1);
		if (origen == null)
			return camino;

		ciudades.comenzar();
		while (!ciudades.fin()) {
			Vertice<String> ciudadExceptuada = obtenerVertice(ciudades.proximo());
			if (ciudadExceptuada != null)
				visitados[ciudadExceptuada.getPosicion()] = true;
		}

		buscarCamino(origen, ciudad2, visitados, camino, caminoActual);

		return camino;
	}
	
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		Vertice<String> origen = obtenerVertice(ciudad1);
		Vertice<String> destino = obtenerVertice(ciudad2);
		Dijkstra<String> dijkstra = new Dijkstra<>(mapaCiudades, origen, tanqueAuto);
		
		return dijkstra.obtenerCamino(destino);
	}

	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		Vertice<String> origen = obtenerVertice(ciudad1);
		Vertice<String> destino = obtenerVertice(ciudad2);
		Dijkstra<String> dijkstra = new Dijkstra<>(mapaCiudades, origen, Integer.MAX_VALUE);
		if (dijkstra.distanciaHasta(destino) > tanqueAuto)
			return new ListaEnlazadaGenerica<>();
		return dijkstra.obtenerCamino(destino);
	}

	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		Dijkstra<String> dijkstra = new Dijkstra<>(mapaCiudades, obtenerVertice(ciudad1), Integer.MAX_VALUE);
		return dijkstra.obtenerCamino(obtenerVertice(ciudad2));
	}

	private void buscarCamino(Vertice<String> origen, String destino, boolean[] visitados, ListaGenerica<String> camino,
			ListaGenerica<String> caminoActual) {
		visitados[origen.getPosicion()] = true;
		caminoActual.agregarFinal(origen.dato());

		if (origen.dato().equals(destino))
			llenarCamino(caminoActual, camino);

		ListaGenerica<Arista<String>> aristas = mapaCiudades.listaDeAdyacentes(origen);
		aristas.comenzar();
		while (!aristas.fin() && camino.esVacia()) {
			Vertice<String> vertice = aristas.proximo().verticeDestino();
			if (!visitados[vertice.getPosicion()]) {
				buscarCamino(vertice, destino, visitados, camino, caminoActual);
			}
		}
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

	private void llenarCamino(ListaGenerica<String> caminoOrigen, ListaGenerica<String> caminoDestino) {
		caminoOrigen.comenzar();
		while (!caminoOrigen.fin())
			caminoDestino.agregarFinal(caminoOrigen.proximo());
	}

	private Vertice<String> obtenerVertice(String nombreCiudad) {
		Vertice<String> verticeCiudad = null;
		ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
		vertices.comenzar();
		while (!vertices.fin() && verticeCiudad == null) {
			Vertice<String> vertice = vertices.proximo();
			if (vertice.dato().equals(nombreCiudad))
				verticeCiudad = vertice;
		}
		return verticeCiudad;
	}

}
