class Solution(object):
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        if not word:
            return True
        a, b = False, False
        for c in word:
            if 'A' <= c <= 'Z':
                a = True
            else:
                b = True
        if not a:
            return True
        if not b:
            return True
        for c in word[1:]:
            if 'A' <= c <= 'Z':
                return False
        return True