import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {


    List<String> dfs(List<String> list) {
        if (list.size() == 1) return list;

        List<String> newList = new ArrayList<>(list.size() / 2);
        for (int i = 0; i < list.size() / 2; i++) {
            newList.add("(" + list.get(i) + "," + list.get(list.size() - 1 - i) + ")");
        }

        return dfs(newList);
    }

    public String findContestMatch(int n) {

        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) list.add("" + i);
        list = dfs(list);
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findContestMatch(128));
    }
}