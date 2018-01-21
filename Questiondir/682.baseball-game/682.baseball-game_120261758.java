class Solution {
    public int calPoints(String[] ops) {
                ArrayList<Integer> st = new ArrayList<>();
        int sum=0;
        for (String op: ops){
            int n =0;
            if (Character.isDigit(op.charAt(0))||'-'==op.charAt(0)){
                n= Integer.parseInt(op);
                sum+=n;
                st.add(n);
            } else {
                switch (op){
                    case "+":
                        n = st.get(st.size()-2)+st.get(st.size()-1);
                        sum+=n;
                        st.add(n);
                        break;
                    case "D":
                        n = 2 *st.get(st.size()-1);
                        sum+=n;
                        st.add(n);
                        break;
                    case "C":
                        n=st.get(st.size()-1);
                        sum-=n;
                        st.remove(st.size()-1);
                        break;
                    default:
                        break;
                }
            }
//            log.info("st:{}, sum:{}", st, sum);

        }
        return sum;
    }
}