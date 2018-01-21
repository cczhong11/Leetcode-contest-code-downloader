class Solution {
 	public int kEmptySlots(int[] flowers, int k) {
		if (flowers.length == 0) return 0;
		
		BitSet bitset = new BitSet();
		
		int n = flowers.length;
        if (k < 0 || k >= n) {
			return -1;
		}
		int ans = -1;
		for (int i = 0; i < n; i++) {
			int pos = flowers[i] - 1;
			
	
			if ((bitset.nextSetBit(pos) == pos + k + 1  && pos + k + 1 < n)||
					(bitset.previousSetBit(pos) == pos - k - 1 && pos - k - 1 >= 0)) {
				return i + 1;
				
			}
			bitset.set(pos);
		}
		return -1;
	}

}