import java.util.StringTokenizer;

class Solution {
    public int evaluate(String expression) {
		Map<String, Integer> varMap = new HashMap<>();
		return evaluate(expression, varMap);
	}

	private int evaluate(String expression, Map<String, Integer> varMap) {
		StringTokenizer tokenizer = new StringTokenizer(expression);
		String token = tokenizer.nextToken();
		if (token.equals("(add")) {
			int firstS = 5;
			int firstE = 0;
			int bc = 0;
			for (int i = firstS; i < expression.length(); i++) {
				char c = expression.charAt(i);
				if (c == ' ' && bc == 0) {
					firstE = i;
					break;
				}
				if (c == '(') {
					bc++;
				}
				if (c == ')') {
					bc--;
				}
			}
			return evaluate(expression.substring(firstS, firstE), varMap)
					+ evaluate(expression.substring(firstE + 1, expression.length() - 1), varMap);
		}
		if (token.equals("(mult")) {
			int firstS = 6;
			int firstE = 0;
			int bc = 0;
			for (int i = firstS; i < expression.length(); i++) {
				char c = expression.charAt(i);
				if (c == ' ' && bc == 0) {
					firstE = i;
					break;
				}
				if (c == '(') {
					bc++;
				}
				if (c == ')') {
					bc--;
				}
			}
			return evaluate(expression.substring(firstS, firstE), varMap)
					* evaluate(expression.substring(firstE + 1, expression.length() - 1), varMap);
		}
		if (token.equals("(let")) {
			Map<String, Integer> localVarMap = new HashMap<>(varMap);
			int start = 5;
			int end = 0;
			while (end < expression.length()) {
				if (expression.charAt(start) == '(') {
					break;
				}
				int bc = 0;
				boolean isVar = false;
				for (int i = start; i < expression.length(); i++) {
					char c = expression.charAt(i);
					if (c == ' ') {
						end = i;
						isVar = true;
						break;
					}
				}
				if (!isVar) {
					break;
				}
				String varName = expression.substring(start, end);
				start = end + 1;
				for (int i = start; i < expression.length(); i++) {
					char c = expression.charAt(i);
					if (c == ' ' && bc == 0) {
						end = i;
						break;
					}
					if (c == '(') {
						bc++;
					}
					if (c == ')') {
						bc--;
					}
				}
				localVarMap.put(varName, evaluate(expression.substring(start, end), localVarMap));
				start = end + 1;
			}
			return evaluate(expression.substring(start, expression.length() - 1), localVarMap);
		}
		if (varMap.containsKey(expression)) {
			return varMap.get(expression);
		}
		return Integer.valueOf(expression);
	}
}