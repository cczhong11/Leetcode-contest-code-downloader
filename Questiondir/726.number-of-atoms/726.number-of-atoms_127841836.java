class Solution {
      class Tokens{
        List<String> tokens;
        int next;

        public Tokens(List<String> tokens) {
            this.tokens=tokens;
        }
        boolean hasNext() {
            return next < tokens.size();
        }
        String getNext() {
//            log.info("getNext({}):{}", next, tokens.get(next));
            return tokens.get(next++);
        }
        String peekNext() {
//            log.info("peekNext({}):{}", next, tokens.get(next));
            return tokens.get(next);
        }
    }
    Tokens parseTokens(String input) {
        List<String> ans =new ArrayList<>();
        final int INIT = 0, IN_NAME=1, IN_DIGIT=2;
        int left=-1;
        int state=INIT;
        for (int i = 0; i < input.length();++i) {
            if (left==-1)left = i;
            char cur=input.charAt(i);
            if (cur=='(') {
                ans.add("(");
                left=-1;
                state=INIT;
            } else if (cur==')') {
                ans.add(")");
                left=-1;
                state=INIT;
            } else if (Character.isUpperCase(cur)) {
                left=i;
                state=IN_NAME;
            } else if (Character.isDigit(cur)) {
                if (left==-1) left=i;
                state=IN_DIGIT;
            }
            switch (state) {
                case IN_NAME:
                    if (i+1==input.length()||!Character.isLowerCase(input.charAt(i+1))) {
                        ans.add(input.substring(left, i+1));
                        left=-1;
                        state=INIT;
                    }
                    break;
                case IN_DIGIT:
                    if (i+1==input.length()||!Character.isDigit(input.charAt(i+1))) {
                        ans.add(input.substring(left, i+1));
                        left=-1;
                        state=INIT;
                    }
                    break;
            }
        }
        return new Tokens(ans);
    }

    Map<String, Integer> parse(Tokens tokens) {
//        log.info("start parse");
        Map<String, Integer> ans=new TreeMap<>();
        while (tokens.hasNext()) {
            String next = tokens.peekNext();
            if (next.equals("(")) {
                tokens.getNext();
                Map<String, Integer> child=parse(tokens);
                // remove ")"
                tokens.getNext();
                int factor=1;
                if (tokens.hasNext()) {
                    next=tokens.peekNext();
                    if (Character.isDigit(next.charAt(0))) {
                        tokens.getNext();
                        factor=Integer.parseInt(next);
                    }
                }
                int finalFactor=factor;
                for (Map.Entry<String, Integer> kv: child.entrySet()) {
                    ans.merge(kv.getKey(), kv.getValue()*finalFactor, (x,y)->(x+y));
                }
            } else if (next.equals(")")) {
                break;
            } else {
                    String key=next;
                    tokens.getNext();
                    int factor=1;
                    if (tokens.hasNext()) {
                        next=tokens.peekNext();
                        if (Character.isDigit(next.charAt(0))) {
                            tokens.getNext();
                            factor=Integer.parseInt(next);
                        }
                    }
                    int finalFactory=factor;
                    ans.merge(key, finalFactory, (x,y)->(x+y));
                }
        }
//        log.info("ans: {}", ans);
        return ans;
    }
    public String countOfAtoms(String formula) {

        Tokens tokens = parseTokens(formula);
        Map<String, Integer> ans= parse(tokens);
        StringBuilder sb=new StringBuilder();
        for (Map.Entry<String, Integer> kv: ans.entrySet()) {
            sb.append(kv.getKey());
            if (kv.getValue()>1) {
                sb.append(kv.getValue());
            }
        }
        return sb.toString();
    }
}