public class Solution {
public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict);
        Set<String> shortRoot = new HashSet<>();
        int maxRootLeng = 0;
        for (String s : dict) {
        	boolean contain = false;
        	for (String w : shortRoot) {
        		if (s.startsWith(w)) {
        			contain = true;
        			break;
        		}
        	}
        	if (!contain) {
        		shortRoot.add(s);
        		maxRootLeng = Math.max(s.length(), maxRootLeng);
        	}
        }
        String [] tokens = sentence.split(" ");
        OUTER : for (int i = 0; i < tokens.length; i++) {
        	String t = tokens[i];
        	String c = "";
        	for (int j = 0; j < maxRootLeng && j < t.length(); j++) {
        		c += t.charAt(j);
        		if (shortRoot.contains(c)) {
        			tokens[i] = c;
        			continue OUTER;
        		}
        	}
        }
        return String.join(" ", tokens);
    }
}