class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        Input:
        ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
        Output:  
        [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
        """
        M = collections.defaultdict(list)
        for path in paths:
            datum = path.split()
            dire = datum[0]
            for x in datum[1:]:
                #print 'yo', x
                ix = x.index('(')
                name = x[:ix]
                content = x[ix+1:-1]
                finalpath = dire + '/' + name
                M[content].append(finalpath)
        ans = M.values()
        return [x for x in ans if len(x) > 1]