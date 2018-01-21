import java.util.regex.*;

public class Solution {
    private Pattern p = Pattern.compile("^[-+]?(\\d*x)"), num = Pattern.compile("^[-+]?(\\d+)");
    private class Pair {
        int a,b;
        Pair( int a, int b ) {
            this.a = a;
            this.b = b;
        }
        Pair merge( Pair r, char ch ) {
            if ( ch == '-' )
                return new Pair(this.a-r.a,this.b-r.b);
            return new Pair(this.a+r.a,this.b+r.b);
        }
    }
    Pair f( String T ) {
        Matcher m;
        String ori = new String(T), s = new String(T);
        List<Pair> res = new ArrayList<>();
        //System.out.println(s);
        do {
            m = p.matcher(s);
            if ( m.find() ) {
                //System.out.println("Here"+m.group(1));
                res.add(new Pair(m.group(1).equals("x")?1:Integer.parseInt(m.group(1).substring(0,m.group(1).length()-1)),0));
                s = s.substring(m.group(0).length());
                //System.out.println("s = "+s);
                continue ;
            }
            m = num.matcher(s);
            if ( m.find() ) {
                //System.out.println("Aha"+m.group(1));
                res.add(new Pair(0,Integer.parseInt(m.group(1))));
                s = s.substring(m.group(0).length());
                //System.out.println("new s = "+s);
                continue ;
            }
            //System.out.println("HERE"+s);
            break ;
        } while ( true );
        int j = 0;
        Deque<Pair> q = new LinkedList<>();
        if ( ori.charAt(0) == '+' || ori.charAt(0) == '-' )
            q.addLast(new Pair(0,0));
        else q.addLast(res.get(j++));
        int i;
        for ( i = 0; i < ori.length(); ++i ) {
            char ch = ori.charAt(i);
            if ( ch == '-' || ch == '+' ) {
                Pair r = q.pollLast();
                q.addLast(r.merge(res.get(j++),ch));
            }
        }
        assert j == res.size();
        assert q.size() == 1;
        return q.pollLast();
    } 
    public String solveEquation(String s) {
        if ( s == null ) return s;
        int i,j,k,l,idx = s.indexOf("=");
        assert idx != -1;
        String a = s.substring(0,idx), b = s.substring(idx+1);
        Pair A = f(a), B = f(b);
        k = A.a-B.a; l = A.b-B.b;
        if ( k == 0 ) {
            if ( l == 0 ) return "Infinite solutions";
            return "No solution";
        }
        assert (l%k) == 0;
        return String.format("x=%d",-l/k);
    }
}