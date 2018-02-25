class Solution {
    int[][] bo={{0,1,0,1,0,0},
               {1,0,1,0,1,0},
               {0,1,0,0,0,1},
               {1,0,0,0,1,0},
               {0,1,0,1,0,1},
               {0,0,1,0,1,0}};
    public int slidingPuzzle(int[][] board) {
        String now="";
        int zero=0;
        for (int i=0;i<2;i++)
            for (int j=0;j<3;j++)
            {
                now+=board[i][j];
                if (board[i][j]==0) zero=i*3+j;
            }
        Map<String,Integer> map=new HashMap<>();
        Queue<String> q=new ArrayDeque<>();
        Queue<Integer> qi=new ArrayDeque<>();
        q.offer(now);
        qi.offer(0);
        map.put(now,zero);
        while (!q.isEmpty())
        {
            String s=q.poll();
            int x=qi.poll();
            if (s.equals("123450")) return x;
            zero=map.get(s);
            for (int i=0;i<6;i++)
                if (bo[zero][i]==1)
                {
                    String ss="";
                    for (int j=0;j<6;j++)
                    {
                        if (j==zero) ss+=s.charAt(i);
                        else
                        {
                            if (j==i) ss+=0;
                            else ss+=s.charAt(j);
                        }
                    }
                    if (map.containsKey(ss)) continue;
                    map.put(ss,i);
                    q.offer(ss);
                    qi.offer(x+1);
                }
        }
        return -1;
    }
}