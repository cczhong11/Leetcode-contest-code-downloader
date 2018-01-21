class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        if not words:
            return ''
        
        word_set = set(words)
        sorted_words = sorted(words, key=lambda w: (-len(w), w))
        
        for word in sorted_words:
            flag = True
            for i in range(len(word)):
                if word[:i+1] not in word_set:
                    flag = False
                    break
            if flag:
                return word
        return ''
        