public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict);
        String[] s = sentence.split(" ");
        for(int i = 0; i < s.length; i++){
            for(String str : dict){
                if(s[i].startsWith(str)){
                    s[i] = str;
                    break;
                }
            }
        }
        String res = "";
        for(String str : s){
            res += str + " ";
        }
        return res.trim();
    }
}