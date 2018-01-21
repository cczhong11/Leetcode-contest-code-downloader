class Solution {
    int len = 0;
    boolean[] check;
    int[][] dict;
    int[] tar;    
    int ans = -1;
    int convet(char x)
    {
        return (int)(x-'a');
    }
    public int minStickers(String[] stickers, String target) {        
        len = stickers.length;
        check = new boolean[len];
        dict = new int[len][26];
        tar = new int[26];        
        for (int i = 0;i<len;i++)
        {
            check[i] = true;
            for (int j = 0;j<26;j++) dict[i][j]= 0;
            for (int j = 0;j<stickers[i].length();j++) dict[i][convet(stickers[i].charAt(j))]++;
        }
        for (int i = 0;i<26;i++) tar[i] = 0;
        for (int i = 0;i<target.length();i++) tar[convet(target.charAt(i))]++;
        for (int i = 0;i<len;i++)
            for (int j = 0;j<26;j++)
                if (tar[j]==0) dict[i][j] = 0;
        for (int i = 0;i<len;i++)
            for (int j = 0;j<len;j++)
            if (i!=j)
            {
                boolean flag = true;
                for (int k = 0;k<26;k++)
                    if (dict[i][k]<dict[j][k]){flag =false;break;}
                if (flag) check[j] = false;
            }
        int[] now = new int[26];
        for (int i = 0;i<26;i++) now[i] = 0;
        /*
        for (int i = 0;i<26;i++) System.out.print(tar[i]+" ");
        System.out.println();
        for (int i = 0;i<len;i++)
        {
            System.out.println(check[i]);
            for (int j = 0;j<26;j++)
                System.out.print(dict[i][j]+" ");
            System.out.println();
        }
        */
        dfs(now,0);
        return ans;
    }
    void dfs(int[] now,int depth)
    {
        /*
        System.out.println(depth);
        for (int j = 0;j<26;j++)
            System.out.print(now[j]+" ");
        System.out.println();
        */
        if (ans!=-1&&depth>=ans) return;
        int maxlt = -1;
        for (int i = 0;i<26;i++)
            if (now[i]<tar[i])
            {
                if (maxlt==-1||tar[i]-now[i]>tar[maxlt]-now[maxlt]) maxlt = i;
            }
        if (maxlt==-1)
        {
            if (ans==-1||ans>depth) ans = depth;
            return;
        }
        for (int i = 0;i<len;i++)
            if (dict[i][maxlt]>0)
            {
                for (int j = 0;j<26;j++)
                    now[j] += dict[i][j];
                dfs(now,depth+1);
                for (int j = 0;j<26;j++)
                    now[j] -= dict[i][j];
            }
    }
}