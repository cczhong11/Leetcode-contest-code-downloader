class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] nums=new int[arr.length];
        Map<Integer,Queue<Integer>> map=new HashMap<Integer,Queue<Integer>>();
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new LinkedList<Integer>());
            }
            map.get(nums[i]).offer(i);
        }
        int start=0;
        int count=0;
        while(start<arr.length){
            int end=start;
            for(int i=start;i<=end;i++){
                end=Math.max(end,map.get(arr[i]).poll());
            }
            start=end+1;
            count++;
        }
        return count;
    }
}