public class Solution {
    public boolean judgeCircle(String moves) {
		int vertical = 0;
		int horizontal = 0;
		for (int i = 0; i < moves.length(); i++) {
			char move = moves.charAt(i);
			switch (move) {
			case 'U':
				vertical++;
				break;
			case 'D':
				vertical--;
				break;
			case 'R':
				horizontal++;
				break;
			case 'L':
				horizontal--;
				break;
			default:
				return false;
			}
		}
		return vertical == 0 && horizontal == 0;
    }
}