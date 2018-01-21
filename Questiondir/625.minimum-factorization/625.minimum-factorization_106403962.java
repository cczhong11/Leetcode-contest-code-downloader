public class Solution {
    public int smallestFactorization(int a) {
        if(a<=9) return a;
        int[] freq = new int[10];
        for(int i=9; i>=2; i--){
            while(true){
                if(a%i==0){
                    freq[i]++;
                    a = a/i;
                }
                else{
                    break;
                }
            }
        }
        if(a>1) return 0;
        StringBuilder builder = new StringBuilder();
        for(int i=2; i<=9; i++){
            for(int j=0; j<freq[i]; j++){
                builder.append(i);
            }
        }
        
        if(builder.length()>String.valueOf(Integer.MAX_VALUE).length() || builder.length()==0) return 0;
        Long longResult = Long.parseLong(builder.toString());
        if(longResult>Integer.MAX_VALUE) return 0;
        return Integer.parseInt(builder.toString());
        
    }
}