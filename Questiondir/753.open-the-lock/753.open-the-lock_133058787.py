class Solution(object):
    def openLock(self, deadends, target):
        """
        :type deadends: List[str]
        :type target: str
        :rtype: int
        """
        
        def l2s(lst):
            ans=''
            for i in range(4):
                ans+=str(lst[i]%10)
            return ans
        d={}
        for x in deadends:
            d[x]=0
        if '0000' in d:
            return -1
        if target=='0000':
            return 0
        b=[['0000',0]]
        d['0000']=1
        i=0
        while i<len(b):
            cur=[ord(c)-ord('0') for c in b[i][0]]
            for j in range(4):
                for k in [-1,1]:
                    cur[j]=(cur[j]+k)%10
                    s=l2s(cur)
                    if s not in d:
                        if s==target:
                            return b[i][1]+1
                        d[s]=1
                        b.append([s,b[i][1]+1])
                    cur[j]=(cur[j]-k)%10
            i+=1
        return -1
                    