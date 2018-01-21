public class Solution {
    public static int findIntegers(int num) {
        return findIntegers(num, new HashMap<Integer, Integer>());
    }    
    
  public static int findIntegers(int num, Map<Integer, Integer> map) {
 
    
        if (num <= 2) return num+1;
    
        Integer memo = map.get(num);
        if (memo != null) return memo;    
    
        int msb = 31 - Integer.numberOfLeadingZeros(num);
     
        int subNum = 0;
        for (int i=0;i<=msb-1;i++) subNum |= 1 << i;
       
      	int subNum2 = num;
        if ( ((num >> (msb - 1)) & 1) == 1)  subNum2 = subNum >> 1;
        else {
          for (int i=31;i>msb-2;i--) subNum2 &= ~(1 << i);          
        }
        
        
  
        int result = findIntegers(subNum, map) + findIntegers(subNum2, map);
        map.put(num, result);
 
         
        return result;
    
    
  }    
    
}