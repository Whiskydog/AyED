package tp01.ejercicio5;

public class MinMaxProm {
	private int min = Integer.MAX_VALUE;
	private int max = Integer.MIN_VALUE;
	private float prom;

	public MinMaxProm() {
	}

	public MinMaxProm(int min, int max, float prom) {
		this.set(min, max, prom);
	}
	
	public MinMaxProm(int[] from) {
		this.calculateFrom(from);
	}

	public void set(int min, int max, float prom) {
		this.min = min;
		this.max = max;
		this.prom = prom;
	}

	public void calculateFrom(int[] valores) {
		this.set(Integer.MAX_VALUE, Integer.MIN_VALUE, 0f);
		for (int i : valores) {
			if (i < min)
				min = i;
			if (i > max)
				max = i;
			prom += i;
		}
		prom /= valores.length;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public float getProm() {
		return prom;
	}

	@Override
	public String toString() {
		return String.format("Min: %s Max: %s Prom: %s", min, max, prom);
	}
}