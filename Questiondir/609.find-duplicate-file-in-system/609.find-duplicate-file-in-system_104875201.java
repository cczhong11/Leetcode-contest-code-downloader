public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        if (paths.length == 0) {
            return res;
        } 
        for (int i = 0; i < paths.length; i++) {
            String cur = paths[i];
            if (cur.indexOf(".") == -1) {
                continue;
            }
            String[] split = cur.split("\\s+");
            for (int j = 0; j < split.length; j++) {
                if (split[j].indexOf("(") == -1) {
                    continue;
                }
                int left = split[j].indexOf("(");
                List<String> tmp = map.getOrDefault(split[j].substring(left, split[j].length() - 1), new ArrayList<>());
                tmp.add(split[0] + "/" + split[j].substring(0, left));
                map.put(split[j].substring(left, split[j].length() - 1), new ArrayList<>(tmp));
            }
        }
        for (String key: map.keySet()) {
            List<String> val = map.get(key);
            if (val.size() < 2) {
                continue;
            }
            res.add(new ArrayList<>(val));
        }
        return res;
    }
}