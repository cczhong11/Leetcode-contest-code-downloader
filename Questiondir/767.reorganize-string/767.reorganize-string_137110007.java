class Solution {
    public String reorganizeString(String S) {

        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : S.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }


        StringBuilder sb = new StringBuilder();

        char last = '-';
        while (!cntMap.isEmpty()) {

            int maxCnt = -1;
            char nowCh = '-';
            for (char ch : cntMap.keySet()) {
                int num = cntMap.get(ch);
                if (num > maxCnt && ch != last) {
                    maxCnt = num;
                    nowCh = ch;
                }
            }

            if (maxCnt == -1) return "";

            if (maxCnt == 1) {
                cntMap.remove(nowCh);
            } else {
                cntMap.put(nowCh, maxCnt - 1);
            }
            sb.append(nowCh);
            last = nowCh;
        }


        return sb.toString();
    }
}