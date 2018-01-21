class Solution(object):
    def addBoldTag(self, s, dic):
        """
        :type s: str
        :type dict: List[str]
        :rtype: str
        """
        l=len(s)
        b=[0 for i in range(l)]
        for w in dic:
            if b.count(0)==0:
                break
            lw=len(w)
            i=max(0,b.index(0)-lw+1)
            j=s.find(w,i)
            while j!=-1:
                for k in range(j,j+lw):
                    b[k]=1
                i=j+1
                j=s.find(w,i)
        ans=''
        i=0
        while i<l:
            if not b[i]:
                ans=ans+s[i]
                i+=1
            else:
                ans=ans+'<b>'
                while i<l and b[i]:
                    ans=ans+s[i]
                    i+=1
                ans=ans+'</b>'
        return ans