class Solution(object):
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        b = True
        if len(word) == 0:
            return True
        c = word[0]
        if c >= 'a' and c <= 'z':
            b = False
        k = 0
        for i in word:
            if i >= 'A' and i <= 'Z':
                if b == False:
                    return False
            if i >= 'a' and i <= 'z':
                if k == 1:
                    b = False
                elif b == True:
                    return False
            k += 1
        return True
        