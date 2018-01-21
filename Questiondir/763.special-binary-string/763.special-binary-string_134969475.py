class Solution(object):
    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
        n=len(S)
        print(n)
        ones=[0]*(n+1)
        cnt=0
        rec=[[] for _ in range(n)]
        rec[0].append(0)
        peak=0
        s=[ord(c)-ord('0') for c in S]
        for i in range(n):
            if s[i]==1:
                cnt+=1
            else:
                cnt-=1
            ones[i+1]=cnt
            peak=max(peak,cnt)
            rec[cnt].append(i+1)
        def st(lst,m):
            ans=0
            for i in range(m):
                ans=ans*2+(lst[i] if i<len(lst) else 0)            
            return [ans,len(lst)]
        for i in range(peak,-1,-1):
            if len(rec[i])>2:
                j=1
                while j<len(rec[i])-1:
                    if s[rec[i][j]]==1 and s[rec[i][j]-1]==0:
                        t=[s[rec[i][j-1]:rec[i][j]]]
                        begin=rec[i][j-1]
                        end=rec[i][j]
                        m=end-begin
                        while j<len(rec[i])-1 and s[rec[i][j]]==1 and s[rec[i][j]-1]==0:
                            j+=1
                            t.append(s[rec[i][j-1]:rec[i][j]])
                            end=rec[i][j]
                            m=max(m,rec[i][j]-rec[i][j-1])
                        print(t,m)
                        p=[st(itv,m) for itv in t]
                        p.sort(reverse=True)
                        print(p)
                        temp=''.join([bin(num[0])[2:num[1]+2] for num in p])
                        print(temp)
                        for k in range(begin,end):
                            s[k]=1 if temp[k-begin]=='1' else 0
                    else:
                        j+=1
        return ''.join([str(nums) for nums in s])
        
            