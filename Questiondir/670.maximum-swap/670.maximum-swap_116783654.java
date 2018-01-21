class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] str = s.toCharArray();
        char[] str_sort = s.toCharArray();
        Arrays.sort(str_sort);
        reverse(str_sort);
        int len = str.length;
        for (int i = 0; i < len; i++) {
            if (str[i] != str_sort[i]) {
                for (int j = len - 1; j > i; j--) {
                    if (str[j] == str_sort[i]) {
                        str[j] = str[i];
                        str[i] = str_sort[i];
                        return Integer.valueOf(new String(str));
                    }
                }
            }
        }
        return num;
    }
    private void reverse(char[] ary) {
        int i = 0, j = ary.length - 1;
        while (i < j) {
            char tmp = ary[j];
            ary[j] = ary[i];
            ary[i] = tmp;
            i++;
            j--;
        }
    }
}