package bussiness;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	}

	private static String getpuzzleSolution(String input) {
		input = input.substring(input.indexOf("ABCD") + 5, input.length());
		String[] split = input.split("\n");
		Map<String, Integer> conditions = new HashMap<String, Integer>();
		for (int i = 0; i < split.length; i++) {
			char a = split[i].charAt(0);
			if (split[i].contains(">")) {
				split[i].indexOf(">");
				conditions.put(a + ">", split[i].indexOf(">"));
			} else if (split[i].contains("<")) {
				split[i].indexOf("<");
				conditions.put(a + "<", split[i].indexOf("<"));
			} else if (split[i].contains("=")) {
				conditions.put(a + "=", split[i].indexOf("="));
			}
		}
		setValues(conditions);
		StringBuffer sb = new StringBuffer();
		sb.append(" ABCD");
		sb.append("\n");
		input = "ABCD";
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

	private static List<String> setValues(Map<String, Integer> conditions) {

		String condt = conditions.toString().replaceAll("=1", "A").replaceAll("=2", "B").replaceAll("=3", "C")
				.replaceAll("=4", "D");
		condt = condt.substring(condt.indexOf("{") + 1, condt.indexOf("}"));
		List<String> conditionsList = new ArrayList<String>();
		for (String value : condt.split(",")) {
			if (value.contains("<")) {
				StringBuffer sb = new StringBuffer(value);
				value = sb.reverse().toString().replace("<", ">");
				conditionsList.add(value);
			} else {
				conditionsList.add(value);
			}
		}
		return conditionsList;
	}

	public static String getResponse(String query) throws UnsupportedEncodingException {
		String[] params = query.split("&");
		Map<String, String> map = new HashMap<String, String>();
		for (String param : params) {
			String name = param.split("=")[0];
			String value = param.split("=")[1];
			map.put(name, value);
		}
		if (map.get("q").equals("Puzzle"))
			return getpuzzleSolution(URLDecoder.decode(map.get("d"), "UTF-8"));
		else if (sp.get(map.get("q")) != null)
			return sp.get(map.get("q"));
		return "OK";
	}
}
