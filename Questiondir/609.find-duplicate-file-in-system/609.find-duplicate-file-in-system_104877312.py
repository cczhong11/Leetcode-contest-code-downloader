from collections import defaultdict
class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        groups = []
        contents_to_files = defaultdict(list)
        for path in paths:
            path = path.split()
            directory = path[0]
            for file in path[1:]:
                name, contents = file.split('(')
                contents_to_files[contents].append((directory, name))
        for contents, files in contents_to_files.items():
            if len(files) > 1:
                groups.append([f[0] + '/' + f[1] for f in files])
        return groups