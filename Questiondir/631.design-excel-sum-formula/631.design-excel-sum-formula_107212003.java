
import java.util.HashMap;
import java.util.Map;

public class Excel {
    private int[][] table;
    private Map<String,String[]> sums = new HashMap<>();
    public Excel(int H, char W) {
        table = new int[H][W-'A'+1];
        for(int i = 0; i < H; i++){
            for(int j = 0; j <= W-'A'; j++){
                table[i][j] = 0;
            }
        }
    }

    public void set(int r, char c, int v) {
        table[r-1][c-'A'] = v;
        String theKey = String.format("%d%c",r,c);
        if(sums.containsKey(theKey)){
            sums.remove(theKey);
        }
        for(String key : sums.keySet()){
            sum(key,sums.get(key));
        }
    }

    public int get(int r, char c) {
        String theKey = String.format("%d%c",r,c);
        if(sums.containsKey(theKey)){
            sum(theKey, sums.get(theKey));
        }
        return table[r-1][c-'A'];
    }

    public int sum(int r, char c, String[] strs) {
        int sum = 0;
        for(String s : strs){
            if(s.indexOf(':')==-1){
                sum += table[Integer.parseInt(s.substring(1))-1][s.charAt(0)-'A'];
            } else {
                String[] split = s.split(":");
                for(int i = split[0].charAt(0)-'A'; i <= split[1].charAt(0)-'A'; i++){
                    for(int j = Integer.parseInt(split[0].substring(1))-1; j < Integer.parseInt(split[1].substring(1)); j++){
                        sum += table[j][i];
                    }
                }
            }
        }
        table[r-1][c-'A'] = sum;
        sums.put(String.format("%d%c",r,c),strs);
        return sum;
    }

    public int sum(String s, String[] strs){
        return sum(Integer.parseInt(s.substring(0,s.length()-1)),s.charAt(s.length()-1),strs);
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */