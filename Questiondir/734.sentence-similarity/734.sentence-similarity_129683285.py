class Solution:
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        d = {}
        if len(words1) != len(words2):
            return False
        for p in pairs:
            v = d.get(p[0], set())
            v.add(p[1])
            d[p[0]] = v
            v = d.get(p[1], set())
            v.add(p[0])
            d[p[1]] = v
        for idx, s in enumerate(words1):
            v = d.get(s, set())
            if s != words2[idx] and words2[idx] not in v:
                return False
        return True