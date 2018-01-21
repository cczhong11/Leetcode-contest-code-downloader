class Solution(object):
    def shortestCompletingWord(self, licensePlate, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        need=[[i,licensePlate.lower().count(i)] for i in sorted(set([i for i in licensePlate.lower() if i.isalpha()]))]
        select=None
        selectl=None
        for i in xrange(len(words)):
            if all([words[i].count(j[0])>=j[1] for j in need]):
                if select is None:
                    select=i
                    selectl=len(words[i])
                elif selectl>len(words[i]):
                    select=i
                    selectl=len(words[i])
        return words[select]