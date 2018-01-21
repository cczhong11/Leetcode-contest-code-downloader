class Solution(object):
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        if len(word) <= 1: return True
        if word[0] in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
            if word[1] in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
                for ch in word[2:]:
                    if ch not in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
                        return False
            else:
                for ch in word[2:]:
                    if ch in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
                        return False
            return True
        for ch in word[1: ]:
            if ch in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
                return False
        return True