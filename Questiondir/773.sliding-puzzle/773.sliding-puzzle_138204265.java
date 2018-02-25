import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    int bit( int k ) { return 1 << k; }
    int mask( int k ) { return bit(k)-1; }
    boolean valid( int x, int y ) { return 0 <= x && x < 2 && 0 <= y && y < 3; }
    Queue<Integer> q;
    int convert( int [][]board ) {
        int u = 0,k = 0;
        for ( int i = 0; i < 2; ++i )
            for ( int j = 0; j < 3; ++j, ++k )
                u |= (board[i][j] << (3*k));
        assert k == 6;
        return u;
    }
    int []wx = new int[6], wy = new int[6];
    Map<Integer,Integer> dist;
    public int slidingPuzzle(int[][] board) {
        int i,j,k,x,y,nx,ny,u,v;
        q = new LinkedList<>();
        dist = new HashMap<>();
        int [][]t = {{1,2,3},{4,5,0}};
        k = 0;
        int T = convert(t);
        for ( i = 0; i < 2; ++i )
            for ( j = 0; j < 3; ++j ) {
                wx[k] = i;
                wy[k++] = j;
            }
        for ( dist.put(u = convert(board),0), q.add(u); !q.isEmpty(); ) {
            u = q.poll();
            if ( u == T ) return dist.get(u);
            x = y = -1;
            for ( k = 0, i = 0; i < 2 && x == -1; ++i )
                for ( j = 0; j < 3; ++j, ++k )
                    if ( ((u>>(3*k)) & mask(3)) == 0 ) {
                        x = i; y = j;
                        break ;
                    }
            assert( x != -1 );
            for ( nx = x-1; nx <= x+1; ++nx )
                for ( ny = y-1; ny <= y+1; ++ny )
                    if ( Math.abs(nx-x)+ Math.abs(ny-y) == 1 )
                        if ( valid(nx,ny) ) {
                            int nk = 3*nx+ny;
                            v = u;
                            int g = (v >> (3*nk))&mask(3);
                            v &= ~(mask(3) << (3*nk));
                            v |= g << (3*k);
                            if ( !dist.containsKey(v) || dist.get(v) > dist.get(u)+1 ) {
                                dist.put(v,dist.get(u)+1);
                                q.add(v);
                            }
                        }
        }
        return -1;
    }
}