package main.AllProblems.stacks

import scala.annotation.tailrec
import scala.collection.mutable

object InfixToPostFixUsingStacks
{
    def priority(char: Char):Int={
      char match {
        case '+'=> 1
        case '-'=>1
        case '*'=>2
        case '/'=>2
        case '^'=>3
        case _ => -1
      }
    }

      @tailrec
      def popTillLeftBracket(result:String, stack:mutable.Stack[Char]):(String,mutable.Stack[Char])={
       if(stack.isEmpty || (stack.head=='(')) (result,stack.tail)
       else
       popTillLeftBracket(result+stack.head,stack.tail)
      }

    @tailrec
    def operatorPrecedence(exp: String, result: String, stack: mutable.Stack[Char]):(String,mutable.Stack[Char])={
      if(stack.isEmpty||priority(exp.head)>priority(stack.head)) (result,stack.push(exp.head))
      else operatorPrecedence(exp,result+stack.head,stack.tail)
    }

    @tailrec
    def popOutAll(stack:  mutable.Stack[Char], acc:String):String={
      if(stack.isEmpty) acc
      else popOutAll(stack.tail, acc+stack.head)
    }

    @tailrec
    def infixToPostFix(exp: String, acc:String, stack:mutable.Stack[Char]):String={
      if(exp.isEmpty){
        if(stack.nonEmpty){
          popOutAll(stack,acc)
        }
        else acc
      }
      else if(exp.head.isLetterOrDigit) infixToPostFix(exp.tail,acc:+exp.head,stack)
      else if(exp.head=='(') {
        val s:mutable.Stack[Char]=stack.push(exp.head)
        infixToPostFix(exp.tail,acc,s)
      }
      else if(exp.head==')'){
        val (result:String,s:mutable.Stack[Char])=popTillLeftBracket(acc,stack)
      infixToPostFix(exp.tail,result,s)
      }
      else{
        val  (result:String,s:mutable.Stack[Char])=operatorPrecedence(exp,acc,stack)
      infixToPostFix(exp.tail,result,s)
    }
    }

    def main(Args:Array[String]):Unit={
        val exp:String="a+b*(c^d-e)^(f+g*h)-i"
        println(infixToPostFix(exp,"",new mutable.Stack[Char]()))
    }
}
