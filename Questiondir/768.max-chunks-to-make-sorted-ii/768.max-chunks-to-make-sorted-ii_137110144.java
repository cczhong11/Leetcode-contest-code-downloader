class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int[][] a=new int[n][2];
        for (int i=0;i<n;i++) { a[i][0]=arr[i]; a[i][1]=i;}
                                                  
        Arrays.sort(a,(c,d)->(c[0]==d[0])?(c[1]-d[1]):(c[0]-d[0]));
        for (int i=0;i<n;i++) arr[i]=a[i][1];
        int j=0,ans=0;
        for (int i=0;i<n;i++)
        {
            j=Math.max(j,arr[i]);
            if (i>=j) ans++;
        }
        return ans;
    }
}