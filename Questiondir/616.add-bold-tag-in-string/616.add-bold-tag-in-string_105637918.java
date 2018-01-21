public class Solution {
    public String addBoldTag(String s, String[] dict) {
        Arrays.sort(dict, (a,b)->Integer.compare(b.length(), a.length()));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            for(String t : dict){
                if(s.startsWith(t, i)){
                    if(list.size() > 0 && i <= list.get(list.size() - 1)){
                        if(list.get(list.size() - 1) < i + t.length()){
                            list.set(list.size() - 1, i + t.length());
                        }
                    }else{
                        list.add(i);
                        list.add(i + t.length());
                    }
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(i == 0 ? s.substring(0, list.get(i)) : s.substring(list.get(i-1), list.get(i)));
            sb.append((i%2)==0?"<b>":"</b>");
        }
        if(sb.length() == 0) return s;
        sb.append(s.substring(list.get(list.size()-1)));
        return sb.toString();
    }
}