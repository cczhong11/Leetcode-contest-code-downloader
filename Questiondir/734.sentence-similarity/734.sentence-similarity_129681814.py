class Solution(object):

    def areSentencesSimilar(self, words1, words2, pairs):
        from collections import defaultdict
        
        if len(words1) != len(words2):
            return False
    
        D = defaultdict(set)
        
        for w in words1:
            D[w].add(w)
            
        for w in words2:
            D[w].add(w)
            
        for a, b in pairs:
            D[a].add(b)
            D[b].add(a)
            
        return all(b in D[a] for a, b in zip(words1, words2))  