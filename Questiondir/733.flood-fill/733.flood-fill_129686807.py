

import sys
from collections import *
import math

import Queue

import copy 

import random

from heapq import * 

from collections import deque

class Global :
    IS_DUBUG = False ;






class Solution(object):

    Xi = [ -1 , 0 , 1 , 0 ] ; 
    Yj = [ 0 ,  1 , 0 , -1 ] ;
   

    def is_in( self , i , j ) : 

        return i >= 0 and i < self.n and j >= 0 and j < self.m ; 

    def dfs( self , i , j ) : 

        for k in xrange( 4 ) : 

            next_i = i + self.Xi[ k ] ; 
            next_j = j + self.Yj [ k ] ; 

            if( not self.is_in( next_i , next_j ) ) : 

                continue

            if( self.image[ next_i ] [ next_j ] == self.start_color ) : 

                self.image[ next_i ] [ next_j ] = self.newColor ; 
                self.dfs( next_i , next_j ) ; 



    def solve( self ) : 


        self.image[ self.start_i  ] [ self.start_j ] = self.newColor ; 
        self.dfs( self.start_i , self.start_j    ) ; 

        return self.image ; 


    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """

        self.image = image ; 
        self.start_i = sr ; 
        self.start_j = sc ; 

        self.start_color = self.image[ sr ] [ sc ] ; 

        self.newColor = newColor ; 

        self.n = len( self.image ); 

        if( 0 == self.n ) : 
            return self.image ; 

        self.m = len( self.image[ 0 ] ) ; 

        if( self.start_color == self.newColor ) : 
            return self.image ; 


        return self.solve( ) ; 


