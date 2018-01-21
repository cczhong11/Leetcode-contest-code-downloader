class Solution(object):
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """
        rv = len(B)/len(A)
        aa = A * rv
        if aa.find(B) != -1:
            return rv
        else:
            rv += 1
            aa = A * rv
            if aa.find(B) != -1:
                return rv
            else:
                rv += 1
                aa = A * rv
                if aa.find(B) != -1:
                    return rv
                else:
                    return -1
        