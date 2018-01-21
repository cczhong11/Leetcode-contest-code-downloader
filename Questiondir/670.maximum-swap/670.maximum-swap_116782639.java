class Solution {
    public int maximumSwap(int num) {
        StringBuilder builder = new StringBuilder();
        builder.append(num);
        for(int i = 0; i < builder.length(); ++ i) {
            for(int j = i+1; j < builder.length(); ++ j) {
                char tmp = builder.charAt(i);
                builder.setCharAt(i, builder.charAt(j));
                builder.setCharAt(j, tmp);

                num = Math.max(num, Integer.valueOf(builder.toString()));
                
                tmp = builder.charAt(i);
                builder.setCharAt(i, builder.charAt(j));
                builder.setCharAt(j, tmp);
            }
        }
        return num;
    }
}