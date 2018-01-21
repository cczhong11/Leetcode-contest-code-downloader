class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> lIndex=new LinkedList<Integer>();
        Queue<Integer> starIndex=new LinkedList<Integer>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                lIndex.offerLast(i);
            }
            else if(ch=='*'){
                starIndex.offer(i);
            }
            else{
                if(!lIndex.isEmpty()){
                    lIndex.pollLast();
                }
                else if(!starIndex.isEmpty()){
                    starIndex.poll();
                }
                else{
                    return false;
                }
            }
        }
        while(!lIndex.isEmpty()&&!starIndex.isEmpty()){
            if(lIndex.peekFirst()<starIndex.peek()){
                lIndex.poll();
                starIndex.poll();
            }
            else{
                starIndex.poll();
            }
        }
        return lIndex.isEmpty();
    }
}