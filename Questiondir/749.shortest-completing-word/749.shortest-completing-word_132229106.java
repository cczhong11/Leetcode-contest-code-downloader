class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] p = new int[26];
        int t = 0;
        for (int i=0;i<licensePlate.length();i++){
            char x = licensePlate.charAt(i);
            if (x <'A') continue;
            if (x<'a')
                x = (char) (x-'A'+'a');
            p[x-'a']++;
            t++;
        }
        int max = 200;
        String res = "";
        for (int i=0;i<words.length;i++){
            int[] p1 = Arrays.copyOf(p, p.length);
            int t1 = t;
            //for (char x:words[i]){
            for (int j=0;j<words[i].length();j++){
            	char x = words[i].charAt(j);
                if (p1[x-'a']>0){
                    p1[x-'a']--;
                    t1--;
                }
                if (t1==0){
                    if (words[i].length()<max){
                        max = words[i].length();
                        res = words[i];
                    }
                }
            }
        }
        return res;
    }
}