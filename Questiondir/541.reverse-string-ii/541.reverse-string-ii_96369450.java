public class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length / k + 1; i ++) {
            if (i % 2 == 0) {
                int start = i * k;
                int end = Math.min((i + 1) * k, arr.length) - 1;
                reverse(arr, start, end);
            }
        }
        return String.valueOf(arr);
    }
    
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start ++;
            end --;
        }
    }
}