class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        
        
        parent={}
        
        def par(e):
            if e==parent[e]:
                return e
            else:
                parent[e]=par(parent[e])
                return parent[e]
            
        
        def union(a,b):
            pa=par(a)
            pb=par(b)
            parent[pa]=pb
            return
        
        
        for a in accounts:
            name=a[0]
            email=name+" "+a[1]
            
            if not email in parent:
                parent[email]=email
            
            for emaili in a[1:]:
                newname=name+" "+emaili
                
                if not newname in parent:
                    parent[newname]=newname
                
                union(email,newname)
                
                
        output=[]
        
        hasoutput={}
        index=0
        
        for i in parent:
            p=par(i)
            if p in hasoutput:
                j=hasoutput[p]
                output[j].append(i.split(' ')[1])
            else:
                output.append(i.split(' '))
                hasoutput[p]=index
                index+=1
                
        
        moutput=[]
        
        for o in output:
            moutput.append([o[0]]+sorted(o[1:]))
        
                
        return moutput
        
                
                
                
                
                
                
                
                
                
                
                