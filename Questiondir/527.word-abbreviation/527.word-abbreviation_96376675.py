from collections import Counter

def prefix(s, l):
    p = s[:l] + str(len(s)-l-1) + s[-1]
    return p if len(p) < len(s) else s

class Solution(object):
    def wordsAbbreviation(self, d8y):
        """
        :type d8y: List[str]
        :rtype: List[str]
        """
        pf = 0
        ret = [None]*len(d8y)
        done = 0
        while done < len(d8y):
            pf += 1
            p = [ prefix(d,pf) if ret[i] is None else None for (i,d) in enumerate(d8y) ]
            cnt = Counter(p)
            for i in xrange(len(d8y)):
                if ret[i] is None and cnt[p[i]] == 1:
                    ret[i] = p[i]
                    done += 1
        return ret