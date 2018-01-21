class Solution(object):
    def newInteger(self, n):
        """
        :type n: int
        :rtype: int
        """
        nRemove = [1]
        nTotal = [10]
        nRemain = [9]
        while (nTotal[-1] < n):
            nRemove.append(nRemove[-1]*9 + nTotal[-1])
            nTotal.append(nTotal[-1] * 10)
            nRemain.append(nTotal[-1] - nRemove[-1])
        
        counter = 0
        ret = 0
        i = len(nRemove) - 1
        while i >= 0:
            if n - counter >= nRemain[i]:
                counter += nRemain[i]
                ret += nTotal[i]
            else:
                i -= 1
        #print ret, counter
        return ret - counter + n