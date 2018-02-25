class Solution(object):
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        d={c for c in J}
        ans=0
        for c in S:
            if c in d:
                ans+=1
        return ans