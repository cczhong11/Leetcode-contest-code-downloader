	class Solution {
	    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
	        if(words1.length != words2.length)return false;
	        int n = words1.length;
	        for(int i = 0;i < n;i++){
	        	if(words1[i].equals(words2[i]))continue;
	        	boolean ok = false;
	        	for(String[] p : pairs){
	        		if(words1[i].equals(p[0]) && words2[i].equals(p[1])){
	        			ok = true;
	        			break;
	        		}
	        		if(words1[i].equals(p[1]) && words2[i].equals(p[0])){
	        			ok = true;
	        			break;
	        		}
	        	}
	        	if(!ok)return false;
	        }
	        return true;
	    }
	}	
