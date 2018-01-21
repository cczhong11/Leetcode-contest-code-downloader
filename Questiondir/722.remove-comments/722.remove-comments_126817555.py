class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        
        answer = []
        multi = False
        i, lines = 0, len(source)
        curr = ''
        
        while i < lines:
            j = 0
            while j < len(source[i]):
                if source[i][j:j+2] == '//':
                    if not multi:
                        break
                    else:
                        j += 2
                elif source[i][j:j+2] == '/*':
                    if not multi:
                        multi = True
                        j += 2
                    else:
                        j += 1
                elif multi and source[i][j:j+2] == '*/':
                    multi = False
                    j += 2
                else:
                    if not multi:
                        curr += source[i][j]
                    j += 1
            if not multi:
                if len(curr) > 0:
                    answer.append(curr)
                curr = ''
            i += 1
        
        if curr:
            answer.append(curr)
        return answer
            
                
                    
                    
    