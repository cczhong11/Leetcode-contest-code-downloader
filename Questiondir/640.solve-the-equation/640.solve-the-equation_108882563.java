import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Solution {
    int a, b;
    
    public String solveEquation(String equation) {
        String[] sp = equation.split("=");
        Pattern p = Pattern.compile("[+-](\\d*)(x?)");
        Matcher m = p.matcher(sp[0].charAt(0)=='-'? sp[0] : "+"+sp[0]);
        System.out.println(Arrays.toString(sp));
        while (m.find()) {
            int v = 1;
            if (m.group(1).length() > 0) {
                v = Integer.parseInt(m.group(1));
            }
            System.out.println(" " + v + " " + m.group(1) + " " + m.group(2)); 
            if (m.group().charAt(0) == '-') {
                v = -v;
            }
            if (m.group(2).length() == 0) {
                a += v;
            } else {
                b += v;
            }
        }
        m = p.matcher(sp[1].charAt(0)=='-'? sp[1] : "+"+sp[1]);
        while (m.find()) {
            int v = 1;
            if (m.group(1).length() > 0) {
                v = Integer.parseInt(m.group(1));
            }
            if (m.group().charAt(0) == '-') {
                v = -v;
            }
            System.out.println(" " + v + " " + m.group() + " " + m.group(2)); 
            if (m.group(2).length() == 0) {
                a -= v;
            } else {
                b -= v;
            }
        }
        System.out.println("a: " + a + " b: " + b);
        
        if (b == 0) {
            if (a == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + (-a/b);
        }
    }
}