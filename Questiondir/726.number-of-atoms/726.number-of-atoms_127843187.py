class Solution(object):
    def countOfAtoms(self, formula):
        """
        :type formula: str
        :rtype: str
        """
        
        def analyze(s):
            d={}
            n=len(s)
            i=0
            while i<n:
                if s[i].isupper():
                    j=i+1
                    while j<n and s[j].islower(): 
                        j+=1
                    name=s[i:j]
                    count=1
                    k=j
                    while k<n and s[k].isdigit():
                        k+=1
                    count=int(s[j:k]) if k>j else 1
                    d[name]=d.get(name,0)+count
                    i=k
                elif s[i]=='(':
                    left=1
                    j=i+1
                    while left>0 and j<n:
                        left+=1 if s[j]=='(' else (-1 if s[j]==')' else 0)
                        j+=1
                    temp=analyze(s[i+1:j-1])
                    k=j
                    while k<n and s[k].isdigit():
                        k+=1
                    multi=int(s[j:k]) if k>j else 1
                    
                    for element in temp:
                        d[element]=d.get(element,0)+temp[element]*multi
                        
                    i=k
                    
            return d
        
        prep=analyze(formula)
        ans=''
        for ele in sorted(prep.keys()):
            ans+=ele+('' if prep[ele]==1 else str(prep[ele]))
        return ans