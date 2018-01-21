class Solution:
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """
        
        def helper(layer):
            if len(layer) <= 1:
                return True

            new_set = [""]

            for i in range(len(layer)-1):
                prev_set = new_set
                new_set = []
                if len(prev_set) == 0:
                    break
                d, e = layer[i], layer[i+1]
                if (d, e) not in options:
                    return False
                for top in options[(d, e)]:
                    for poss in prev_set:
                        new_set.append(poss + top)

            prev_set = new_set

            for item in prev_set:
                if helper(item):
                    return True

            return False


        options = {}
        for d, e, a in allowed:
            options.setdefault((d,e), [])
            options[(d, e)].append(a)

        return helper(bottom)