class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        words.sort(key = lambda k:(len(k),k))
        trie,curLen,curWord = {},0,""
        for word in words:
            curTrie = trie
            for c in word[:len(word)-1]:
                if c in curTrie:
                    curTrie = curTrie[c]
                else:
                    curTrie = None
                    break
            if curTrie!=None:
                if word[-1] not in curTrie:
                    curTrie[word[-1]] = {}
                if len(word)>curLen:
                    curLen,curWord = len(word),word
        return curWord