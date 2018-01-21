import re
FILE_RE = re.compile(r'(.*)\((.*)\)')
class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        data = {}
        for p in paths:
            files = p.split()
            directory = files.pop(0)
            for file in files:
                filename, content = FILE_RE.match(file).groups()
                filepath = '%s/%s' % (directory, filename)
                data.setdefault(content, []).append(filepath)
        return [v for v in data.itervalues() if len(v) > 1]