class Solution(object):
    def wordsAbbreviation(self, dict):
        """
        :type dict: List[str]
        :rtype: List[str]
        """
        ret = [''] * len(dict)
        def getA(w, k):
            if len(w) <= 3 or len(w)-1-k<=1:
                return w
            return w[:k] + str(len(w)-1-k) + w[-1]
        def f(enums, k):
            d = collections.defaultdict(list)
            for i,w in enums:
                a = getA(w, k)
                d[a].append((i,w))
            for key,v in d.iteritems():
                #print(key, v)
                if len(v) == 1:
                    ret[v[0][0]] = key
                else:
                    f(v, k+1)
        f(enumerate(dict), 1)
        return ret