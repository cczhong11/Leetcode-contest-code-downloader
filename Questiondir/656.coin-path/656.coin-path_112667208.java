public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        int[] f = new int[n];
        int[] prev = new int[n];
        List<List<Integer>> paths = new ArrayList<>();
        for (int i=0;i<n;i++)
            paths.add(new ArrayList<>());
        paths.get(0).add(0);
        
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = A[0];
        for (int i=0;i<n;i++){
            //System.out.println(i);
            if (f[i]<Integer.MAX_VALUE)
                for (int j=i+1;j<n && j<=i+B;j++){
                    if (A[j]>=0)
                        if (f[i] + A[j] < f[j]){
                            f[j] = f[i] + A[j];
                            prev[j] = i;
                            paths.get(j).clear();
                            paths.get(j).addAll(paths.get(i));
                            paths.get(j).add(j);
                        }
                        else if (f[i] + A[j] == f[j] && prior(paths, i, prev[j])){
                            prev[j] = i;
                            paths.get(j).clear();
                            paths.get(j).addAll(paths.get(i));
                            paths.get(j).add(j);
                        }
                }
        }
        
        List<Integer> res = new ArrayList<>();
        if (f[n-1]==Integer.MAX_VALUE){
            return res;
        }
        else{
            Stack<Integer> stack = new Stack<>();
            int cur = n-1;
            while (stack.isEmpty() || stack.peek()!=cur){
                stack.push(cur);
                cur = prev[cur];
            }
            while (stack.size()>0){
                res.add(stack.pop()+1);
            }
            return res;
        }
    }
    
    /*private boolean prior(int[] prev, int x, int y){
        Stack<Integer> stack1 = new Stack<>();
        int cur = x;
        while (stack1.isEmpty() || stack1.peek()!=cur){
                stack1.push(cur);
                cur = prev[cur];
        }
        
        Stack<Integer> stack2 = new Stack<>();
        cur = y;
        while (stack2.isEmpty() || stack2.peek()!=cur){
                stack2.push(cur);
                cur = prev[cur];
        }
        
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if (stack1.peek()<stack2.peek())
                return true;
            if (stack1.peek()>stack2.peek())
                return false;
        }
        
        return stack1.isEmpty();
    }*/
    
    private boolean prior(List<List<Integer>> paths, int x, int y){
        List<Integer> l1 = paths.get(x);
        List<Integer> l2 = paths.get(y);
        for (int i=0;i<Math.min(l1.size(),l2.size());i++){
            if (l1.get(i)<l2.get(i))
                return true;
            if (l1.get(i)>l2.get(i))
                return false;
        }
        return l1.size()>l2.size();
    }
}