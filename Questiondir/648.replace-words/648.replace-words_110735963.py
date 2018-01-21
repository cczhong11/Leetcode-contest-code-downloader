class Solution(object):
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        if not dict or not sentence:
            return sentence
        s = sentence.split(' ')
        root = {}
        for word in dict:
            node = root
            for w in word:
                if w not in node:
                    node[w] = {}
                node = node[w]
            node['_end'] = word
        
        for i, c in enumerate(s):
            node = root
            for letter in c:
                if '_end' in node:
                    s[i] = node['_end']
                    break
                elif letter not in node:
                    break
                else:
                    node = node[letter]
        return ' '.join(s)