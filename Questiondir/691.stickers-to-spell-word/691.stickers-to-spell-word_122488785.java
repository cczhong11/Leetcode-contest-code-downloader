class Solution {
    	Map<String, Integer> cntMap = new HashMap<>();	
	public int minStickers(String[] stickers, String target) {
        int[] charCnt = new int[26];
        for (char c : target.toCharArray()) {
        	charCnt[c - 'a']++;
        }
        boolean[] charP = new boolean[26];
        List<int[]> list = new ArrayList<>();
        for (String sticker : stickers) {
        	int[] sCnt = new int[26];
        	boolean pre = false;
        	for (char c : sticker.toCharArray()) {
        		int idx = c - 'a';
        		if (charCnt[idx]>0 && sCnt[idx] < charCnt[idx]) {
        			sCnt[idx]++;
        			charP[idx] = true;
        			pre = true;
        		}
        	}
        	if (pre) {
        		list.add(sCnt);
        	}
        }
		for (int i = 0; i < 26; i++) {
			if (charCnt[i] > 0 && !charP[i]) {
				return -1;
			}
		}
		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return Arrays.stream(arg1).sum() - Arrays.stream(arg0).sum();
			}
		});
		for (int i = list.size() - 1; i>0; i--) {
			for (int j = 0; j < i; j++) {
				int[] small = list.get(i);
				int[] big = list.get(j);
				boolean contain = true;
				for (int k = 0; k < 26; k++) {
					if (small[k] > big[k]) {
						contain = false;
						break;
					}
				}
				if (contain) {
					list.remove(i);
					break;
				}
			}
		}
		cntMap.put("", 0);
		return findSmallest(charCnt, list);
    }

	private int findSmallest(int[] charCnt, List<int[]> list) {
		String s = "";
		for (int i = 0; i < 26; i++) {
			int cnt = charCnt[i];
			while (cnt > 0) {
				cnt --;
				s = s + (char)('a' + i);
			}
		}
		if (cntMap.containsKey(s)) {
			return cntMap.get(s);
		}
		int small = 15;
		for (int[] arr : list) {
			int [] newCharCnt = new int[26];
			for (int i = 0; i < 26; i++) {
				newCharCnt[i] = Math.max(0, charCnt[i] - arr[i]);
			}
			if (!Arrays.equals(charCnt, newCharCnt)) {
				small = Math.min(small, 1 + findSmallest(newCharCnt, list));
			}
		}
		cntMap.put(s, small);
		return small;
	}
}