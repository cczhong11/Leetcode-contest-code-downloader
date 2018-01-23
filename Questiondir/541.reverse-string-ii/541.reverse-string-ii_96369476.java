import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public String reverseStr(String s, int k) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); ) {
            StringBuilder tmp = new StringBuilder();
            for (j = i; j < i + k && j < s.length(); j++) tmp.append(s.charAt(j));
            builder.append(tmp.reverse().toString());
            i = j;

            tmp = new StringBuilder();
            for (j = i; j < i + k && j < s.length(); j++) tmp.append(s.charAt(j));
            builder.append(tmp.toString());

            i = j;
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseStr("abcdefg", 1));
    }
}