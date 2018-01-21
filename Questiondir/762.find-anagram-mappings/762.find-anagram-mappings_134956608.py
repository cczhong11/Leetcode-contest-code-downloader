class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        a={}
        b={}
        for i in xrange(len(A)):
            a[A[i]]=a.get(A[i],[])+[i]
            b[B[i]]=b.get(B[i],[])+[i]
        c=[None]*len(A)
        for i in a:
            for x,y in zip(a[i],b[i]):
                c[x]=y
        return c