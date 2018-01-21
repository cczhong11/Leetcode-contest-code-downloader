public class Solution {
    public int findIntegers(int num) {
        int[] count = new int[32];
        count[0] = 1;
        count[1] = 2;
        count[2] = 3;
        for(int i = 3; i < count.length; i++){
            count[i] = count[i - 1] + count[i - 2];
        }
        String binaryStr = Integer.toBinaryString(num);
        int n = binaryStr.length();
        int sum = count[n - 1] + 1;
        for(int i = 1; i < n; i++){
            char c = binaryStr.charAt(i);
            if(i > 1 && binaryStr.charAt(i - 1) == '1' && binaryStr.charAt(i - 2) == '1'){
                break;
            }
            if(c == '0') continue;
            int l = n - i - 1;
            sum += count[l];
        }
        for(int i = 0; i < n - 1; i++){
            if(binaryStr.charAt(i) == '1' && binaryStr.charAt(i + 1) == '1'){
                sum -= 1;
                break;
            }
        }
        return sum;
    }
}