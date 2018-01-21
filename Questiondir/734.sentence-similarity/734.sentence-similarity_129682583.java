class Solution {
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length) {
			return false;
		}
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < pairs.length; i++) {
			//String key = pairs[i][0] + "," + pairs[i][1];
			set.add(pairs[i][0] + "," + pairs[i][1]);
			set.add(pairs[i][1] + "," + pairs[i][0]);
			
			set.add(pairs[i][0] + "," + pairs[i][0]);
			set.add(pairs[i][1] + "," + pairs[i][1]);
			
		}
		
		
		int n = words1.length;
		for (int i = 0; i < n; i++) {
			if (words1[i].equals(words2[i])) {
				continue;
			}
			String key = words1[i] + "," + words2[i];
			if (!set.contains(key)) {
				return false;
			}
		}
		return true;
	}
}