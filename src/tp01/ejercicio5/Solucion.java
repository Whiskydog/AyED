package tp01.ejercicio5;

import java.util.Arrays;
import java.util.Random;

public class Solucion {
	
	public static void main(String[] args) {
		// Generamos pseudo aleatoriamente un arreglo de enteros
		// de longitud 10, entre 0 y 100 inclusive
		int[] valores = new Random().ints(10, 0, 101).toArray();
		System.out.println(Arrays.toString(valores));

		// Punto A donde usamos la sentencia return
		System.out.println("Punto A " + minMaxPromA(valores));

		// Punto B donde interactuamos con un objeto pasado
		// por parametro
		MinMaxProm minMaxProm = new MinMaxProm();
		minMaxPromB(valores, minMaxProm);
		System.out.println("Punto B " + minMaxProm);

		// Punto C donde hacemos el calculo directamente desde
		// el objeto
		minMaxProm.calculateFrom(valores);
		System.out.println("Punto C " + minMaxProm);
	}

	public static MinMaxProm minMaxPromA(int[] valores) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		float prom = 0f;

		for (int i : valores) {
			if (i < min)
				min = i;
			if (i > max)
				max = i;
			prom = prom + i;
		}
		prom = prom / valores.length;

		return new MinMaxProm(min, max, prom);
	}

	public static void minMaxPromB(int[] valores, MinMaxProm minMaxProm) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		float prom = 0f;

		for (int i : valores) {
			if (i < min)
				min = i;
			if (i > max)
				max = i;
			prom = prom + i;
		}
		prom = prom / valores.length;

		minMaxProm.set(min, max, prom);
	}
}
