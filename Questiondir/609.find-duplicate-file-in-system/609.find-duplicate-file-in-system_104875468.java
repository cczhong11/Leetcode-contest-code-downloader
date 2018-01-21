public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : paths) {
        	String[] tokens = str.split(" ");
        	for(int i = 1; i < tokens.length; i ++) {
        		String token = tokens[i];
        		String name = token.split("\\(")[0];
        		String content = token.split("\\(")[1].substring(0, token.split("\\(")[1].length() - 1);
        		String path = tokens[0] + "/" + name;
        		if(!map.containsKey(content)) map.put(content, new ArrayList<String>());
        		map.get(content).add(path);
        	}
        }
        for(List<String> value : map.values()) {
            if(value.size() > 1) {
              result.add(value);
            }
        }
        return result;
    }
}