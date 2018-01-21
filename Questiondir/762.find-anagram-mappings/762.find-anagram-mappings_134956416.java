class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int n=A.length;
        boolean[] bo=new boolean[n];
        int[] ans=new int[n];
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
                if (!bo[j] && A[i]==B[j])
                {
                    bo[j]=true;
                    ans[i]=j;
                    break;
                }
        }
        return ans;
    }
}