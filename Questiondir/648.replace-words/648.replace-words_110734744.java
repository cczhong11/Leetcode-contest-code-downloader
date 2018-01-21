public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict,(x,y)->{return x.length()-y.length();});
        String[] sts = sentence.split("\\s");
        StringBuilder sb  =new StringBuilder();
        for(int i=0;i<sts.length;i++){
            boolean f = false;
            for(int j=0;j<dict.size();j++){
                if(sts[i].startsWith(dict.get(j))){
                    sb.append(dict.get(j));
                    f = true;
                    break;
                }
            }
            if(!f){
                sb.append(sts[i]);
            }
            if(i!=sts.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
        
    }
}