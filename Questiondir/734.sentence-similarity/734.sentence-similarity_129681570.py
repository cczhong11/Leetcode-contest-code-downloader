class Solution:
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        if len(words1) != len(words2): return False
        sim = collections.defaultdict(set)
        for a, b in pairs:
            sim[a].add(b)
            sim[b].add(a)
        for w, x in zip(words1, words2):
            if w != x and w not in sim[x]:
                return False
        return True