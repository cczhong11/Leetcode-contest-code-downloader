public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : paths) {
            String[] split = s.split(" ");
            for(int i = 1; i < split.length; i++) {
                int j = split[i].indexOf('(');
                String content = split[i].substring(j + 1, split[i].length() - 1);
                String path = split[0] + "/" + split[i].substring(0, j);
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(path);
            }
        }
        List<List<String>> re = new ArrayList<>();
        for(String s : map.keySet()) {
            if(map.get(s).size() > 1) re.add(map.get(s));
        }
        return re;
    }
    
}