class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        dict = {}
        result=[]
        
        for path in paths:
            left = 0
            right = 0
            white = []
            for i in range(len(path)):
                if path[i]==' ':
                    white.append(i)
                if path[i]=='(':
                    left = i
                if path[i]==')':
                    right = i
                    content = path[left+1:right]
                    direct = path[0:white[0]]
                    name = path[white[-1]+1:left]
                    if content not in dict:
                        dict[content] = len(dict)
                        result.append([])
                        result[-1].append(direct+'/'+name)
                    else:
                        result[dict[content]].append(direct+'/'+name)
        temp = []
        for i in result:
            if len(i)>1:
                temp.append(i)
        
        return temp
                        
                