class Solution {
	public int maximumSwap(int num) {
		String s = String.valueOf(num);
		int ans = num;
		for (int i = 1; i < s.length(); i++) {
			char[] chars = s.toCharArray();
			for (int j = 0; j < i; j++) {
				char t = chars[i];
				chars[i] = chars[j];
				chars[j] = t;
				int value = Integer.valueOf(new String(chars));
				ans = Math.max(ans, value);
				t = chars[i];
				chars[i] = chars[j];
				chars[j] = t;
			}
		}
		return ans;
	}
}