class Solution(object):
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        L = len(word)
        if L <= 1:
            return True
        def Cap(s):
            if ord(s) - ord('A') >= 0 and ord(s) - ord('A') < 26:
                return True
            return False
        def Ncap(s):
            if ord(s) - ord('a') >= 0 and ord(s) - ord('a') < 26:
                return True
            return False
        if Ncap(word[0]):
            for i in range(1, L):
                if Cap(word[i]):
                    return False
            return True
        if Ncap(word[1]):
            for i in range(2, L):
                if Cap(word[i]):
                    return False
            return True
        
        for i in range(2, L):
            if Ncap(word[i]):
                return False
        return True
            