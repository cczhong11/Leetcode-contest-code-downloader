import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] split = path.split(" +");
            String parentPath = split[0];
            for (int i = 1; i < split.length; i++) {
                int pi = split[i].indexOf('(');
                String content = split[i].substring(pi);
                String name = split[i].substring(0, pi);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(parentPath + "/" + name);
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for (List<String> strings : map.values()) {
            if (strings.size() > 1) {
                answer.add(strings);
            }
        }
        return answer;
    }
}