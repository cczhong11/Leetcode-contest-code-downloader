class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        d, l = {''}, 0
        for w in sorted(words):
            if w[:-1] in d:
                d.add(w)
                if l < len(w):
                    l = len(w)
                    ans = w
        return ans