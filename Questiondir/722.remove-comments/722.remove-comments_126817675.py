class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        output=[]
        
        comment=False
        newline=True
        
        for s in source:
            
            leng=len(s)
            
            line=[]
            
            last=""
            
            for si in s:
                if comment:
                    if si=="/" and last=="*":
                        comment=False
                    else:
                        last=si
                else:
                    if si=="*" and last=="/":
                        comment=True
                        line.pop()
                        last=""
                    elif si=="/" and last=="/":
                        line.pop()
                        break
                    else:
                        line.append(si)
                        last=si
            
            if newline:
                if len(line)>0:
                    output.append("".join(line))
            else:
                if len(line)>0:
                    output[-1]+=("".join(line))
            
            if comment:
                newline=False
            else:
                newline=True
            
        return output
                
                
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        