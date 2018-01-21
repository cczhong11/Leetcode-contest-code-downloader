class Solution {
    public String makeLargestSpecial(String S) {
        int n = S.length();
        for(int i = 0; i < n; i++){
            int nexti = getSpecial(S, i);
            if(nexti == -1){
                continue;
            }
            int j = nexti + 1;
            int nextj = getSpecial(S, j);
            if(nextj == -1){
                continue;
            }
            String sub1 = S.substring(i, j);
            String sub2 = S.substring(j, nextj + 1);
            if(sub2.compareTo(sub1) > 0){
                System.out.println(sub1 + " " + sub2);
                StringBuilder sb = new StringBuilder();
                if(i > 0){
                    sb.append(S.substring(0, i));
                }
                sb.append(sub2);
                sb.append(sub1);
                if(nextj + 1 < n){
                    sb.append(S.substring(nextj + 1, n));
                }
                return makeLargestSpecial(sb.toString());
            }
        }
        return S;
    }
    int getSpecial(String S, int idx){
        int cnt = 0;
        for(int i = idx; i < S.length(); i++){
            if(S.charAt(i) == '1'){
                cnt++;
            }
            else{
                cnt--;
            }
            if(cnt < 0){
                break;
            }
            if(cnt == 0){
                return i;
            }
        }
        return -1;
    }
}