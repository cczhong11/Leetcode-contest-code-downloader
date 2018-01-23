from collections import defaultdict
import operator
class Solution(object):
    def wordsAbbreviation(self, lst):
        """
        :type dict: List[str]
        :rtype: List[str]
        """
        def abbr(w, pref):
            pref = min(pref, len(w)-1)
            res = w[:pref] + str(len(w)-1-pref) + w[-1]
            if len(res) < len(w): return res
            else: return w
        lst = [(abbr(w,1),i,1,w) for i,w in enumerate(lst)]
        dic = defaultdict(list)
        for item in lst:
            dic[item[0]].append(item)
        final = []
        while len(dic) > 0:
            next_dic = defaultdict(list)
            for k,v in dic.items():
                if len(v) == 1:
                    final.extend(v)
                    continue
                for _,i,pref,w in v:
                    key = abbr(w, pref+1)
                    next_dic[key].append((key,i,pref+1,w))
            dic = next_dic
        final = sorted(final, key=operator.itemgetter(1))
        return [v[0] for v in final]

