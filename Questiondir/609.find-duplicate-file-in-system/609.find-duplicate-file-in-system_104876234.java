public class Solution {

	private boolean check(String path) {
		
		int i , length = path.length();
		i = 0;
		while (i < length && path.charAt(i) != ' ') {
			i ++;
		}
		if (i < length && path.charAt(i) == ' ') {
			return true;
		} else {
			return false;
		}
		
	}
	
	public List<List<String>> findDuplicate(String[] paths) {
	
		Map<String , List<String>> map = new HashMap<>();
		for (String path : paths) {
			
			if (!check(path)) {
				continue;
			}
			
			String[] strs = path.split(" ");
			String directory = strs[0];
			int i , j , n = strs.length;
			for (i = 1;i < n;i ++) {
				StringBuilder builder = new StringBuilder();
				String string = strs[i];
				int length = string.length();
				j = 0;
				while (j < length && string.charAt(j) != '(') {
					builder.append(string.charAt(j));
					j ++;
				}
				String p = builder.toString();
				j ++;
				builder.setLength(0);
				while (j < length && string.charAt(j) != ')') {
					builder.append(string.charAt(j));
					j ++;
				}
				String content = builder.toString();
				String fullPath = directory + "/" + p;
				if (!map.containsKey(content)) {
					map.put(content , new ArrayList<>());
				}
				map.get(content).add(fullPath);
			}
		}
		List<List<String>> ans = new ArrayList<>();
		for (List<String> list : map.values()) {
			if (list.size() > 1) {
				ans.add(list);
			}
		}
		return ans;
        
    }

}