class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        def merge(accounts):
            email2name = {}
            name2email = {}
            for i, account in enumerate(accounts):
                name = account[0]
                emails = account[1:]
                j = i
                for email in emails:
                    if email in email2name:
                        j = email2name[email]
                        break
                if j not in name2email:
                    name2email[j] = set()
                for email in emails:
                    email2name[email] = j
                    name2email[j].add(email)
            ans = []
            for k, v in name2email.items():
                tmp = [accounts[k][0]]
                tmp.extend(list(v))
                ans.append(tmp)
            return ans
        ans = accounts
        while True:
            tmp = merge(ans)
            if len(tmp) == len(ans):
                break
            ans = tmp
        return [[a[0]]+sorted(set(a[1:])) for a in ans]