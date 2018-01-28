class Solution(object):
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        js = set(list(J))
#        print js
        result = 0
        for s in S:
            if s in js:
                result += 1
        return result
        