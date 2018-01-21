class Solution {
    public boolean judgePoint24(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        double a = (double)nums[0];
        double b = (double)nums[1];
        double c = (double)nums[2];
        double d = (double)nums[3];
        Set<Double> result = helper4(a,b,c,d);
        if(result.contains(24.0)) return true;
        else return false;
        
    }
    private Set<Double> helper4(double a, double b, double c, double d){
        Set<Double> set = new HashSet<>();
        for(double i : helper2(a,b)){
            for(double j : helper2(c,d)){
                set.addAll(helper2(i,j));
            }
        }
        for(double i : helper2(a,c)){
            for(double j : helper2(b,d)){
                set.addAll(helper2(i,j));
            }
        } 
        for(double i : helper2(a,d)){
            for(double j : helper2(b,c)){
                set.addAll(helper2(i,j));
            }
        } 
        for(double i : helper3(a,b,c)){
            set.addAll(helper2(i,d));
        }
        for(double i : helper3(a,b,d)){
            set.addAll(helper2(i,c));
        } 
        for(double i : helper3(a,c,d)){
            set.addAll(helper2(i,b));
        }
        for(double i : helper3(b,c,d)){
            set.addAll(helper2(i,a));
        }
        return set;
    }
    
    private Set<Double> helper3(double a, double b, double c){
        Set<Double> set = new HashSet<>();
        for(double i : helper2(a,b)){
           set.addAll(helper2(i,c));
        }
        for(double i : helper2(a,c)){
            set.addAll(helper2(i,b)); 
        }
        for(double i : helper2(b,c)){
            set.addAll(helper2(i,a)); 
        }
        return set;
    }
    
    private Set<Double> helper2(double a, double b){
        Set<Double> set = new HashSet<>();
        set.add(a+b);
        set.add(a-b);
        set.add(b-a);
        set.add(a*b);
        if(b!=0.0) set.add(a/b);
        if(a != 0.0) set.add(b/a);
        return set;
    }
    
}