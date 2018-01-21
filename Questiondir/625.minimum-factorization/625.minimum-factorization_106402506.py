class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        if a == 0: return 0
        
        lst = []
        
        while a >= 10:
            flag = False
            for i in range(9, 1, -1):
                if a % i == 0:
                    flag = True
                    lst.append(str(i))
                    a /= i
                    break
            if not flag:
                return 0
        lst.append(str(a))
        
        res = int(''.join(reversed(lst)))
        if res > 2 ** 31 - 1:
            return 0
        else:
            return res