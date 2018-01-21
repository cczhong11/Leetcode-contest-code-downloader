class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        dict = set(words)
        def indict(word):
            if word not in dict:
                return False
            if len(word)==1:
                return True
            return any(indict(word[:i]+word[i+1:])  for i in xrange(len(word)))
        words=sorted(words)
        words=sorted(words,key=lambda x:len(x),reverse=True)
        for word in words:
            if indict(word):
                return word
        return ""