public class Solution {
  public boolean judgeCircle(String moves) {
    int dx = 0;
    int dy = 0;
    for (char ch : moves.toCharArray()) {
      switch (ch) {
        case 'L':
          dx--;
          break;
        case 'R':
          dx++;
          break;
        case 'U':
          dy--;
          break;
        case 'D':
          dy++;
          break;
      }
    }
    return dx == 0 && dy == 0;
  }
}
