class Solution(object):
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        if len(words1) != len(words2):
            return False
        p = set((w1, w2) for w1, w2 in pairs)
        for w1, w2 in zip(words1, words2):
            if w1 != w2 and (w1, w2) not in p and (w2, w1) not in p:
                return False
        return True