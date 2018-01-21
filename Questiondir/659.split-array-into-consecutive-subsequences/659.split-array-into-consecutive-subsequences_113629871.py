class Solution(object):
    def isPossible(self, A):
        """
        :type nums: List[int]
        :rtype: bool
        """
        def check(counts):
            #print counts
            prev = 0
            starts = []
            ends = []
            for i, c in enumerate(counts):
                if c > prev:
                    for _ in xrange(c-prev):
                        starts.append(i)
                elif c < prev:
                    for _ in xrange(prev-c):
                        ends.append(i-1)
                prev = c
            
            for _ in xrange(prev):
                ends.append(i)
            
            
            ans = len(starts) == len(ends) and all(e>=s+2 for s,e in zip(starts, ends))
            #print counts, starts, ends, ans
            return ans
        
        count = collections.Counter(A)
        cur = []
        prev = None
        for x in sorted(count):
            x_ct = count[x]
            if (prev is None) or (x-prev) == 1:
                cur.append(x_ct)
            else:
                if not check(cur):
                    return False
                cur = []
            prev = x
        
        if cur and not check(cur):
            return False
        
        return True