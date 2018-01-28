class Solution(object):
    def isIdealPermutation(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        locali=0
        n=len(A)
        for i in range(1,n):
            if A[i-1]>A[i]:
                locali+=1
        
        def search(b,e):
            if b>=e:
                return 0
            mid=(b+e)//2
            count=search(b,mid)+search(mid+1,e)
            i=b
            j=mid+1
            temp=[]
            while i<=mid and j<=e:
                if A[j]<A[i]:
                    count+=mid+1-i
                    temp.append(A[j])
                    j+=1
                else:
                    temp.append(A[i])
                    i+=1
            if j>e:
                temp+=A[i:mid+1]
                
            A[b:b+len(temp)]=temp
            return count                    
        
        t=search(0,n-1)
        return bool(locali==t)