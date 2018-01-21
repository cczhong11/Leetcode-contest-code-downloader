class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length,i=0;
        while (i<n)
        {
            if (bits[i]==0) 
            {
                i++;
                if (i==n) return true;
            }
            else
            {
                i++;
                if (bits[i]==0)
                {
                    i++;
                    if (i==n) return false;
                }
                else i++;
            }
        }
        return false;
    }
}