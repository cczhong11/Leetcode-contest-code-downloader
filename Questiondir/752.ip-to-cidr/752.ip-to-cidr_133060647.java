class Solution {
    public List<String> ipToCIDR(String ip, int range) {
        String[] temp = ip.split("[.]");
        long start = (1L << 32) + (Long.parseLong(temp[0]) << 24) + (Long.parseLong(temp[1]) << 16) + (Long.parseLong(temp[2]) << 8) + (Long.parseLong(temp[3]));
        List<String> stuff = new ArrayList<String>();
        for (long i = start; i < start + range; i++) {
            stuff.add(Long.toString(i, 2));
        }
        for (int len = 33; len >= 0; len--) {
            for (int i = 0; i < stuff.size() - 1; i++) {
                if (stuff.get(i).length() == len && stuff.get(i + 1).length() == len && stuff.get(i).substring(0, len - 1).equals(stuff.get(i + 1).substring(0, len - 1))) {
                    stuff.set(i, stuff.get(i).substring(0, len - 1));
                    stuff.remove(i + 1);
                }
            }
        }
        for (int i = 0; i < stuff.size(); i++) {
            String str = stuff.get(i).substring(1);
            int n = str.length();
            while (str.length() < 32) {
                str += "0";
            }
            long ipLong = Long.parseLong(str, 2);
            long d = ipLong & 255;
            long c = (ipLong >> 8) & 255;
            long b = (ipLong >> 16) & 255;
            long a = (ipLong >> 24) & 255;
            stuff.set(i, a + "." + b + "." + c + "." + d + "/" + n);
        }
        return stuff;
    }
}