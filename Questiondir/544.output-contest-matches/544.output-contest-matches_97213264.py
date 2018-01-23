class Solution(object):
    def findContestMatch(self, n):
        """
        :type n: int
        :rtype: str
        """
        l = range(1, n+1)
        while len(l) > 2:
            l = [[l[i],l[-i-1]] for i in range(len(l)//2)]
        ret = []
        def f(l):
            if type(l)==int:
                ret.append(str(l))
                return
            ret.append('(')
            f(l[0])
            ret.append(',')
            f(l[1])
            ret.append(')')
        f(l)
        return ''.join(ret)