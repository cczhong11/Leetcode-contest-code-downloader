public class Solution {
    public int findIntegers(int num) {
        int cp[]=new int[40];
        cp[0]=1;
        cp[1]=2;
        for(int i=2;i<40;i++){
            cp[i]=cp[i-1]+cp[i-2];
        }
        
        int dig[]=new int[40];
        for(int i=0;i<40;i++){
            dig[i]=num%2;
            num/=2;
            System.out.print(dig[i]+" ");
        }
        System.out.println();
        
        int sum=0;
        for(int i=40-1;i>=0;i--){
            if(i==0){
                sum+=1;
            }
            if(i==0 && dig[i]==1){
                sum+=cp[i];
                break;
            }
            if(dig[i]==1 && dig[i-1]==0){
                sum+=cp[i];
            }
            if(dig[i]==1 && dig[i-1]==1){
                sum+=cp[i];
                sum+=cp[i-1];
                break;
            }
        }
        
        return sum;
    }
}