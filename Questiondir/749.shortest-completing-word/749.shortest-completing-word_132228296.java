class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] arr = new int[26];
        
        for (char c : licensePlate.toCharArray()) {
            if (!Character.isLetter(c)) continue;
            arr[Character.toLowerCase(c) - 'a']++;
        }
        
        String res = null;
        
        for (String word : words) {
            if (isCompletingWord(Arrays.copyOf(arr, arr.length), word)) {
                if (res == null || res.length() > word.length()) {
                    res = word;
                }
            }
        }
        
        return res;
    }
    
    private boolean isCompletingWord(int[] arr, String word) {
        for (char c : word.toCharArray()) {
            arr[c - 'a']--;
        }
        
        for (int cnt : arr) {
            if (cnt > 0) return false;
        }
        
        return true;
    }
}