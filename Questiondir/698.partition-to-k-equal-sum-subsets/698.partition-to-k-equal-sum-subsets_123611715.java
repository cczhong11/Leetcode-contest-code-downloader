class Solution {
    Map<List<Boolean>, Boolean> canDivide = new HashMap<>();
	
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % k != 0) {
			return false;
		}
		int div = sum / k;
		List<Integer> toDivide = new ArrayList<>();
        for (int num : nums) {
        	if (num > div) {
        		return false;
        	}
        	if (num < div) {
        		toDivide.add(num);
        	}
        }
        List<Integer> possibleComb = new ArrayList<>();
		int total = 1 << toDivide.size();
		for (int i = 0; i < total; i++) {
			int csum = 0;
			for (int j = 0; j < toDivide.size(); j++) {
				if (((i >> j) & 1) == 1) {
					csum += toDivide.get(j);
				}
			}
			if (csum == div) {
				possibleComb.add(i);
			}
		}
        boolean[] currentChosen = new boolean[toDivide.size()];
        return canDivide(currentChosen, possibleComb);
    }
	
	private boolean canDivide(boolean[] currentChosen, List<Integer> possibleComb) {
		List<Boolean> l = new ArrayList<>();
		for (boolean b : currentChosen) {
			l.add(b);
		}
		if (canDivide.containsKey(l)) {
			return canDivide.get(l);
		}
		int i = 0;
		for (i = 0; i < currentChosen.length; i++) {
			if (!currentChosen[i]) {
				break;
			}
		}
		if (i == currentChosen.length) {
			return true;
		}
		for (int sel : possibleComb) {
			boolean[] newChosen = Arrays.copyOf(currentChosen, currentChosen.length);
			boolean canFit = true;
			for (int j = 0; j < newChosen.length; j++) {
				if (((sel >> j) & 1) == 1) {
					if (newChosen[j]) {
						canFit = false;
						break;
					} else {
						newChosen[j] = true;
					}
				}
			}
			if (canFit && canDivide(newChosen, possibleComb)) {
				canDivide.put(l, true);
				return true;
			}
		}
		canDivide.put(l, false);
		return false;
	}
}