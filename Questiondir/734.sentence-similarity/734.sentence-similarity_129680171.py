class Solution:
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        
        sim = set()
        
        for x, y in pairs:
            sim.add((x, y))
            sim.add((y, x))
            
        if len(words1) != len(words2):
            return False
        
        for i in range(len(words1)):
            x = words1[i]
            y = words2[i]
            
            if x != y and (x, y) not in sim:
                return False
        
        return True
        