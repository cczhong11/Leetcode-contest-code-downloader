

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


    def is_same_sign( self , a  , b  ) : 

        if( a > 0 and b > 0 ) : 
            return True 

        if( a < 0 and b < 0 ) : 
            return True 

        return False ; 


    def solve( self ) : 

        self.stack = deque( ) ; 

        self.ans_list = [ ] 


        for i in xrange( self.n ) : 

            


            while( len( self.stack ) > 0 ) : 

                if( self.stack[ 0 ] < 0 ) : 

                    x = self.stack[ 0 ] 
                    self.stack.popleft( ) ; 

                    self.ans_list.append( x ) 
                else : 
                    break ; 



            value = self.asteroids[ i ] ; 

            # print "i: "  , i , value ; 
            # print self.ans_list ; 
            # print "stack: " , self.stack ; 

            while( True ) :

                if ( len( self.stack) == 0 ) : 
                    self.stack.append(   value ) ; 
                    break ; 

                top = self.stack[ -1 ] ; 


                if( self.is_same_sign( value , top ) ) : 

                    self.stack.append( value ) ; 
                    break ; 

                v1 = math.fabs( value ) 
                v2 = math.fabs( top ) 

                if( v1 == v2 ) : 
                    self.stack.pop( ) ; 
                    break ; 

                elif( v1 < v2 ) : 
                    break ; 

                elif( v1 > v2 ) : 

                    self.stack.pop( ) ; 


        

        self.ans_list.extend( self.stack ) ;

        return self.ans_list 

        # return self.stack ; 



    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        
        self.n = len( asteroids ) ; 
        self.asteroids = asteroids ; 


        if( self.n <= 1 ) : 
            return asteroids ; 


        return self.solve( ) ; 

