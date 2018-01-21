class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] pos = new int[A.length];
        for(int i=0;i<A.length;i++)
        {
            pos[i] = find(B,A[i]);
        }
        return pos;
    }
    public int find(int[] arr, int target)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==target)
                return i;
        }
        throw new IllegalArgumentException();
    }
}