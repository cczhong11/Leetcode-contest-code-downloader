public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if(paths == null || paths.length == 0)
            return res;
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths) {
            String[] strs = path.split(" ");
            for(int i = 1 ; i < strs.length ; i++){
                String[] str = strs[i].split("\\(");
                String dir = strs[0] + "/" + str[0], content = str[1].substring(0, str[1].length() - 1);
                if(!map.containsKey(content))
                    map.put(content, new ArrayList<String>());
                map.get(content).add(dir);
            }
        }
        for(List<String> value : map.values()) {
            if(value.size() > 1)
                res.add(value);
        }
        return res;
    }
}