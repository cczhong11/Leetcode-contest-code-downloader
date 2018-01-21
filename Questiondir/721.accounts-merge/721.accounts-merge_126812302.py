from collections import defaultdict

class Solution(object):
    def find(self, x):
        if self.parents[x] == x:
            return x
        else:
            self.parents[x] = self.find(self.parents[x])
            return self.parents[x]
    
    def union(self, x, y):
        xroot = self.find(x)
        yroot = self.find(y)
        if self.ranks[xroot] > self.ranks[yroot]:
            self.parents[yroot] = xroot
        elif self.ranks[xroot] < self.ranks[yroot]:
            self.parents[xroot] = yroot
        elif xroot != yroot:
            self.parents[yroot] = xroot
            self.ranks[xroot] += 1
    
    def accountsMerge(self, accs):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        email_to_acc_id = {}
        self.parents = [i for i in xrange(len(accs))]
        self.ranks = [0 for i in xrange(len(accs))]
        for i in xrange(len(accs)):
            a = accs[i]
            name = a[0]
            emails = a[1:]
            acc_ids = []
            for e in emails:
                if e in email_to_acc_id:
                    acc_ids.append(email_to_acc_id[e])
                else:
                    email_to_acc_id[e] = i
            for acc_id in acc_ids:
                self.union(acc_id, i)
        account_emails = defaultdict(set)
        for i in xrange(len(accs)):
            root = self.find(i)
            account_emails[root] |= set(accs[i][1:])
        return [[accs[i][0]] + sorted(account_emails[i]) for i in account_emails]
        