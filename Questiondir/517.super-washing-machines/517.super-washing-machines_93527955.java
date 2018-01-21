public class Solution {
    public int findMinMoves(int[] machines) {
        int sum=0;
        for(Integer i:machines)sum+=i;
        if(sum%machines.length!=0)return -1;
        int aim=sum/machines.length;
        int count=0;
        int[] left=new int[machines.length];
        int[] right=new int[machines.length];
        left[0]=0;
        right[0]=aim-machines[0];
        count+=machines[0]-aim;
        for(int i=1;i<machines.length;i++){
            left[i]=-right[i-1];
            count+=machines[i]-aim;
            right[i]=-count;
        }
        int max=0;
        for(int i=0;i<machines.length;i++){
            if(left[i]<=0&&right[i]<=0){
                if(-(left[i]+right[i])>max)max=-(left[i]+right[i]);
            }
            else {
                if(Math.max(Math.abs(left[i]),Math.abs(right[i]))>max)max=Math.max(Math.abs(left[i]),Math.abs(right[i]));
            }
        }
        return max;
    }
}