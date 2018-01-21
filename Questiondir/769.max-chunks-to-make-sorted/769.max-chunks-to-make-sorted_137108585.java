class Solution {
    public int maxChunksToSorted(int[] arr) {
        int start=0;
        int count=0;
        while(start<arr.length){
            int end=start;
            for(int i=start;i<=end;i++){
                end=Math.max(end,arr[i]);
            }
            start=end+1;
            count++;
        }
        return count;
    }
}