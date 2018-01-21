	class Solution {
	    public int calPoints(String[] ops) {
	        int[] stack = new int[20000];
	        int p = 0;
	        for(String s : ops){
	        	if(s.equals("C")){
	        		if(p > 0)p--;
	        	}else if(s.equals("D")){
	        		if(p-1 < 0)continue;
	        		stack[p] = stack[p-1] * 2;
	        		p++;
	        	}else if(s.equals("+")){
	        		if(p-2 < 0)continue;
	        		stack[p] = stack[p-1] + stack[p-2];
	        		p++;
	        	}else{
	        		int val = Integer.parseInt(s);
	        		stack[p++] = val;
	        	}
	        }
	        int ret = 0;
	        for(int i = 0;i < p;i++){
	        	ret += stack[i];
	        }
	        return ret;
	    }
	}	
