from collections import Counter
class Solution(object):
    def shortestCompletingWord(self, licensePlate, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        dic = Counter([x for x in licensePlate.lower() if 'a'<=x<='z'])
        ans = None
        for w in words:
            dd = Counter(w.lower())
            if all(dd[k] >= dic[k] for k in dic.keys()):
                if ans is None or len(ans) > len(w):
                    ans = w
        return ans

