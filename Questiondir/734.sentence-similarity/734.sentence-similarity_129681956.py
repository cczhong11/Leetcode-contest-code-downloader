import itertools
class Solution(object):
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        s1 = words1
        s2 = words2
        if len(s1) != len(s2):
            return False
        
        repo = {}
        for a, b in pairs:
            repo.setdefault(a, []).append(b)
        
        for w1, w2 in itertools.izip(s1, s2):
            if w1 == w2:
                continue
            elif w2 in repo.get(w1, []) or w1 in repo.get(w2, []):
                continue
            else:
                return False
            
        return True