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
        m = {}
        for a, b in pairs:
            if a not in m:
                m[a] = set([a])
            m[a].add(b)
            if b not in m:
                m[b] = set([b])
            m[b].add(a)
        for a, b in zip(words1, words2):
            if a not in m:
                if a != b:
                    return False
            else:
                if b not in m[a]:
                    return False
        return True
        