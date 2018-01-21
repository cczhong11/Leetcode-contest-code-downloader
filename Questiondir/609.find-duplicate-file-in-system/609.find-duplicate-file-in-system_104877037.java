public class Solution {
    	public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> ans = new ArrayList<>();
		if (paths == null || paths.length == 0) return ans;
		
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths) {
			String[] s = path.split("\\s+");
			String dir = s[0];
			for (int i = 1; i < s.length; i++) {
				String f = s[i];
				int pos = f.indexOf('(');
				String content = f.substring(pos + 1, f.length() - 1);
				String filename = f.substring(0, pos);
				if (!map.containsKey(content)) {
					map.put(content, new ArrayList<String>());
				}
				map.get(content).add(dir + "/" + filename);
			}
		}
		for (String key : map.keySet()) {
			if (map.get(key).size() > 1)
				ans.add(map.get(key));
		}
		return ans;
	}
}