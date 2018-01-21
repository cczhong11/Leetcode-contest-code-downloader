class Solution {
    public int maxChunksToSorted(int[] arr) {
    	int N = arr.length;
        int[] index = new int[N];
        for (int i = 0; i < N; ++i) {
        	index[i] = i;
        }
        for (int i = 1; i < N; ++i) {
        	for (int j = i - 1; j >= 0; --j) {
        		if (arr[index[j + 1]] < arr[index[j]]) {
        			int tmp = index[j];
        			index[j] = index[j + 1];
        			index[j + 1] = tmp;
        		}
        	}
        }
        for (int i = 0; i < N; ++i) {
        	System.out.println(i + " : " + index[i]);
        }
        int max = -1, res = 0;
        for (int i = 0; i < N; ++i) {
        	if (index[i] > max) {
        		max = index[i];
        	} 
        	if (i == max) {
        		++res;
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{4,3,2,1,0};
        System.out.println(solution.maxChunksToSorted(arr));
      }
}