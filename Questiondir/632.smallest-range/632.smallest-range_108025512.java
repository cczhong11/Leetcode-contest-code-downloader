public class Solution {
    public int[] smallestRange(int[][] nums) {
        int len = nums.length;
        if(len==1) return new int[]{nums[0][0], nums[0][0]};
        int[]pos = new int[len];
        PriorityQueue<Integer> minpq = new PriorityQueue<>(2, (a,b)->nums[a][pos[a]]-nums[b][pos[b]]);
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(2, (a,b)->b-a);
        for(int i=0;i<len;i++){
            if(nums[i].length==0) return new int[]{0,0};
            minpq.add(i);
            maxpq.add(nums[i][0]);
        }
        int diff = Integer.MAX_VALUE;
        int[] result = {0,0};
        while(diff>0){
            int minRow = minpq.poll();
            int minVal = nums[minRow][pos[minRow]++];
            maxpq.remove(minVal);
            int maxVal = maxpq.peek();
            int cdiff = maxVal-minVal;
            if(cdiff<diff){
                diff = cdiff;
                result = new int[]{minVal, maxVal};
            }
            if(pos[minRow]==nums[minRow].length) break;
            minpq.offer(minRow);
            maxpq.offer(nums[minRow][pos[minRow]]);
        }
        return result;
    }
}