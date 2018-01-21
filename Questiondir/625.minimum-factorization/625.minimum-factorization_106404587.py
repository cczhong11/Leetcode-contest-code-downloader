class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        if a == 1:
            return 1
        temp = []
        label = True
        label2 = True
        while label:
            label2 = False
            for i in xrange(9,1,-1):
                if a % i == 0:
                    a = a // i
                    temp.append(i)
                    label2 = True
                    if a == 1:
                        label = False
                    break
            if label2 == False:
                return 0
        temp.sort()
        s = ""
        for item in temp:
            s += str(item)
        s = int(s)
        if s >= 2 ** 31:
            return 0
        else:
            return s