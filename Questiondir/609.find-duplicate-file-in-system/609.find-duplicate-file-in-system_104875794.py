class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        n = len(paths)
        d = {}
        for i in range(n):
            w = paths[i].find(' ')
            dir = paths[i][:w]
            files = paths[i][w+1:].split(' ')
            for j in range(len(files)):
                w = files[j].find('(')
                fileName = files[j][:w]
                content = files[j][w+1:-1]
                d[dir+'/'+fileName] = content
        dd = {}
        res = []
        total = 0
        for x in d.keys():
            if d[x] in dd:
                res[dd[d[x]]].append(x)
            else:
                dd[d[x]] = total
                res.append([x])
                total+=1
        ans = []
        for i in range(len(res)):
            if len(res[i])>1:
                ans.append(res[i])
        return ans
                
                
                
                
                
                
                