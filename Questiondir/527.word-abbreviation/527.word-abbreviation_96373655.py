class Solution(object):
    def do(self, pref, depth,  dict):
        if (len(dict) == 1):
            i = dict[0]
            mi = max(1, depth)
            ls = len(i)-2
            if (ls-mi+1 > 1):
                ab = i[0:mi] + str(ls-mi+1) + i[len(i)-1]
                self.map[i] = ab
            else:
                self.map[i] = i
            return
            
        mp = {}
        for i in dict:
            if (depth >= len(i)):
                self.map[i] = i
                continue
            c = i[depth]
            l = i[len(i)-1]
            th = len(i)
            if ((c,l,th) in mp):
                mp[(c,l,th)].append(i)
            else:
                mp[(c,l,th)] = [i]
        
        for (k,l,t) in mp:
            self.do(pref+k, depth+1, mp[(k,l,t)])
        return
    
    def wordsAbbreviation(self, dict):
        """
        :type dict: List[str]
        :rtype: List[str]
        """
        self.map = {}
        self.do("", 0, dict)
        return [self.map[d] for d in dict]