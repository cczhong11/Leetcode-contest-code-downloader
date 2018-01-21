public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        int len = flowerbed.length;
        int i=0;
        while(n>0&&i<len){
            if((i-1<0||flowerbed[i-1]==0)&&(i+1==len || flowerbed[i+1]==0)&&flowerbed[i]==0){
                n--;
                flowerbed[i]=1;
                i+=2;
            }else{
                i++;
            }
        }
        return n==0;
    }
}