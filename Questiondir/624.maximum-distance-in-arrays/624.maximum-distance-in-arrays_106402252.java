public class Solution {
public int maxDistance(int[][] arrays) {
		int finalMax = 0;
		TreeMap<Integer, Set<Integer>> m = new TreeMap<>();
		for (int i = 0; i < arrays.length; i++) {
			int min = arrays[i][0];
			if (!m.containsKey(min)) {
				m.put(min, new HashSet<>());
			}
			m.get(min).add(i);
		}
		for (int i = 0; i < arrays.length; i++) {
			int max = arrays[i][arrays[i].length - 1];
			for (Map.Entry<Integer, Set<Integer>> e : m.entrySet()) {
				if (e.getValue().contains(i) && e.getValue().size() == 1) {
					continue;
				}
				finalMax = Math.max(finalMax, max - e.getKey());
			}
		}

		return finalMax;
	}
}