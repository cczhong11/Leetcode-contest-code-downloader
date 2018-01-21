public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            String[] splits = paths[i].split(" ");
            String dir = splits[0];
            for (int j = 1; j < splits.length; j++) {
                int index = splits[j].indexOf('(');
                String fileName = splits[j].substring(0, index);
                String content = splits[j].substring(index+1);
                if (!map.containsKey(content)) map.put(content, new ArrayList<String>());
                map.get(content).add(dir+"/"+fileName);
            }
        }
        for (List<String> list : map.values()) {
            if (list.size() > 1) res.add(list);
        }
        return res;
    }
}