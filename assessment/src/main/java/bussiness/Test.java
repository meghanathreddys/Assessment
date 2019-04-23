package bussiness;

public class Test {
	static String sp = "ABCD";

	static void testMethod() {
		StringBuffer sb = new StringBuffer();
		sb.append(" ABCD");
		sb.append("\n");

		for (char a : sp.toCharArray()) {
			int x = a;
			for (char b : sp.toCharArray()) {
				int y = b;
				if (x < y) {
					sb.append(">");
				} else if (x == y) {
					sb.append("=");
				} else {
					sb.append("<");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());

	}

	public static void main(String[] args) {
		testMethod();
	}
}
