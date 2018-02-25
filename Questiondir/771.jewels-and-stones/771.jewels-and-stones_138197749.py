class Solution(object):
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        hashset = set(list(J))
        res = 0
        for i in list(S):
            if i in hashset:
                res += 1
        return res
                
        