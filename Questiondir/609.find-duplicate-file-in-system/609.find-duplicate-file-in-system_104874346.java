import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : paths) {
            String[] split = str.split(" ");
            String path = split[0];
            for (int i = 1; i < split.length; i++) {
                int index = split[i].indexOf('(');
                String fileName = split[i].substring(0, index);
                String content = split[i].substring(index);
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(path + "/" + fileName);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : map.values())
            if (value.size() > 1)
                res.add(value);
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
    }
}