class Solution(object):
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        hold=None
        sell=0
        
        for i in range(len(prices)):
            if hold is None:
                hold=-prices[i]-fee
            else:
                hold,sell=max(hold,sell-prices[i]-fee),max(sell,hold+prices[i])

        return sell
            