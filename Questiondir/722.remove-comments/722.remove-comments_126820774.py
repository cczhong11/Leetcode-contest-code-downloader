class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        state = 0
        res = []
        cache = ""
        for line in source:
            if state==0:
                pc = line.find("/*")
                ec = line.find("*/",pc+2)
                lc = line.find("//")
                while pc!=-1 and ec!=-1 and (lc==-1 or lc>pc):
                    line = line[:pc]+line[ec+2:]
                    pc = line.find("/*")
                    ec = line.find("*/",pc+2)
                    lc = line.find("//")
                lc = line.find("//")
                pc = line.find("/*")
                if lc<0: lc=128
                if pc<0: pc=128
                if lc<pc:
                    if lc!=0:
                        res.append(line[:lc])
                elif pc<lc:
                    cache=line[:pc]
                    state=1
                else:
                    if line:
                        res.append(line)
            elif state==1:
                k = line.find("*/")
                if k!=-1:
                    line=line[k+2:];
                    state=0
                    pc = line.find("/*")
                    ec = line.find("*/",pc+2)
                    lc = line.find("//")
                    while pc!=-1 and ec!=-1 and (lc==-1 or lc>pc):
                        line = line[:pc]+line[ec+2:]
                        pc = line.find("/*")
                        ec = line.find("*/",pc+2)
                        lc = line.find("//")
                    lc = line.find("//")
                    pc = line.find("/*")
                    if lc<0: lc=128
                    if pc<0: pc=128
                    if lc<pc:
                        if lc!=0:
                            cache+=(line[:lc])
                    elif pc<lc:
                        cache+=line[:pc]
                        state=1
                    else:
                        if line:
                            cache+=line
                    if cache:
                        res.append(cache)
                        cache=""
                    
        return res