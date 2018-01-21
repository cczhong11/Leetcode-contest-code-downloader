class Solution {
    public static int minStickers(String[] stickers, String target) {
        int[] targetCount = new int[26];
        for(int i = 0; i < target.length(); i++)targetCount[target.charAt(i) - 'a']++;
        
        int[][] lp = new int[stickers.length][26];
        for(int z = 0; z < stickers.length; z++){
        	String s = stickers[z];
        	for(int i = 0; i < s.length(); i++)lp[z][s.charAt(i) - 'a']++;
        }
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(Arrays.hashCode(new int[26]), 0);
        
        int n = util(memo, targetCount, lp);
        if(n >= 1000000)return -1;
        return n;
    }
    public static int util(HashMap<Integer, Integer> memo, int[] state, int[][] lp){
    	int hash = Arrays.hashCode(state);
    	if(memo.containsKey(hash))return memo.get(hash);
    	memo.put(hash, 1000000);
    	
    	int min = 1000000;
    	for(int i = 0; i < lp.length; i++){
    		int[] newState = new int[26];
    		for(int z = 0; z < lp[i].length; z++){
    			newState[z] = Math.max(0, state[z] - lp[i][z]);
    		}
    		
    		min = Math.min(min, util(memo, newState, lp));
    	}
    	
    	memo.put(hash, min + 1);
    	return min + 1;
    }
}