class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        
        List<Integer> valid = new ArrayList<>();
        for (String s : ops) {
            if (s.equals("C")) {
                if (valid.size() >= 1) {
                    valid.remove(valid.size() - 1);
                }
            } else if (s.equals("D")) {
                if (valid.size() >= 1) {
                    int pre = valid.get(valid.size() - 1);
                    valid.add(pre * 2);
                }
            } else if (s.equals("+")) {
                if (valid.size() >= 2) {
                    int pre = valid.get(valid.size() - 1);
                    int prepre = valid.get(valid.size() - 2);
                    valid.add(prepre + pre);
                }
            } else {
                int num = Integer.valueOf(s);
                valid.add(num);
            }
        }
        
        for (int a : valid) {
            sum += a;
        }
        
        return sum;
    }
}