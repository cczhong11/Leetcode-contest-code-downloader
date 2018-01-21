class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        words = sorted(words)
        print(words)
        
        ans = ""
        
        i = 0
        previous = ""
        while i < len(words):
            word = words[i]
            #print(word,previous)
            l = len(word)
            if previous == word[0:l-1]:
                previous = word
            else:
                if len(previous) > len(ans):
                    ans = previous
                if len(previous) > 0 and not previous == word[0:len(previous)]:
                    previous = previous[:-1]
                    i -= 1
            i += 1
                
        
        if len(previous) > len(ans):
            ans = previous
        return ans
            
        