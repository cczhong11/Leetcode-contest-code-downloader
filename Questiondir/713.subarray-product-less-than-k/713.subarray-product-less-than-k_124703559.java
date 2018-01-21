class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < k) {
                heap.offer(new int[] {i, nums[i]});
            }
        }
        
        int number = 0;
        
        while (!heap.isEmpty() && heap.peek()[1] < k) {
            int[] num = heap.poll();
            number++;
            
            if (num[0] + 1 < n) {
                heap.offer(new int[] {num[0] + 1, num[1] * nums[num[0] + 1]});
            }
        }
        
        return number;
    }
}