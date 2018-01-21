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
        
        mydict = collections.defaultdict(lambda: set())
        for a,b in pairs:
            mydict[a].add(b)
            mydict[b].add(a)
            
        for a,b in zip(words1, words2):
            if a==b or b in mydict[a] or a in mydict[b]:
                pass
            else:
                return False
        return True