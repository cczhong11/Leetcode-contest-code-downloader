public class Solution {
    public int[] smallestRange(int[][] nums) {
        
        int totalSize = 0;
        for (int i=0; i<nums.length; i++)
            totalSize += nums[i].length;
        
        int[][] list = new int[totalSize][2];

        int k = 0;
        for (int i=0; i<nums.length; i++)
        {
            for (int j=0; j<nums[i].length; j++)
            {
                list[k][0] = nums[i][j];
                list[k][1] = i;
                k++;
            }            
        }

        Arrays.sort(list, new Comparator<int[]>() {
           public int compare(int[] a, int[] b)
           {
               int cmp = Integer.compare(a[0], b[0]);
               if (cmp != 0) return cmp;
               return Integer.compare(a[1], b[1]);
           }
        });
        
        //System.out.println(Arrays.deepToString(list));
        
        int[] table = new int[nums.length];

        int left = 0;
        int right = -1;
        int start = list[0][0];
        int end = list[list.length-1][0];
        k = 0;
        while (left < list.length)
        {
            while (right+1<list.length && k<nums.length)
            {
                int[] cur = list[++right];
                if (table[cur[1]]++ == 0) k++;
            }

            if (k == nums.length)
            {
                int best = end-start;
                int trial = list[right][0]-list[left][0];
                if (trial<best)
                {
                    start = list[left][0];
                    end = list[right][0];
                }
            }
            
            {
                int[] cur = list[left++];
                if (--table[cur[1]] == 0) k--;
            }
        }
        
        int[] result = new int[2];
        result[0] = start;
        result[1] = end;
        return result;
    }
}