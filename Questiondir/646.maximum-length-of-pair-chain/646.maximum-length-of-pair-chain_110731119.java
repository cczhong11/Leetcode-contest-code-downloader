public class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length==0){
            return 0;
        }
        Arrays.sort(pairs,(x,y)-> {return x[1]-y[1];});
        int l = 1;
        int[] now = pairs[0];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>now[1]){
                now = pairs[i];
                l++;
            }else{
                
            }
        }
        return l;
    }
}