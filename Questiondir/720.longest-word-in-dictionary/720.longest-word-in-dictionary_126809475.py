class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        words.sort(key=lambda x: len(x))
        tree = {'#': {}}
        ans = ''
        for word in words:
            p = tree
            ok = True
            for c in word:
                if c not in p:
                    p[c] = {}
                ok = ok and '#' in p
                p = p[c]
            p['#'] = {}
            if ok:
                if len(word) > len(ans):
                    ans = word
                elif len(word) == len(ans):
                    ans = min(ans, word)
        return ans
        