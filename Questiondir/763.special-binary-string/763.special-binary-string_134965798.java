class Solution {
        public String makeLargestSpecial(String s) {
        // return s;
        StringBuffer sb = new StringBuffer(s);
        boolean res = move(sb);
        while(res){
            res = move(sb);
        }
        return sb.toString();
    }
    public boolean move(StringBuffer sb){
        boolean res = false;
        int len = sb.length();
        for(int i = 1; i < len; i++ ){
            if(sb.charAt(i) == '1'){
                int end = findEnd(sb, i);
                int beg = findBeg(sb, i-1);
                if( beg != -1 && end != -1 && sb.substring(beg, i).compareTo(sb.substring(i,end+1)) < 0){
                    swap(sb, beg, i, end);
                    res = true;
                }
            }
        }

        return res;
    }
    public void swap(StringBuffer s, int beg, int i, int end){
        String s1 = s.toString();
        s.delete(0,s1.length());
        s.append(s1,0, beg);
        s.append(s1,i,end+1);
        s.append(s1,beg, i);
        s.append(s1,end+1,s1.length());
    }
    public int findEnd(StringBuffer s, int beg){
        int cnt = 0;
        int i = beg;
        for(; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt < 0){
                return -1;
            }else if(cnt == 0){
                return i;
            }
        }
        return -1;
    }
    public int findBeg(StringBuffer s, int end){
        int cnt = 0;
        int i = end;
        for(; i >=0 ; i--){
            if(s.charAt(i) == '0'){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt<0){
                return -1;
            }else if (cnt == 0){
                return i;
            }
        }
        return -1;
    }
}