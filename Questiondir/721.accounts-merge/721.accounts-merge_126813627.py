class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        neighbors,emailIdxs = {},{}
        for i,account in enumerate(accounts):
            name = account[0]
            emails = account[1:]
            for j,email in enumerate(emails):
                if email not in neighbors:
                    neighbors[email] = {}
                if j!=0:
                    neighbors[email][emails[j-1]] = True
                if j!=len(emails)-1:
                    neighbors[email][emails[j+1]] = True
                if email not in emailIdxs:
                    emailIdxs[email] = {}
                emailIdxs[email][i] = True
        coveredIdxs,idx2emails = {},{}
        for i in xrange(len(accounts)):
            if i not in coveredIdxs:
                stack,past,idx2emails[i] = [accounts[i][1]],{accounts[i][1]:True},[]
                while len(stack)>0:
                    email = stack.pop()
                    idx2emails[i].append(email)
                    for idx in emailIdxs[email]:
                        coveredIdxs[idx] = True
                    for neigh in neighbors[email]:
                        if neigh not in past:
                            past[neigh] = True
                            stack.append(neigh)
                idx2emails[i].sort()
        return map(lambda i:[accounts[i][0]]+idx2emails[i],idx2emails.keys())