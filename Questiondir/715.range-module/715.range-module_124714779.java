class RangeModule {
    TreeMap<Integer,Integer> ts;
    public RangeModule() {
        this.ts=new TreeMap<Integer,Integer>();
    }
    
    public void addRange(int left, int right) {
        Integer lower=this.ts.floorKey(left);
        if(lower!=null&&this.ts.get(lower)>=left){
            left=Math.min(left,lower);
            right=Math.max(right,this.ts.get(lower));
            this.ts.remove(lower);
        }
        while(this.ts.floorKey(right)!=null){
            lower=this.ts.floorKey(right);
            if(lower<=left){
                break;
            }
            right=Math.max(this.ts.get(lower),right);
            this.ts.remove(lower);
        }
        ts.put(left,right);
    }
    
    public boolean queryRange(int left, int right) {
        Integer lower=this.ts.floorKey(left);
        if(lower==null){
            return false;
        }
        return this.ts.get(lower)>=right;
    }
    
    public void removeRange(int left, int right) {
        Integer lower=this.ts.floorKey(left);
        if(lower!=null&&this.ts.get(lower)>left){
            if(lower<left){
                if(this.ts.get(lower)<=right){
                    this.ts.put(lower,left);
                }
                else{
                    int end=this.ts.get(lower);
                    this.ts.put(lower,left);
                    this.ts.put(right,end);
                }
            }
            else{
                if(this.ts.get(lower)<=right){
                    this.ts.remove(lower);
                }
                else{
                    int end=this.ts.get(lower);
                    this.ts.remove(lower);
                    this.ts.put(right,end);
                }
            }
        }
        while(this.ts.ceilingKey(left)!=null){
            Integer higher=this.ts.ceilingKey(left);
            if(higher>=right){
                break;
            }
            else{
                if(this.ts.get(higher)<=right){
                    this.ts.remove(higher);
                }
                else{
                    int end=this.ts.get(higher);
                    this.ts.remove(higher);
                    this.ts.put(right,end);
                    break;
                }
            }
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */