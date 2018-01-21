class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        boolean[] arr = new boolean[bits.length+1];
        arr[0] = true;
        int index = 1;
        while(index<bits.length){
            if(arr[index-1]){
                if(bits[index-1]==0){
                    arr[index] = true;
                }
                if(index<bits.length-1){
                    if(bits[index-1]==1){
                        arr[index+1] = true;
                    }
                }
            }
            index++;
        }
        return arr[bits.length-1];
    }
}