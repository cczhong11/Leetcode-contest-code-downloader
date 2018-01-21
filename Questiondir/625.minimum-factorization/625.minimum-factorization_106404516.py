class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        if a<10:
            return a
        for i in range(9,1,-1):
            if a%i==0:
                if a==i:
                    return i
                t1=self.smallestFactorization(a//i)
                if not t1:
                    return 0
                t=t1*10+i
                return 0 if t>2147483647 else t
        return 0
                    