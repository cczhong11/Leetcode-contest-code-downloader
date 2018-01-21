class Solution(object):
    def replaceWords(self, dict, sentence):
        dict = set(dict)
        res = []
        def add(word):
            for i in range(1, len(word)):
                if word[:i] in dict:
                    res.append(word[:i])
                    return
            res.append(word)
            
        words = sentence.split(" ")
        for word in words:
            add(word);
        return " ".join(res)