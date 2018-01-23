	public class Solution {
		int pos = 0, len;
		char[] s;
		
	    public TreeNode str2tree(String ss) {
	        s = ss.toCharArray();
	        len = s.length;
	        return parse();
	    }
	    
	    public TreeNode parse()
	    {
	    	if(pos == len)return null;
	    	int num = num();
	    	TreeNode ret = new TreeNode(num);
	    	if(pos < len && s[pos] == '('){
	    		pos++;
	    		ret.left = parse();
	    		pos++;
	    	}
	    	if(pos < len && s[pos] == '('){
	    		pos++;
	    		ret.right = parse();
	    		pos++;
	    	}
	    	return ret;
	    }
	    
	    public int num()
	    {
	    	boolean sig = false;
	    	if(pos < len && s[pos] == '-'){
	    		sig = true;
	    		pos++;
	    	}
	    	int num = 0;
	    	while(pos < len && s[pos] >= '0' && s[pos] <= '9'){
	    		num = num * 10 + (s[pos]-'0');
	    		pos++;
	    	}
	    	return sig ? -num : num;
	    }
	}	
