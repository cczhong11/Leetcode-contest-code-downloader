import collections
class Solution(object):
    def shortestCompletingWord(self, licensePlate, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        repo = {}
        for c in licensePlate:
            if c.isalpha():
                repo[c.lower()] = repo.get(c.lower(), 0) + 1
                
        rv = ''
        lenRv = 10000
        for word in words:
            cnt = collections.Counter(word)
            for k,v in repo.iteritems():
                if cnt.get(k, 0) < v:
                    break
            else:
                if len(word) < lenRv:
                    rv = word
                    lenRv = len(word)
        return rv