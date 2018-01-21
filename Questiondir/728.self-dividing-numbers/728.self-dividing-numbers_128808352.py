class Solution:
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        a=[]
        for i in range(left,right+1):
            d={int(c) for c in str(i)}
            if 0 not in d and all(i%j==0 for j in d):
                a.append(i)
        return a