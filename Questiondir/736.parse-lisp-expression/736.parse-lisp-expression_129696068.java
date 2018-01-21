class Solution {
	public int evaluate(String expression) {
		char[] chars = expression.toCharArray();
		int n = expression.length();
		int[] matchIndex = new int[n];

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (chars[i] == '(') {
				stack.push(i);
			} else if (chars[i] == ')') {
				int a = stack.pop();
				matchIndex[a] = i - a;
			}
		}
		return eval(expression, 0, matchIndex, new HashMap<String, Integer>());
	}

	boolean isChar(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}

	int eval(String expr, int startIndex, int[] matchIndex, Map<String, Integer> values) {
		if (expr.charAt(1) == 'a') { // add
			int curr = 5;
			char ch = expr.charAt(curr);
			int a = 0;
			int sum = 0;

			if (ch == '(') {
				String substring = expr.substring(curr, curr + matchIndex[startIndex + curr] + 1);
				a = eval(substring, startIndex + curr, matchIndex, values);
				curr = curr + matchIndex[startIndex + curr] + 2;
			} else {
				int j = curr;
				while (expr.charAt(j) != ' ' && expr.charAt(j) != ')') {
					j++;
				}
				String varA = expr.substring(curr, j);
				if (isChar(varA.charAt(0))) {
					a = values.get(varA);
				} else {
					a = Integer.valueOf(varA);
				}

				curr = j + 1;
			}
			sum += a;

			ch = expr.charAt(curr);
			if (ch == '(') {
				String substring = expr.substring(curr, curr + matchIndex[startIndex + curr] + 1);
				a = eval(substring, startIndex + curr, matchIndex, values);
				curr = curr + matchIndex[startIndex + curr] + 2;
			} else {
				int j = curr;
				while (expr.charAt(j) != ' ' && expr.charAt(j) != ')') {
					j++;
				}
				String varA = expr.substring(curr, j);
				if (isChar(varA.charAt(0))) {
					a = values.get(varA);
				} else {
					a = Integer.valueOf(varA);
				}

				curr = j + 1;
			}
			sum += a;
			return sum;

		} else if (expr.charAt(1) == 'm') { // mult

			int curr = 6;
			char ch = expr.charAt(curr);
			int a = 0;
			int sum = 0;

			if (ch == '(') {
				String substring = expr.substring(curr, curr + matchIndex[startIndex + curr] + 1);
				a = eval(substring, startIndex + curr, matchIndex, values);
				curr = curr + matchIndex[startIndex + curr] + 2;
			} else {
				int j = curr;
				while (expr.charAt(j) != ' ' && expr.charAt(j) != ')') {
					j++;
				}
				String varA = expr.substring(curr, j);
				if (isChar(varA.charAt(0))) {
					a = values.get(varA);
				} else {
					a = Integer.valueOf(varA);
				}

				curr = j + 1;
			}
			sum += a;

			ch = expr.charAt(curr);
			if (ch == '(') {
				String substring = expr.substring(curr, curr + matchIndex[startIndex + curr] + 1);
				a = eval(substring, startIndex + curr, matchIndex, values);
				curr = curr + matchIndex[startIndex + curr] + 2;
			} else {
				int j = curr;
				while (expr.charAt(j) != ' ' && expr.charAt(j) != ')') {
					j++;
				}
				String varA = expr.substring(curr, j);
				if (isChar(varA.charAt(0))) {
					a = values.get(varA);
				} else {
					a = Integer.valueOf(varA);
				}

				curr = j + 1;
			}
			sum *= a;
			return sum;

		} else if (expr.charAt(1) == 'l') { // let
			Map<String, Integer> valuesClone = new HashMap<String, Integer>(values);

			List<String> vars = new ArrayList<>();
			List<Integer> startIndexs = new ArrayList<>();
			int n = expr.length();
			for (int i = 5; i < n - 1;) {
				int curr = i;
				if (expr.charAt(curr) == '(') {
					String substring = expr.substring(curr, curr + matchIndex[startIndex + curr] + 1);
					int si = startIndex + curr;
					vars.add(substring);
					startIndexs.add(si);
					curr = curr + matchIndex[startIndex + curr] + 2;
				} else {
					int j = curr;
					while (expr.charAt(j) != ' ' && expr.charAt(j) != ')') {
						j++;
					}
					String varA = expr.substring(curr, j);
					vars.add(varA);
					startIndexs.add(startIndex + curr);
					curr = j + 1;
				}
				i = curr;
			}

			for (int i = 0; i < vars.size(); i += 2) {
				String var = vars.get(i);

				if (i == vars.size() - 1) {
					if (var.charAt(0) == '(') {
						return eval(var, startIndexs.get(i), matchIndex, valuesClone);
					} else if (isChar(var.charAt(0))) {
						return valuesClone.get(var);
					} else {
						return Integer.valueOf(var);
					}
				} else {
					String val = vars.get(i + 1);
					int v = 0;
					if (val.charAt(0) == '(') {
						v = eval(val, startIndexs.get(i + 1), matchIndex, valuesClone);
					} else if (isChar(val.charAt(0))) {
						v = valuesClone.get(val);
					} else {
						v = Integer.valueOf(val);
					}
					valuesClone.put(var, v);
				}
			}
		}
		return -1;
	}
}