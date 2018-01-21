class Solution:
    def stringStartsWith(self, string, char_list):
        for c1, c2 in zip(string, char_list):
            if c1 != c2:
                return False
            
        return True
    
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        
        words.sort()
        
        cur_word = []
        
        max_word = ""
        
        for w in words:
            while len(cur_word) >= len(w):
                cur_word.pop()
                
            if len(cur_word) != len(w) - 1:
                continue
                
            if not self.stringStartsWith(w, cur_word):
                continue
                
            cur_word.append(w[-1])
            
            if len(cur_word) > len(max_word):
                max_word = "".join(cur_word)
                
        return max_word
        