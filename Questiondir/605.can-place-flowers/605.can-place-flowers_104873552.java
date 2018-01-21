public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=n;
        int [] copy=Arrays.copyOf(flowerbed,flowerbed.length);
        for(int i=0;i<flowerbed.length;i++){
            if(copy[i]==0 && (i==0 || copy[i-1]==0)&&(i==flowerbed.length-1 || copy[i+1]==0)){
                count--;
                copy[i]=1;
            }
        }
        return !(count>0);
    }
}