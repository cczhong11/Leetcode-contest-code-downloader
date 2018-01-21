class Solution {
    public int flipLights(int n, int m) {
        if(n == 0 || m == 0) {
            return 1;
        }
        BitSet bitSet = new BitSet(n);
        bitSet.set(0, n);
        Set<BitSet> current = new HashSet<>(Arrays.asList(bitSet));
        for(int i = 0; i < m; ++ i) {
            Set<BitSet> next = new HashSet<>();
            for (BitSet set : current) {
                next.add(flipAll(set, n));
                next.add(flipEven(set, n));
                next.add(flipOdd(set, n));
                next.add(flip3kplus1(set, n));
            }
            if(current.equals(next)) {
                break;
            }
            current = next;
        }
        return current.size();
    }

    BitSet flipAll(BitSet bitSet, int n) {
        BitSet set = new BitSet(n);
        set.or(bitSet);
        set.flip(0, n);
        return set;
    }

    BitSet flipEven(BitSet bitSet, int n) {
        BitSet set = new BitSet(n);
        set.or(bitSet);
        for(int i = 1; i < n; i += 2) {
            set.flip(i);
        }
        return set;
    }

    BitSet flipOdd(BitSet bitSet, int n) {
        BitSet set = new BitSet(n);
        set.or(bitSet);
        for(int i = 0; i < n; i += 2) {
            set.flip(i);
        }
        return set;
    }

    BitSet flip3kplus1(BitSet bitSet, int n) {
        BitSet set = new BitSet(n);
        set.or(bitSet);
        for(int i = 0; i < n; i += 3) {
            set.flip(i);
        }
        return set;
    }
}