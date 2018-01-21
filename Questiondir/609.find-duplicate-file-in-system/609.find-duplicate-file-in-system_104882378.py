class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        dic = dict()
        for path in paths:
            docs = path.split()
            for doc in docs[1:]:
                fn, ct = doc.split('(')
                ct = ct[:-1]
                if not ct in dic:
                    dic[ct] = []
                dic[ct].append(docs[0] + '/' + fn)
        res = []
        for files in dic.values():
             if len(files) > 1:
                 res.append(files)
        return res