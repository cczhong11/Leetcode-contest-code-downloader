public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : dict) {
            String abbr = getAbbr(s, 1);
            addMap(map, abbr, s);
        }
        while (true) {
            boolean ok = true;
            Map<String, List<String>> nmap = new HashMap<>();
            for (Map.Entry<String, List<String>> ent : map.entrySet()) {
                String abbr = ent.getKey();
                List<String> list = ent.getValue();
                if (list.size() > 1) {
                    int len = 0;
                    for (char c : abbr.toCharArray()) {
                        if ('a' <= c && c <= 'z') len ++;
                        else break;
                    }
                    for (String s : list) {
                        String na = getAbbr(s, len + 1);
                        addMap(nmap, na, s);
                    }
                    ok = false;
                } else {
                    for (String s : list) {
                        addMap(nmap, abbr, s);
                    }
                }
                map = nmap;
            }
            if (ok) break;
        }
        Map<String, String> rev = new HashMap<>();
        for (Map.Entry<String, List<String>> ent : map.entrySet()) {
            String abbr = ent.getKey();
            List<String> list = ent.getValue();
            for (String s : list) {
                rev.put(s, abbr);
            }
        }
        List<String> res = new ArrayList<>();
        for (String s : dict) {
            String abbr = rev.get(s);
            res.add(abbr);
        }
        return res;
    }

    String getAbbr(String s, int len) {
        if (len >= s.length()) return s;
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i ++) sb.append(cs[i]);
        sb.append(String.valueOf(cs.length - len - 1));
        sb.append(cs[cs.length - 1]);
        String abbr = sb.toString();
        if (abbr.length() < s.length()) return abbr;
        else return s;
    }

    void addMap(Map<String, List<String>> map, String a, String b) {
        if (map.containsKey(a) == false) {
            map.put(a, new ArrayList<>());
        }
        map.get(a).add(b);
    }
}