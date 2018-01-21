class Solution(object):
    def ctword(self, w):
        cts = [0 for i in xrange(26)]
        for c in w:
            if c >= 'a' and c <= 'z':
                cts[ord(c)-ord('a')] += 1
        return cts
    
    def shortestCompletingWord(self, licensePlate, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        lp = licensePlate.lower()
        cts = self.ctword(lp)
        bw = 100*'a'
        for w in words:
            if len(w) >= len(bw):
                continue
            ctsw = self.ctword(w.lower())
            good = True
            for i in xrange(26):
                if ctsw[i] < cts[i]:
                    good = False
                    break
            if good:
                bw = w
        return bw
                
                
            
            
        