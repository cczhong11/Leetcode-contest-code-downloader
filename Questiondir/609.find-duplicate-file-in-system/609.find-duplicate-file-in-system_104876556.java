public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> m = new HashMap<>();
        for (int i = 0; i < paths.length; ++i) {
            String line = paths[i];
            String[] ss = line.split(" ");
            String rootPath = ss[0] + "/";
            for (int j = 1; j < ss.length; ++j) {
                String ele = ss[j];
                String fn = ele.substring(0, ele.indexOf("("));
                String ct = ele.substring(ele.indexOf("(") + 1, ele.length() - 1);
                if (!m.containsKey(ct)) {
                    m.put(ct, new ArrayList<String>());
                }
                m.get(ct).add(rootPath + fn);
            }
        }
        List<List<String>> rst = new ArrayList<>();
        for (String k : m.keySet()) {
            if (m.get(k).size() > 1) {
                rst.add(m.get(k));
            }
        }
        return rst;
    }
}