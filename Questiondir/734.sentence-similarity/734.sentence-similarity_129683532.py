class Solution:
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        if len(words1) != len(words2):
            return False
        dic = {}
        for i, j in pairs:
            if i not in dic:
                dic[i] = [j]
            else:
                dic[i].append(j)
            if j not in dic:
                dic[j] = [i]
            else:
                dic[j].append(i)
                
        for i in range(len(words1)):
            if words1[i] == words2[i]:
                continue
            if words1[i] in dic and words2[i] in dic[words1[i]]:
                continue
            return False
        return True