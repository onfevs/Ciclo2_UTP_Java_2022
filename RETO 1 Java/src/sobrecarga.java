public class sobrecarga {
	static int suma(int x, int y) {
		return x + y;
	}

	static double suma(double x, double y) {
		return x + y;
	}

	public static void main(String[] args) {
		int sum = suma(1, 2);
		System.out.println(sum);
		double sum2 = Math.round(suma(1.1, 2.2));
		System.out.println(sum2);
	}
}
