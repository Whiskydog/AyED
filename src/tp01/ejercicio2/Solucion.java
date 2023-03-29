package tp01.ejercicio2;

import java.util.Arrays;
import java.util.Scanner;

public class Solucion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n;
		while ((n = scanner.nextInt()) != 0)
			System.out.println(Arrays.toString(multiplos(n)));

		scanner.close();
	}

	public static int[] multiplos(int n) {
		int[] valores = new int[n];
		for (int i = 1; i <= n; i++)
			valores[i - 1] = i * n;
		return valores;
	}
}
