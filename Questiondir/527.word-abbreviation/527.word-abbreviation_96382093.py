class Solution(object):
    def wordsAbbreviation(self, dict):
        """
        :type dict: List[str]
        :rtype: List[str]
        """
        abbr2word = collections.defaultdict(set)
        word2abbr = {}
        for word in dict:
            abbr = self.getAbbreviation(word)
            abbr2word[abbr].add(word)
        for abbr, words in abbr2word.items():
            if len(words) > 1:
                for word in words:
                    for i in range(2, len(word)):
                        prefix = word[:i]
                        if self.checkUnique(prefix, words):
                            nabbr = self.getAbbr(word, prefix)
                            word2abbr[word] = nabbr
                            break
            else:
                word2abbr[words.pop()] = abbr
        return [word2abbr[word] for word in dict]
        
    def checkUnique(self, prefix, words):
        count = 0
        for word in words:
            if word.startswith(prefix):
                count += 1
                if count >= 2:
                    return False
        return count == 1
                
                    
    def getAbbr(self, word, prefix):
        abbr = prefix + str(len(word) - 1 - len(prefix)) + word[-1]
        return abbr if len(abbr) < len(word) else word
        
    def getAbbreviation(self, word):
        abbr = word[0] + str(len(word) - 2) + word[-1]
        return abbr if len(abbr) < len(word) else word
        
    def getPrefix(self, word1, word2):
        prefix = []
        for c1, c2 in zip(word1, word2):
            if c1 != c2:
                return prefix
            else:
                prefix.append(c1) 
        return "".join(prefix)