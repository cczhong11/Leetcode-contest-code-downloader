

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




class Expr : 

    def __init__ ( self , parent ) : 

        self.parent = parent ; 
        self.var_value_dict = dict( ) ; 

    def split ( self , expr ) : 

        expr = expr.strip( ) ; 

        n = len( expr ) ; 

        i = 0 ; 

        select_value = "" ; 

        ret_list = [ ] 


        left_kuohao_cnt = 0 ; 

        for i in xrange( n ) :

            c = expr [ i ] ; 

            # print "i: " , i  ,c , " select: " , select_value ,  left_kuohao_cnt ; 

            if( c == " " ) : 

                if( left_kuohao_cnt > 0 ) : 
                    select_value += c ; 

                else : 

                    if( select_value != "" ) : 

                        ret_list.append( select_value ) ; 
                        select_value = "" ; 
            else : 

                select_value += c ; 

                if( c == '(' ) : 
                    left_kuohao_cnt += 1 ; 

                elif( c == ')' ) : 
                    left_kuohao_cnt -= 1 ; 


        if( select_value != "" ) : 
            ret_list.append( select_value ) ; 


        # print "input-expr: " , expr; 

        # print "split , ret-list: " , ret_list ; 

        return ret_list ; 

    def get_e1_e2( self , expr ) : 

        ret_list = self.split( expr  ) ; 

        e1 , e2 = ret_list ; 

        return self.calc_e1_e2( e1 , e2 ) ; 



    def calc_e1_e2( self , e1 , e2 )  : 


        self.expr_1 = Expr( self ) ; 
        self.expr_2 = Expr( self ) ; 

        result_1 = self.expr_1.parser( e1 ) ; 
        result_2 = self.expr_2.parser( e2 ) ; 

        return result_1 , result_2 ; 


    def add( self , e1 , e2 ) : 
        return e1 + e2 ; 

    def mult( self , e1 , e2 ) : 
        return e1 * e2 ; 

    def get_var_value( self , name ) : 

        now = self ; 

        while( True ) : 

            if( name in now.var_value_dict ) : 
                return now.var_value_dict[ name ] ; 

            now = now.parent ; 


    def get_first_name( self , expr ) : 

        n = len( expr ) ; 

        first_name = "" ; 
        i = 0 ; 
        while( i < n ) : 

            if( expr[ i ] != " " ) : 
                first_name += expr[ i ] ; 
                i = i + 1 ; 

            else : 
                break ; 


        return first_name , i 


    def parser_let( self , expr ) : 


        ret_list = self.split( expr  ) ; 

        n = len( ret_list ) 

        calc_result = None ; 

        for i in xrange( 0 , n , 2 ) : 


            var_1 = ret_list[ i ] ; 
            
            if( i + 1 < n ) : 
                the_str_expr_1 = ret_list[ i + 1 ] ; 
            else : 
                the_str_expr_1 = var_1 ; 


            expr_1 = Expr( self ) ; 
           
            result_1 = expr_1.parser( the_str_expr_1 ) ; 
            
            self.var_value_dict[ var_1 ] = result_1 ; 

            calc_result = result_1 ; 

        return calc_result ; 


    def parser( self , origin_expr ) : 

        try : 
            v = int( origin_expr ) 

            return v ; 
        except : 
            pass  ; 

        if( origin_expr[ 0 ] != '(' ) : 

            return self.get_var_value( origin_expr ) ; 


        expr = origin_expr[ 1 : -1 ] ; 

                
        first_name , i = self.get_first_name( expr ) ; 


        # print "first_name: " , first_name ; 

        if( first_name == 'let' ) : 
            
            result = self.parser_let( expr[i + 1 : ] ) ;
            return result ; 

        else : 

            e1 , e2 = self.get_e1_e2( expr[i + 1 : ] ) ; 


            if( first_name =="add" ) : 
                return self.add( e1 , e2 ) ; 

            elif( first_name == 'mult' ) : 
                return self.mult( e1 , e2 ) ; 







class Solution(object):
    

    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        self.expr = Expr( None ) ; 
        result = self.expr.parser( expression ) ; 


        return result ; 
