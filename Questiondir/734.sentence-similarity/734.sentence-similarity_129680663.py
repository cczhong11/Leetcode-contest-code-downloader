class Solution(object):
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        d = {}
        for w1, w2 in pairs:
            if w1 not in d:
                d[w1] = set()
            d[w1].add(w2)
        if len(words1) != len(words2):
            return False
        for i in range(len(words1)):
            w1 = words1[i]
            w2 = words2[i]
            if not (w1 == w2 or (w1 in d and w2 in d[w1]) or (w2 in d and w1 in d[w2])):
                return False
        return True