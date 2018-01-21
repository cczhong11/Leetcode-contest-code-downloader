class Solution(object):
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        m={}
        for i in pairs:
            m["{}---{}".format(i[0],i[1])]=1
            m["{}---{}".format(i[1],i[0])]=1
        n1=len(words1)
        n2=len(words2)
        if n1!=n2:
            return False
        good=True
        for i in xrange(n1):
            if words1[i]==words2[i]:
                continue
            if m.get("{}---{}".format(words1[i],words2[i]),None) is None:
                good=False
                break
        return good