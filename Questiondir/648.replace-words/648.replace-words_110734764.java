public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        HashSet<String> set = new HashSet<>(dict);
        String[] words = sentence.split(" ");
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                words[i] = map.get(words[i]);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                sb.append(words[i].charAt(j));
                if (set.contains(sb.toString())) {
                    map.put(words[i], sb.toString());
                    words[i] = sb.toString();
                }
            }
        }
        return String.join(" ", words);
    }
}