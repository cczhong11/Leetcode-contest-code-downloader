public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String path: paths) {
            String[] strs = path.split(" ");
            
            for (int i = 1; i < strs.length; i++){
                String file[] = strs[i].split("[\\(\\)]");
                
                if (!map.containsKey(file[1])) {
                    map.put(file[1], new ArrayList<>());
                }
                map.get(file[1]).add(strs[0] + '/' + file[0]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String key: map.keySet()) {
            if (map.get(key).size() > 1) {
                res.add(map.get(key));
            }
        }
        return res;
    }
}