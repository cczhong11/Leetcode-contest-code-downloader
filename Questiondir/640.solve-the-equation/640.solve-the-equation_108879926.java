import java.math.BigInteger;

public class Solution {
	    public String solveEquation(String equation) {
	        String[] lr = equation.split("=");
	        BigInteger[] L = go(lr[0]);
	        BigInteger[] R = go(lr[1]);
	        if(L[0].equals(R[0])){
	        	if(L[1].equals(R[1])){
	        		return "Infinite solutions";
	        	}else{
	        		return "No solution";
	        	}
	        }else{
	        	return "x=" + (R[1].subtract(L[1]).divide(L[0].subtract(R[0])));
	        }
	    }
	    
	    BigInteger[] go(String f)
	    {
	    	String[] plus = f.split("\\+");
	    	BigInteger A = BigInteger.ZERO;
	    	BigInteger B = BigInteger.ZERO;
	    	for(String p : plus){
	    		String[] minus = p.split("-");
	    		for(int i = 0;i < minus.length;i++){
	    			if(minus[i].length() == 0)continue;
	    			if(minus[i].endsWith("x")){
	    				if(minus[i].length() == 1){
	    					if(i == 0){
	    						A = A.add(BigInteger.ONE);
	    					}else{
	    						A = A.subtract(BigInteger.ONE);
	    					}
	    				}else{
	    					BigInteger x = new BigInteger(minus[i].substring(0, 
	    							minus[i].length()-1));
	    					if(i == 0){
	    						A = A.add(x);
	    					}else{
	    						A = A.subtract(x);
	    					}
	    				}
	    			}else{
    					BigInteger x = new BigInteger(minus[i]);
    					if(i == 0){
    						B = B.add(x);
    					}else{
    						B = B.subtract(x);
    					}
	    			}
	    		}
	    	}
	    	return new BigInteger[]{A, B};
	    }
	}
