public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < paths.length; i++) {
			String path = paths[i];
			String[] names = path.split(" ");
			String dir = names[0];
			if(!dir.endsWith("/")) {
				dir = dir + "/";
			}

			for (int j = 1; j < names.length; j++) {
				int index = names[j].indexOf("(");
				String content = names[j].substring(index + 1, names[j].length() - 1);
				if (!map.containsKey(content)) {
					map.put(content, new ArrayList<String>());
				}

				map.get(content).add(dir + names[j].substring(0, index));
			}
		}

		List<List<String>> result = new ArrayList<List<String>>();
		for (String key : map.keySet()) {
			if (map.get(key).size() > 1) {
				result.add(map.get(key));
			}
		}
		return result;
	}
}