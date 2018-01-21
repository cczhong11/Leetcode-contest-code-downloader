class Solution {
    public String makeLargestSpecial(String S) {
		String res = S;
		while (!res.equals(helper(res))) {
			res = helper(res);
		}
		return res;
	}
	
	public String helper(String S) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '1') {
				map.put(i, specialList(S, i));
			}
		}
		String res = S;
		for (int start: map.keySet()) {
			List<Integer> list1 = map.get(start);
			for (int end1: list1) {
				if (map.containsKey(end1)) {
					List<Integer> list2 = map.get(end1);
					for (int end2: list2) {
						String temp = S.substring(0, start) + S.substring(end1, end2) + S.substring(start, end1) + S.substring(end2);
						if (temp.compareTo(res) > 0) {
							res = temp;
						}
					}
				}
			}
		}
		return res;
	}
	
	public List<Integer> specialList(String S, int start) {
		int num0 = 0;
		int num1 = 1;
		List<Integer> res = new ArrayList<>();
		for (int i = start + 1; i < S.length(); i++) {
			if (S.charAt(i) == '1') {
				num1++;
			} else {
				num0++;
			}
			if (num1 < num0) break;
			if (num1 == num0) res.add(i + 1);
		}
		return res;
	}
}