public class Solution {
    public String findContestMatch(int n) {
    	if(n < 2) return "";
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n / 2; i ++) {
        	list.add("(" + i + "," + (n - i + 1) + ")");
        }
        
        while(list.size() > 1) {
        	List<String> nextList = new ArrayList<>();
        	for(int i = 1; i <= list.size() / 2; i ++) {
        		nextList.add("(" + list.get(i - 1) + "," + list.get(list.size() - i) + ")");
        	}
        	list = nextList;
        }
        return list.get(0);
    }
}