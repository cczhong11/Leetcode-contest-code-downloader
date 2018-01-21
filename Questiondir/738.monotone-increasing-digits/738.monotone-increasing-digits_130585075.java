class Solution {
	String get(char x, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			sb.append(x);
		}
		return sb.toString();
	}
	
	public int monotoneIncreasingDigits(int N) {
		String str = String.valueOf(N);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); ++i) {
			int k = str.length() - i;
			if (get(str.charAt(i), k).compareTo(str.substring(i)) <= 0) {
				sb.append(str.charAt(i));
			} else {
				sb.append((char)(str.charAt(i) - 1));
				sb.append(get('9', k - 1));
				return Integer.parseInt(sb.toString());
			}
		}
		return Integer.parseInt(sb.toString());
	}
}
