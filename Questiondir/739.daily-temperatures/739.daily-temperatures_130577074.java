class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] a=temperatures;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        for (int i=n-1;i>=0;i--)
        {
            while (!st.isEmpty() && a[st.peek()]<=a[i]) st.pop();
            if (st.isEmpty()) ans[i]=0; else ans[i]=st.peek()-i;
            st.push(i);
        }
        return ans;
    }
}