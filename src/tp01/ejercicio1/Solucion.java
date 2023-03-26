package tp01.ejercicio1;

public class Solucion {
	
	public static void main(String[] args) {
		if (args.length == 0)
			return;
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		// Punto A
		imprimirEntreFor(a, b); System.out.println();
		
		// Punto B
		imprimirEntreWhile(a, b); System.out.println();
		
		// Punto C
		imprimirEntreRec(a, b); System.out.println();
	}
	
	public static void imprimirEntreFor(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
	
	public static void imprimirEntreWhile(int a, int b) {
		int i = a;
		while (i <= b) {
			System.out.println(i++);
		}
	}
	
	public static void imprimirEntreRec(int a, int b) {
		if (a <= b) {
			System.out.println(a);
			imprimirEntreRec(a+1, b);
		}
	}
}
