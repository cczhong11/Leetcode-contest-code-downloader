public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        HashMap<String, String> map = convert(dict, 1);
        return output(dict, map);
    }

    private HashMap<String, String> convert(List<String> dict, int depth) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : dict) {
            String min = convert(str, depth);
            if (!map.containsKey(min)) {
                map.put(min, new LinkedList<String>());
            }
            map.get(min).add(str);
        }
        HashMap<String, String> ret = new HashMap<String, String>();
        for (String key : map.keySet()) {
            if (map.get(key).size() == 1) {
                ret.put(map.get(key).get(0), key);
            } else {
                HashMap<String, String> subMap = convert(map.get(key), depth + 1);
                ret.putAll(subMap);
            }
        }
        return ret;
    }

    private List<String> output(List<String> dict, HashMap<String, String> map) {
        List<String> list = new LinkedList<String>();
        for (String srt : dict) {
            list.add(map.get(srt));
        }
        return list;
    }

    private String convert(String str, int depth) {
        if (depth + 1 >= str.length()) {
            return str;
        }
        int len = str.length();
        String s = str.substring(0, depth) + String.valueOf(len - 1 - depth) + str.charAt(len - 1);
        if (s.length() >= len) {
            return str;
        } else {
            return s;
        }
    }
}