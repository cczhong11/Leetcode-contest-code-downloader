class Solution {
    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1,ll=0,rr=0;
        boolean bo=false;
        while (l<r)
        {
            if (s.charAt(l)!=s.charAt(r))
            {
                if (bo) break;
                ll=l;
                rr=r-1;
                l++;
                bo=true;
            }
            else
            {
                l++;
                r--;
            }
            if (l>=r) return true;
        }
        l=ll;r=rr;
        while (l<r)
        {
            if (s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}