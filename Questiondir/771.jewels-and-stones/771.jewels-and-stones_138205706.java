class Solution {
    int finalResult = 0;
    int max = 1000000;
    int[] best = new int[max];
    public int slidingPuzzle(int[][] board) {

        int state = get(board);
        Arrays.fill(best, -1);
        best[state] = 0;
        dfs(board);
        int[][] target = new int[2][];
        target[0] = new int[]{1,2,3};
        target[1] = new int[]{4,5,0};
        finalResult = get(target);
        return best[finalResult];
    }
    
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    void dfs(int[][] board){
        //view(board);
        int x = -1;
        int y = -1;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == 0){
                    x = i;
                    y = j;
                    break;
                }
            }
            if(x != -1){
                break;
            }
        }
        int start = get(board);
        for(int i = 0; i < 4; i++){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx < 0 || tx >= 2 || ty < 0 || ty >= 3){
                continue;
            }
            int[][] nBoard = new int[2][];
            for(int j = 0; j < 2; j++){
                nBoard[j] = new int[3];
                for(int k = 0; k < 3; k++){
                    nBoard[j][k] = board[j][k];
                }
            }
            int tmp = nBoard[tx][ty];
            nBoard[tx][ty] = nBoard[x][y];
            nBoard[x][y] = tmp;
            int state = get(nBoard);
            if(best[state] == -1 || best[state] > best[start] + 1){
                best[state] = best[start] + 1;
                dfs(nBoard);
            }
        }
    }
    int get(int[][] board){
        int sum = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                sum = sum * 10 + board[i][j];
            }
        }
        return sum;
    }
    void view(int[][] board){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println(get(board));
        System.out.println("");
        
    }
}