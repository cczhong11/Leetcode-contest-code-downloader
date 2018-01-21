from collections import defaultdict
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
        similar = defaultdict(set)
        for a,b in pairs:
            similar[a].add(b)
            similar[b].add(a)
        for a,b in zip(words1,words2):
            if a == b: continue
            if a not in similar[b] and b not in similar[a]:
                return False
        return True
        