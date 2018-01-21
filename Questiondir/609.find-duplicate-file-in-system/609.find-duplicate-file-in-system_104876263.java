public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String p : paths) {
            String[] arr = p.split(" ");
            String dir = arr[0];
            for (int i = 1; i < arr.length; i++) {
                int idx = arr[i].indexOf('(');
                String f = arr[i].substring(0, idx);
                String c = arr[i].substring(idx + 1, arr[i].length() - 1);
                map.putIfAbsent(c, new ArrayList<>());
                map.get(c).add(dir + "/" + f);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() >= 2) {
                res.add(list);
            }
        }
        return res;
    }
}