package bussiness;

import java.util.HashMap;
import java.util.Map;

public class BussinessLogic {

	static Map<String, String> sp = new HashMap<String, String>();
	static {
		sp.put("Ping", "OK");
		sp.put("Phone", "9189789692");
		sp.put("Years", "5");
		sp.put("Resume", "http://ec2-18-222-238-59.us-east-2.compute.amazonaws.com:8080/assessment/Resumedownload");
		sp.put("Source", "https://github.com/meghanathreddys/Assessment.git");
		sp.put("Name", "MEGHANATH REDDY SHAMALA");
		sp.put("Referrer", "John Carney");
		sp.put("Status",
				"YES I am in OPT and H1B sponsered expecting recipt number by the end of the month which can be used for transfering to any company");
		sp.put("Position", "Software Engineer");
		sp.put("Degree", "Master in computer science");
		sp.put("Email+Address", "meghanathreddy.nani@gmail.com");
		sp.put("Puzzle", getpuzzleSolution("ABCD"));

	}

	private static String getpuzzleSolution(String input) {

		StringBuffer sb = new StringBuffer();
		sb.append(input);
		sb.append("\n");
		for (char firstIteration : input.toCharArray()) {
			int x = firstIteration;
			sb.append(firstIteration);
			for (char secondIteration : input.toCharArray()) {
				int y = secondIteration;
				if (x < y) {
					sb.append("<");
				} else if (x == y) {
					sb.append("=");
				} else {
					sb.append(">");
				}
			}
			sb.append("\n");
		}
		return sb.toString().trim();
	}

	public static String getResponse(String query) {
		String[] params = query.split("&");
		Map<String, String> map = new HashMap<String, String>();
		for (String param : params) {
			String name = param.split("=")[0];
			String value = param.split("=")[1];
			map.put(name, value);
		}
		if (sp.get(map.get("q")) != null)
			return sp.get(map.get("q"));
		return "ok";
	}
}
