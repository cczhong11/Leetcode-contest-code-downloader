class Solution {
    public static int reachNumber(int target){
		target = Math.abs(target);
        
		long i = 0;
		while(i * (i + 1) / 2 < target || (i * (i + 1) / 2 - target) % 2 == 1)i++;
		return (int) i;
	}
}