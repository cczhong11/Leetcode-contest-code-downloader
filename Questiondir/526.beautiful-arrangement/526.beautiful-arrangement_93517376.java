public class Solution {
    public int countArrangement(int N) {
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        return dfs(arr, 1, N);
    }
    
    private int dfs(int[] arr, int index, int N) {
        int ans = 0;
        if (index == N + 1) {
            //System.out.println(Arrays.toString(arr));
            return 1;
        }
        for (int i = index; i <= N; i++) {
            if ((arr[i] % index == 0) ||
                (index % arr[i] == 0)) {
                    swap(arr, index, i);
                    ans += dfs(arr, index + 1, N);
                    swap(arr, index, i);
                }
        }
        return ans;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}