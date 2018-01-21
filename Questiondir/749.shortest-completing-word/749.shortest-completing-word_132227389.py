class Solution(object):
    def shortestCompletingWord(self, licensePlate, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        def getLetters(plate):
            letters = {}
            for l in plate:
                if ord('a') <= ord(l.lower()) <= ord('z'):
                    letters.setdefault(l.lower(), 0)
                    letters[l.lower()] += 1
            return letters
        
        def hasLetters(w, letters):
            lets = {x:y for x, y in letters.iteritems()}
            for l in w:
                if l in lets and lets[l] > 0:
                    lets[l] -= 1
            return sum(lets.values()) == 0
        
        words.sort(cmp=lambda a, b: len(a) - len(b))
        letters = getLetters(licensePlate)
        for w in words:
            if hasLetters(w, letters):
                return w
        