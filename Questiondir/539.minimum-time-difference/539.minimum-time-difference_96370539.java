public class Solution {
    public int get_difference(String a , String b){
		if(a.compareTo(b) < 0) return get_difference(b , a);
		int hour_a = Integer.valueOf(a.split(":")[0]);
		int min_a = Integer.valueOf(a.split(":")[1]);
		int hour_b = Integer.valueOf(b.split(":")[0]);
		int min_b = Integer.valueOf(b.split(":")[1]);
		int ans_a = hour_a * 60 + min_a;
		int ans_b = hour_b * 60 + min_b;
		return Math.min(ans_a - ans_b , (ans_b + 24 * 60 - ans_a));
	}

	public int findMinDifference(List<String> timePoints) {
		HashSet<String> set = new HashSet<>(timePoints);
		ArrayList<String> list = new ArrayList<>(set);
		if(list.size() < timePoints.size()) return 0;
		int ans = 24 * 60;
		for(int i = 0 ; i < list.size() ; i ++){
			for(int j = i + 1 ; j < list.size() ; j ++){
				ans = Math.min(ans , get_difference(list.get(i) , list.get(j)));
			}
		}
		return ans;
	}
}