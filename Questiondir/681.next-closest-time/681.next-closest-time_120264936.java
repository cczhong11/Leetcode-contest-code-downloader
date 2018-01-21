class Solution {
      List<int[]> getnDigits(int[]digits){
        List<int[]>ans=new ArrayList<>();
        for (int i = 0;i<256;++i){
            int[] clone=new int[4];
            int n=i;
            for (int j=0;j<4;++j) {
                clone[j] = digits[n%4];
                n/=4;
            }
            ans.add(clone);
        }
        return ans;
    }
    int toMinutes(int[] digits){
        int hours=digits[0]*10+digits[1];
        if (hours>23)return -1;
        int minutes=digits[2]*10+digits[3];
        if (minutes>59)return -1;
        return hours*60+minutes;
    }

    public String nextClosestTime(String time) {
        int[] digits={time.charAt(0)-'0', time.charAt(1)-'0', time.charAt(3)-'0',time.charAt(4)-'0'};
        int minutes=toMinutes(digits);
        int min=Integer.MAX_VALUE;
        int[]best=null;
        for (int[] next: getnDigits(digits)){
            int minutes2=toMinutes(next);
            if (minutes2==-1||minutes2==minutes)continue;
            int delta=minutes2-minutes;
            if (delta<0)delta+=1440;
            if (delta<min){
                min=delta;
                best=next;
            }
        }
        if (best==null)best=digits;
        return String.format("%d%d:%d%d", best[0],best[1],best[2],best[3]);


    }
}