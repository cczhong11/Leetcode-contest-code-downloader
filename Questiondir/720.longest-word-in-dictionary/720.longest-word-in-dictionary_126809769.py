class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        words.sort(cmp=lambda x, y: cmp(len(x), len(y)) or cmp(x, y))
        l, tmp, vis = 0, '', set()
        for x in words:
            ll, tag = len(x), True
            for i in xrange(ll-1):
                if x[:i+1] not in vis:
                    tag = False
                    break
            if tag == True:
                if l < ll:
                    l, tmp = ll, x
            vis.add(x)
        return tmp
        