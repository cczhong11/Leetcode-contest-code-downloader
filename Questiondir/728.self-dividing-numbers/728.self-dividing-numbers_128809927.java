public class Solution {
	
	TreeSet<Integer> set;
	
	public Solution() {
		set = new TreeSet<>();
		for (int i = 1; i < 10000; i++) {
			if (sdn(i)) {
				set.add(i);
			}
		}
	}

	private boolean sdn(int i) {
		String s = Integer.toString(i);
		for (int j = 0; j < s.length(); j++) {
			int k = s.charAt(j) - '0';
			if (k == 0 || i % k != 0) {
				return false;
			}
		}
		return true;
	}
	
	public List<Integer> selfDividingNumbers(int left, int right) {
        return new ArrayList<>(set.subSet(left, true, right, true));
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		
		System.out.println(s.selfDividingNumbers(1, 22));

	}

}