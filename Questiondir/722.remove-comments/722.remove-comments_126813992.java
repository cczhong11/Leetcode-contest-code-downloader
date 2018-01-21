	class Solution {
	    public List<String> removeComments(String[] source) {
	        char[] s = String.join("\n", source).toCharArray();
	        int n = s.length;
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0;i < n;i++){
	        	if(i+1 < n && s[i] == '/' && s[i+1] == '/'){
	        		while(i < n && s[i] != '\n')i++;
	        		if(i < n && s[i] == '\n')i--;
	        	}else if(i+1 < n && s[i] == '/' && s[i+1] == '*'){
	        		i+=2;
	        		while(i < n && !(s[i] == '*' && s[i+1] == '/'))i++;
	        		i++;
	        	}else{
	        		sb.append(s[i]);
	        	}
	        }
	        List<String> ret = new ArrayList<>();
	        String[] sp = sb.toString().replaceAll("\n+", "\n").replaceAll("\n$", "").replaceAll("^\n", "").split("\n");
	        for(String t : sp)ret.add(t);
	        return ret;
	    }
	}	
