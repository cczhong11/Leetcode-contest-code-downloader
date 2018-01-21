class Solution(object):
    def reorganizeString(self, S):
        """
        :type S: str
        :rtype: str
        """
        n=len(S)
        if n<=1:
            return S
        r=[' ']*n
        count={i:S.count(i) for i in set(S)}
        if any([count[i]>(n+1)//2 for i in count]):
            return ''
        count=[[i,count[i]] for i in count]
        count.sort(key=lambda x:-x[1])
        i=0
        now=0
        while i<n:
            r[i]=count[now][0]
            count[now][1]-=1
            if count[now][1]==0:
                now+=1
            i+=2
            if i>=n and i%2==0:
                i=1
        return ''.join(r)