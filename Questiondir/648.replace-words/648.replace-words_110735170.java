public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        List<String>[] dictSorted = new List[26];
        for(int i=0; i<26; ++i)
            dictSorted[i]=new ArrayList<String>();
        for(String s : dict)
            dictSorted[s.charAt(0)-'a'].add(s);
        for(int i=0; i<words.length; ++i) {
            for(String root : dictSorted[words[i].charAt(0)-'a']) {
                if(words[i].startsWith(root)) {
                    words[i]=root;
                }
            }
        }
        StringBuilder output = new StringBuilder();
        for(String s : words)
            output.append(s).append(' ');
        output.deleteCharAt(output.length()-1);
        return output.toString();
    }
}