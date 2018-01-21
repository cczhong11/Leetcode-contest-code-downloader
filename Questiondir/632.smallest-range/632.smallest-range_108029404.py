class Solution(object):
    def smallestRange(self, nums):
        """
        :type nums: List[List[int]]
        :rtype: List[int]
        """
        n=len(nums)
        d={}
        for i in range(n):
            l=len(nums[i])
            for j in range(l):
                if nums[i][j] in d:
                    d[nums[i][j]].append(i)
                else:
                    d.setdefault(nums[i][j],[i])
        l=sorted(d.keys())
        c=[0 for i in range(n)]
        i=0
        j=0
        m=len(l)
        
        short=200000
        srange=[0,0]
        
        def filled(c):
            for i in range(len(c)):
                if c[i]<1:
                    return False
            return True
            
        while j<m:
            for k in d[l[j]]:
                c[k]+=1
            
            if filled(c):
                ni=i
                while filled(c):
                    for k in d[l[ni]]:
                        c[k]-=1
                    ni+=1
                ni-=1
                for k in d[l[ni]]:
                    c[k]+=1
                i=ni
                if l[j]-l[i]<short:
                    short=l[j]-l[i]
                    srange[0]=l[i]
                    srange[1]=l[j]
                while filled(c):
                    for k in d[l[i]]:
                        c[k]-=1
                    i+=1
            j+=1
        return srange
        