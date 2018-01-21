class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer>ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for(int as: asteroids){
            if(as < 0 ){
                boolean exploded = false;
                while(!dq.isEmpty()){
                    if(dq.peekLast() == -as){
                        dq.pollLast();
                        exploded = true;
                        break;
                    }
                    else if(dq.peekLast() > -as){
                        exploded = true;
                        break;
                    }
                    else dq.pollLast();
                }
                if(exploded) continue;
                if(dq.isEmpty()) {
                    ans.add(as);
                }
            }
            else if(as > 0) {
                dq.offer(as);
            }
            else{
                if(!dq.isEmpty() && dq.peekLast() > 0) continue;
                dq.offer(as);
            }
        }
        while(!dq.isEmpty()){
            ans.add(dq.poll());
        }
        int[] ret = new int[ans.size()];
        for(int i = 0; i< ans.size(); i++) ret[i] = ans.get(i);
        return ret;
    }
}