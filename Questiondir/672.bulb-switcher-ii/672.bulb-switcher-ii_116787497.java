class Solution {
    public int flipLights(int n, int m) {
        if (n==0) return 0;
        
        List<List<Integer>> statusList = new ArrayList<>();
        for (int a=0;a<2;a++) for (int b=0;b<2;b++) for (int c=0;c<2;c++) for (int d=0;d<2;d++) {
            int sum = a+b+c+d;
            if (sum > m || ((m-sum)%2)!=0 ) continue;

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(1);
            }
            if (a==1) {
                for (int i = 0; i < n; i++) {
                    list.set(i, 1 - list.get(i));
                }
            }
            if (b==1) {
                for (int i = 0; i < n; i+=2) {
                    list.set(i, 1 - list.get(i));
                }
            }
            if (c==1) {
                for (int i = 1; i < n; i+=2) {
                    list.set(i, 1 - list.get(i));
                }
            }
            if (d==1) {
                for (int i = 0; i < n; i+=3) {
                    list.set(i, 1 - list.get(i));
                }
            }
            
            boolean issame = false;
            for (List<Integer> sList : statusList) {
                int i;
                for (i = 0; i < n; i++) {
                    if (list.get(i) != sList.get(i)) {
                        break;
                    }
                }
                if (i == n) {
                    issame = true;
                    break;
                }
            }
            if (!issame) {
                statusList.add(list);
            }
        }
        return statusList.size();
    }

}