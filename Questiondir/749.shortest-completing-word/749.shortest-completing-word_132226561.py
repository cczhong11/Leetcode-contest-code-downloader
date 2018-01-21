class Solution(object):
    def shortestCompletingWord(self, licensePlate, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        licensePlate = licensePlate.lower()
        from collections import Counter, defaultdict
        
        lp = defaultdict(int)
        for c in licensePlate:
            if c.islower():
                lp[c] += 1
        
        result = -1
        for i, word in enumerate(words):
            if result >= 0 and len(words[result]) <= len(word):
                continue
            cnt = Counter(word)
            fits = True
            for c, v in lp.iteritems():
                if cnt[c] < v:
                    fits = False
                    break
            if fits:
                result = i
        return words[result]