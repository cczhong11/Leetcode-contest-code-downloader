class Solution {
    public int flipLights(int n, int m) {
        if (n==0)
            return 1;
        
        if (n==1)
            return (m==0) ? 1 : 2;
        
        if (n==2){
            switch (m){
                case 0: return 1;
                case 1: return 3;
                default: return 4;
            }
        }
        
        switch(m){
            case 0: return 1;
            case 1: return 4;
            case 2: return 7;
            default: return 8;
        }
    }
}