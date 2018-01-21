public class Solution {
    public String predictPartyVictory(String senate) {
        int len = senate.length();
        int[] ban = new int[len];
        int r = 0;
        int d = 0;
        for(int i = 0; i < len; i++) {
            if(senate.charAt(i) == 'R') {
                r++;
                ban[i] = 1;
            } else {
                d++;
                ban[i] = -1;
            }
        }
        if(r == 0)  return "Dire";
        if(d == 0)  return "Radiant";
        while(true) {
        for(int i = 0; i < len; i++) {
            if(ban[i] == 1) {
                for(int j = i + 1; j <= len; j++) {
                    if(j == len) {
                        if(--d == 0)  return "Radiant";
                        else {
                            for(int k = 0; k < len; k++) {
                                if(ban[k] == -1) {
                                    ban[k] = 0;
                                    break;
                                }
                            }
                        }
                    } else if(ban[j] == -1) {
                        if(--d == 0)  return "Radiant";
                        ban[j] = 0;
                        break;
                    }
                }
            } else if(ban[i] == -1) {
                for(int j = i + 1; j <= len; j++) {
                    if(j == len) {
                        if(--r == 0)  return "Dire";
                        else {
                            for(int k = 0; k < len; k++) {
                                if(ban[k] == 1) {
                                    ban[k] = 0;
                                    break;
                                }
                            }
                        }
                    } else if(ban[j] == 1) {
                        if(--r == 0)  return "Dire";
                        ban[j] = 0;
                        break;
                    }
                }
            }
        }
        }
    }
}