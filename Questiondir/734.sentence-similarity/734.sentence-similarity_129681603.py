class Solution(object):
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        dic = collections.defaultdict(set)
        for w1, w2 in pairs:
            dic[w1].add(w2)
            dic[w2].add(w1)
            
        if len(words1) != len(words2):
            return False
        
        for i in range(len(words1)):
            if (words1[i]!= words2[i] and words1[i] not in dic[words2[i]]):
                return False
        return True
        