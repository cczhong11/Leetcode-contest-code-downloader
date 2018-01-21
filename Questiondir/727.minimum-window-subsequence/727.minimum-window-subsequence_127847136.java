class Solution {
    public String minWindow(String S, String T) {
        List<Integer>[] arr = new List[26];
        for (int i = 0; i < S.length(); i++){
            int index = S.charAt(i) - 'a';
            if (arr[index] == null) arr[index] = new ArrayList();
            arr[index].add(i);
        }
        if (T.length() > S.length()) return "";
        if (T.length() == 1){
            int c = T.charAt(0) - 'a';
            if (arr[c] != null) return T;
            else return "";
        }
        int[] res = search(S, 0, T, 0, arr);
        if (res[1] != -1) return S.substring(res[0], res[1]);
        else return "";
    }
    
    public int[] search(String S, int start_S, String T, int start_T, List<Integer>[] arr){
        if (start_T == T.length()) return new int[]{-1, start_S};
        if (start_S == S.length()) return new int[]{-1, -1};
        int c = T.charAt(start_T) - 'a';
        if (start_T == 0){
            int min_len = S.length() + 1;
            int[] res = {-1, -1};
            if (arr[c] == null) return new int[]{-1, -1};
            for (int i: arr[c]){
                int[] next = search(S, i + 1, T, start_T + 1, arr);
                if (next[1] == -1) return res;
                if (next[1] - i < min_len){
                    res[0] = i;
                    res[1] = next[1];
                    min_len = res[1] - res[0];
                }
            }
            return res;
        }
        else{
            int index = bsearch(arr[c], start_S);
            if (index == -1) return new int[]{-1, -1};
            int[] next = search(S, index + 1, T, start_T + 1, arr);
            return new int[]{-1, next[1]};
        }
    }
    
    public int bsearch(List<Integer> list, int target){
        if (list == null) return -1;
        if (list.get(list.size() - 1) < target) return -1;
        if (list.get(0) >= target) return list.get(0);
        int left = 0, right = list.size() - 1;
        while (true){
            int mid = left + (right - left) / 2;
            int mid_val = list.get(mid);
            if (left == right) return mid_val;
            if (mid_val < target) left = mid + 1;
            else if (mid_val == target) return mid_val;
            else right = mid;
        }
    }
}