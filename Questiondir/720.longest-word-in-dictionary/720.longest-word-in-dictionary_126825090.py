class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        ws = set(words)
        chosen = None
        for w in ws:
            can = True
            for i in xrange(len(w)-1):
                if w[:i+1] not in ws:
                    can = False
                    break
            if can:
                if chosen is None:
                    chosen = w
                else:
                    if len(w) > len(chosen):
                        chosen = w
                    elif len(w) == len(chosen):
                        chosen = min(w, chosen)
        return chosen
                    
        