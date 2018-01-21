class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        res=[]
        cur=''
        status=0
        for line in source:
            i=0
            while i<len(line):
                if status==0:
                    if i+1<len(line) and line[i:i+2]=='//':
                        break
                    elif i+1<len(line) and line[i:i+2]=='/*':
                        status=2
                        i+=2
                    else:
                        cur+=line[i]
                        i+=1
                elif status==1:
                    i+=1
                else:
                    if i+1<len(line) and line[i:i+2]=='*/':
                        status=0
                        i+=2
                    else:
                        i+=1
                        
            if status in {0,1} and cur:
                status=0
                res.append(cur)
                cur=''
        
        return res
    