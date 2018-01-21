class Solution {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) return 0;
        
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C") ) {
                list.remove(list.size() - 1);
            } else if (ops[i].equals("D")) {
                list.add(list.get(list.size() - 1) * 2);
            } else if (ops[i].equals("+")) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else {
                list.add(Integer.parseInt(ops[i]));
            }
        }
        
        for (Integer num : list) {
            sum += num;
        }
        return sum;
    }
}