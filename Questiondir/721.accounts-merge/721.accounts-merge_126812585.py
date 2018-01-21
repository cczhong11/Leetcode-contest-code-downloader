class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        
        graph = {}
        emails = {}
        for account in accounts:
            for i in range(1, len(account)):
                if account[i] not in graph:
                    graph[account[i]] = []
                emails[account[i]] = account[0]
                for j in range(i+1, len(account)):
                    if account[j] not in graph:
                        graph[account[j]] = []
                    graph[account[i]].append(account[j])
                    graph[account[j]].append(account[i])
                    emails[account[j]] = account[0]

        def dfs(graph, email, visited, curr):
            curr.append(email)
            visited.add(email)
            for nei in graph[email]:
                if nei not in visited:
                    dfs(graph, nei, visited, curr)
                    
        visited = set()
        answer = []
        for email in emails:
            if email not in visited:
                curr = []
                dfs(graph, email, visited, curr)
                curr.sort()
                curr.insert(0, emails[email])
                answer.append(curr)
        return answer