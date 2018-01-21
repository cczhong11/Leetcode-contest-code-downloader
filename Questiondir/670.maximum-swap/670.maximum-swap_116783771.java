class Solution {
    public int maximumSwap(int num) {
        int maxVal = num;
        String str = String.valueOf(num);
        for (int i=0; i<str.length(); i++){
            for (int j=i+1; j<str.length(); j++){
                String newStr = str.substring(0,i) + str.charAt(j) + str.substring(i+1,j) + str.charAt(i) + str.substring(j+1);
                if (Integer.valueOf(newStr) > maxVal){
                    maxVal = Integer.valueOf(newStr);
                }
            }
        }
        
        return maxVal;
    }
}