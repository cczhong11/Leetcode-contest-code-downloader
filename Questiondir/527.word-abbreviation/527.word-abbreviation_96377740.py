class Solution(object):
    def wordsAbbreviation(self, dict):
        """
        :type dict: List[str]
        :rtype: List[str]
        """
        mydic = {}
        res = {}
        for word in dict:
            abbr = self.findabbrv(word)
            mydic[abbr] = mydic.get(abbr, []) + [word]

        for a in mydic.keys():
            vals = mydic.pop(a)
            if len(vals) == 1:
                res[vals[0]] = a
            else:
                commonprefix = vals[0][0]
                subres = self.wordsAbbreviation([w[1:] for w in vals])
                for w,a in zip(vals,subres):
                    res[w] = commonprefix + a
        return [res[w] for w in dict]


    def findabbrv(self, word):
        n= len(word)
        if n >3:
            return (word[0]+str(n-2) + word[-1])
        else:
            return word