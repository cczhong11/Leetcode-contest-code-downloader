class Solution:
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        n = len(words1)
        if n != len(words2):
            return False
        s = set([tuple(p) for p in pairs])
        for i in range(n):
            w1 = words1[i]
            w2 = words2[i]
            if w1 != w2 and (w1, w2) not in s and (w2, w1) not in s:
                return False
        return True