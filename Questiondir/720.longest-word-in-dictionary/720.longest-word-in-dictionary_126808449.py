class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        table=set(words)
        res=''
        for word in words:
            if all(word[:i] in table for i in range(1,len(word))):
                if len(word)>len(res) or (len(word)==len(res) and word<res):
                    res=word
        return res
    