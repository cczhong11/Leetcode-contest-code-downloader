class Solution {
    public boolean isok(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i - 1] > a[i]) return false;
        return true;
    }

    public boolean checkPossibility(int[] nums) {
        if (isok(nums)) return true;
        for (int i = 1; i < nums.length; i++)
            if (nums[i - 1] > nums[i]) {
                int[] a = nums.clone();
                a[i - 1] = i - 2 >= 0 ? a[i - 2] : Integer.MIN_VALUE;
                if (isok(a)) return true;

                a = nums.clone();
                a[i] = i + 1 < a.length ? a[i + 1] : Integer.MAX_VALUE;
                if (isok(a)) return true;
            }
        return false;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(sol.checkPossibility(new int[]{4, 3, 2}));
        System.out.println(sol.checkPossibility(new int[]{3, 4, 2, 3}));
    }

}