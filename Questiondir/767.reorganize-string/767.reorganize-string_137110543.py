import collections
class Solution(object):
    def reorganizeString(self, S):
        """
        :type S: str
        :rtype: str
        """
        cnt = collections.Counter(S)
        maxCnt = max(cnt.values())
        
        if len(S) % 2 == 0:
            if maxCnt > len(S) / 2:
                return ''
        else:
            if maxCnt > len(S) / 2 + 1:
                return ''
        
        toProcess = sorted([(freq, c) for c, freq in cnt.iteritems()], reverse=True)
        
        rv = [''] * len(S)
        i = 0
        for freq, c in toProcess:
            for _ in xrange(freq):
                rv[i] = c
                i += 2
                if i >= len(S):
                    i = 1
                    
        return ''.join(rv)