class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int i=0 ;i<4; i++)
            list.add((double)nums[i]);
        
        return judgePoint24(list);
    }
    
    public boolean judgePoint24(List<Double> list){
        if(list.size() == 1) return list.get(0) == 24;
        
        for(int i=0; i<list.size()-1; i++){
            double a = list.remove(i);
            for(int j=i; j<list.size(); j++){
                double b = list.remove(j);
                double ans;
                ans = a+b;
                list.add(ans);
                if(judgePoint24(list)) return true;
                list.remove(ans);
                
                ans = a*b;
                list.add(ans);
                if(judgePoint24(list)) return true;
                list.remove(ans);
                
                ans = a-b;
                list.add(ans);
                if(judgePoint24(list)) return true;
                list.remove(ans);
                
                ans = a/b;
                list.add(ans);
                if(judgePoint24(list)) return true;
                list.remove(ans);
                
                ans = b-a;
                list.add(ans);
                if(judgePoint24(list)) return true;
                list.remove(ans);
                
                ans = b/a;
                list.add(ans);
                if(judgePoint24(list)) return true;
                list.remove(ans);
                
                list.add(j, b);
            }
            list.add(i, a);
        }
        return false;
    }
    
}