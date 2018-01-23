import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public String f(String s) {
        if (s.length() <= 3) return s;
        else return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }

    private int commonPrefix(List<String> dict, List<Integer> indices) {
        int min = Integer.MAX_VALUE;
        for (int i : indices)
            min = Math.min(min, dict.get(i).length());

        for (int i = 0; i < min; i++) {
            for (int j = 0; j < indices.size(); j++)
                if (dict.get(indices.get(j)).charAt(i) != dict.get(indices.get(0)).charAt(i)) return i;
        }

        return min;
    }

    public List<String> wordsAbbreviation(List<String> dict) {
        if (dict.size() == 0) return dict;

        Map<String, List<Integer>> map = new HashMap<>();
        Map<String, List<Integer>> map1 = new HashMap<>();
        for (int i = 0; i < dict.size(); i++) {
            String key = f(dict.get(i));
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(i);
        }

        while (map.size() != dict.size()) {
            map1 = new HashMap<>();
            for (String key : map.keySet()) {
                if (map.get(key).size() == 1) map1.put(key, map.get(key));
                else {
                    int prefix = commonPrefix(dict, map.get(key));
                    for (int i : map.get(key)) {
                        String s = dict.get(i);
                        String newKey = s.substring(0, prefix) + f(s.substring(prefix));
                        map1.putIfAbsent(newKey, new ArrayList<>());
                        map1.get(newKey).add(i);
                    }
                }
            }
            map = map1;
        }

        List<String> res = new ArrayList<>(dict.size());
        for (int i = 0; i < dict.size(); i++) res.add("");
        for (String s : map.keySet()) {
            res.set(map.get(s).get(0), s);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.wordsAbbreviation(Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion")));
    }
}