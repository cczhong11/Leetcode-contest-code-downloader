class Solution {
    public static boolean hasAlternatingBits(int n){
    	String s = Integer.toString(n, 2);
    	
    	for(int i = 0; i < s.length(); i++){
    		if(s.charAt(i) - '0' == (i % 2))return false;
    	}
    	return true;
    }
}