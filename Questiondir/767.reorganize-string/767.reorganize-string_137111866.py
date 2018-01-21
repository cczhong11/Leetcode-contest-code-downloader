from collections import Counter
class Solution:
    def reorganizeString(self, S):
        n = len(S)
        cnt = Counter(S)
        m = max(cnt.values())
        if 2*m-1>n:
            return ""
        aux = ""
        lst = [(cnt[item], item) for item in cnt]
        lst.sort(reverse=True)
        for item in lst:
            aux = aux + item[1]*item[0]
        k = (n+1)//2
        ans = [0]*n
        for i in range (k):
            ans[2*i] = aux[i]
            if 2*i+1<n:
                ans[2*i+1] = aux[k+i]
        return "".join(ans)
            
        
        """
        :type S: str
        :rtype: str
        """
        