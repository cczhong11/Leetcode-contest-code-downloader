class Solution(object):
    def wordsAbbreviation(self, dict):
        """
        :type dict: List[str]
        :rtype: List[str]
        """
        ht = {}
        res = list(dict)
        for i in range(len(dict)):
            word = dict[i]
            if len(word) > 3:
                #print word
                for j in range(1, len(word) - 2):
                    abbr = word[:j] + str(len(word) - j - 1) + word[-1]
                    #print '   ', abbr
                    if abbr in ht:
                        if ht[abbr] != None:
                            idx, pos = ht[abbr]
                            pos += 1
                            ht[abbr] = None
                            if pos < len(dict[idx]) - 2:
                                newAbbr = dict[idx][:pos] + str(len(dict[idx]) - pos - 1) + dict[idx][-1]
                                ht[newAbbr] = (idx, pos)
                                res[idx] = newAbbr
                            else:
                                res[idx] = dict[idx]
                    else:
                        ht[abbr] = (i, j)
                        res[i] = abbr
                        break
        return res