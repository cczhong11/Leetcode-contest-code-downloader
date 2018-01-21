class Solution:
    def getRoot(self, email):
        parent = self.merged_with.get(email, None)
        if parent is not None:
            root = self.getRoot(parent)
            self.merged_with[email] = root
        else:
            return email
            
        return root
    
    def mergeEmails(self, email1, email2):
        root1 = self.getRoot(email1)
        root2 = self.getRoot(email2)
        
        if root1 != root2:
            self.merged_with[root2] = root1
    
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        
        self.merged_with = {}
        result = {}
        
        for account in accounts:
            if len(account) == 1:
                continue
                
            root_email = self.getRoot(account[1])
            
            for email in account[2:]:
                self.mergeEmails(root_email, email)

                
                
        for account in accounts:
            if len(account) == 1:
                continue
                
            root_email = self.getRoot(account[1])
            grouped_emails = result.setdefault(root_email, (account[0], {root_email}))[1]
            
            for email in account[1:]:
                grouped_emails.add(email)
                
        return [[name] + sorted(emails) for name, emails in result.values()]
                
                
        