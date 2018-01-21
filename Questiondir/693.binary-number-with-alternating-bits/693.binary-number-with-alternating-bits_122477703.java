class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean check = true;
        int now = -1;
        while (n>0)
        {
            int tmp = n%2;
            if (now==-1||(now==0&&tmp==1)||(now==1&&tmp==0))
            {
                now = tmp;
                n/=2;
            }
            else 
            {
                check = false;
                break;
            }
        }
        return check;
    }
}