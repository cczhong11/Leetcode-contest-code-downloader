class Solution {
    public List<String> removeComments(String[] source) {
        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int state = 0;
        for (String line : source) {
            for (int idx=0; idx<line.length(); ) {
                int i = line.indexOf("//", idx);
                int j = line.indexOf("/*", idx);
                int k = line.indexOf("*/", idx);
                if (state == 1) {
                    if (k >= 0) {
                        state = 0;
                        idx = k+2;
                    } else {
                        break;
                    }
                } else if (i >= 0 && (j < 0 || j > i)) {
                    sb.append(line.substring(idx, i));
                    break;
                } else if (j >= 0) {
                    sb.append(line.substring(idx, j));
                    state = 1;
                    idx = j+2;
                } else {
                    sb.append(line.substring(idx));
                    break;
                }
            }
            if (state == 0 && sb.length() > 0) {
                results.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return results;
    }
}