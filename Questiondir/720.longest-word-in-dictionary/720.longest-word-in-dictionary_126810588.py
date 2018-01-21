class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        # words = sorted(words)
        if not words:
            return ''
        ret = ''
        prev = set()
        for w in words:
            prev.add(w)
        for w in words:
            for i in xrange(len(w)-1, 0, -1):
                if w[:i] not in prev:
                    break
            else:
                if len(w)>len(ret):
                    ret = w
                elif len(w) == len(ret):
                    ret = min(ret, w)
        return ret
        
        