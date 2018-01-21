public class Solution {
    public String predictPartyVictory(String senate) {
    		char[] people = senate.toCharArray();
    		while(true) {
    			List<Integer> rIdx = new LinkedList<>();
        		int rForwardKill = 0;
        		
        		List<Integer> dIdx = new LinkedList<>();
        		int dForwardKill = 0;
        		
    			for(int i = 0; i < people.length; i++) {
        			if(people[i] == 'R') {
        				if(dForwardKill > 0) {
        					dForwardKill--;
        					people[i] = 'K'; // dead
        				} else {
        					rForwardKill++;
        					rIdx.add(i);
        				}
        			} else if(people[i] == 'D'){
        				if(rForwardKill > 0) {
        					rForwardKill--;
        					people[i] = 'K'; // dead
        				} else {
        					dForwardKill++;
        					dIdx.add(i);
        				}
        			}
        		}
    			
    			if(rIdx.isEmpty()) return "Dire";
    			if(dIdx.isEmpty()) return "Radiant";
    			
    			
    			while(dForwardKill != 0 && !rIdx.isEmpty()) {
				int idx = rIdx.remove(0);
				people[idx] = 'K';
				dForwardKill--;
			}
    			
    			while(rForwardKill != 0 && !dIdx.isEmpty()) {
    				int idx = dIdx.remove(0);
    				people[idx] = 'K';
    				rForwardKill--;
    			}
    			
    			//System.out.println(people);
    		}
    }
}