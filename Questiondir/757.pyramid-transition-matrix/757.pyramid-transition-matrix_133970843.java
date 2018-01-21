class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        for(String s : allowed) {
            int key = getKey(s.charAt(0), s.charAt(1));
            if(!map.containsKey(key)) {
                map.put(key, new HashSet<>());
            }
            map.get(key).add(s.charAt(2));
        }
        return pyramidTransition(bottom, 0, new StringBuilder(), map);
    }

    int getKey(char a, char b) {
        int key = (a - 'A') * 26 + (b - 'A');
        return key;
    }

    public boolean pyramidTransition(String bottom, int index, StringBuilder builder, Map<Integer, Set<Character>> map) {
        if(bottom.length() == 1) {
            return true;
        }
        if(index >= bottom.length() - 1) {
            return pyramidTransition(builder.toString(), 0, new StringBuilder(), map);
        }
        int key = getKey(bottom.charAt(index), bottom.charAt(index+1));
        if(!map.containsKey(key)) {
            return false;
        }
        for (char c : map.get(key)) {
            builder.append(c);
            if(pyramidTransition(bottom, index + 1, builder, map)) {
                return true;
            }
            builder.setLength(builder.length() - 1);
        }
        return false;
    }
}