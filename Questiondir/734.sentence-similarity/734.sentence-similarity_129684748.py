

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


    def init( self ) : 

        self.pair_set = set( ) ; 

        self.SEP = "$" ; 

        for one_pair in self.pairs : 

            a , b = one_pair ; 

            self.pair_set.add( a + self.SEP + b ) 

            self.pair_set.add( b + self.SEP + a )



    def solve( self ) : 

        self.init( ) ; 


        for i in xrange( self.n ) : 

            w_1 = self.word_1_list[ i ] ; 

            w_2 = self.word_2_list[ i ] ; 

            if( w_1 == w_2 ) : 
                continue ; 

            key = w_1 + self.SEP + w_2 ; 

            if( key in self.pair_set ):
                continue 

            else : 
                return False ; 

        return True ; 


    

    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """

        self.n = len( words1 ) ; 
        self.word_1_list  = words1 ; 

        
        self.word_2_list = words2 ; 
        self.m = len( self.word_2_list ) ; 

        self.pairs = pairs ; 

        if( self.n != self.m ) : 
            return False ; 



        return self.solve( ) ; 


