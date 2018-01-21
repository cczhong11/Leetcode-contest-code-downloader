class Solution(object):
    def shortestCompletingWord(self, licensePlate, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        licensePlate = licensePlate.lower()
        req = {}
        for c in licensePlate:
            if not c.isalpha():
                continue
            if c in req:
                req[c] += 1
            else:
                req[c] = 1
        ans = '12345678901234567890'
        for word in words:
            if len(word) >= len(ans):
                continue
            word = word.lower()
            count = {}
            for c in word:
                if c in count:
                    count[c] += 1
                else:
                    count[c] = 1
            complete = True
            for k,v in req.items():
                if k not in count or count[k] < v:
                    complete = False
                    break
            if complete:
                ans = word
        return ans
