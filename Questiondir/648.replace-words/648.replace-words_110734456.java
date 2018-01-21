public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        //Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>(dict);
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            String replace = helper(str, set);
            if (sb.length() == 0) {
                sb.append(replace);
            } else {
                sb.append(" ");
                sb.append(replace);
            }
        }
        return sb.toString();
    }
    
    String helper(String str, Set<String> set) {
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.substring(0, i + 1))) {
                return str.substring(0, i + 1);
            }
        }
        return str;
    }
}