public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : paths) {
            String[] tmp = s.split(" ");
            String dir = tmp[0];
            for (int i = 1; i < tmp.length; i++) {
                int idx = tmp[i].indexOf("(");
                String fname = tmp[i].substring(0, idx);
                String content = tmp[i].substring(idx + 1, tmp[i].length() - 1);
                String fullPath = dir + "/" + fname;
                
                List<String> lst;
                if (!map.containsKey(content)) {
                    lst = new ArrayList<>();
                    map.put(content, lst);
                } else {
                    lst = map.get(content);
                }
                lst.add(fullPath);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (List<String> lst : map.values()) {
            if (lst.size() >= 2) {
                ans.add(lst);
            }
        }
        return ans;
    }
}