public class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(tasks == null || tasks.length == 0) return 0;
        if(n<=0) return tasks.length;

        int[] count = new int[26];
        int[] valid = new int[26];
        for(char c: tasks) {
            count[c-'A']++;
        }
        
        int length = tasks.length;
        int total = tasks.length;

        int i=0;
        for( ; total > 0; i++) {
            boolean found = false;
            int maxCountIndex = -1;
            int maxCount = 0;
            for(int j=0; j<count.length; j++) {
                if(valid[j] > i || count[j] == 0) {
                    continue;
                } else {
                    found = true;
                    if(count[j] > maxCount) {
                        maxCount = count[j];
                        maxCountIndex = j;
                    }
                }
            }
            if(found == false) {
                continue;
            } else {
                total--;
                count[maxCountIndex]--;
                valid[maxCountIndex] = i+(n+1);
            }
        }
        
        return i;
    }
}