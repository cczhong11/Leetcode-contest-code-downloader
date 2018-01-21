import hashlib
class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        dmap = {}
        for pp in paths:
            path, files = pp.split(' ',1)
            for file in files.split():
                fname,fcontent = file.split('(')
                fhash = hashlib.md5(fcontent).hexdigest()
                dmap.setdefault(fhash, []).append('/'.join((path,fname)))
        
        dupes = [v for v in dmap.values() if len(v) > 1]
        return dupes