package com.github.gondo.study.gondo.nnp

import scala.annotation.tailrec

/**
 * Created by naoki.gondo on 2015/06/12.
 */
trait NNP10 {

  // 番外編(総和)
  def sum(n: Int): Int = {
    @tailrec
    def loop(i: Int, acc: Int): Int = {
      i match {
        case n if n == 0 => acc
        case _ => loop(i - 1, acc + i)
      }
    }
    loop(n, 0)
  }

  // P01 (*) Find the last element of a list.
  @tailrec
  final def last(list: List[Int]): Int = {
    list match {
      case Nil => throw new IllegalArgumentException
      case head::Nil => head
      case head::tail => last(tail)
    }
  }

  // P02 (*) Find the last but one element of a list.
  @tailrec
  final def penultimate(list: List[Int]): Int = {
    list match {
      case Nil => throw new IllegalArgumentException
      case head::Nil => throw new IllegalArgumentException
      case head::last::Nil=> head
      case head::tail => penultimate(tail)
    }
  }

  def nth(n: Int, list: List[Int]): Int = {
    @tailrec
    def loop(lst: List[Int], idx: Int): Int = {
      idx match {
        case i if i == n => lst.head
        case _ => loop(lst.tail, idx + 1)
      }
    }
    loop(list, 0)
  }

  def length(list: List[Int]): Int = {
    @tailrec
    def loop(lst: List[Int], sum: Int): Int = {
      lst match {
        case Nil => sum
        case _ => loop(lst.tail, sum + 1)
      }
    }
    loop(list, 0)
  }

  def reverse(list: List[Int]): List[Int] = {
    @tailrec
    def loop(lst: List[Int], acc: List[Int]): List[Int] = {
      lst match {
        case Nil => acc
        case _ => loop(lst.init, acc :+ lst.last)
      }
    }
    loop(list, Nil)
  }

  def isPalindrome(list: List[Int]): Boolean = {
    list == list.reverse
  }

  def flatten(nested: List[Any]): List[Any] = {
    ???
  }

  def compress(list: List[Symbol]): List[Symbol] = {
    @tailrec
    def concat(prev: List[Symbol], next: List[Symbol]): List[Symbol] = {
      next match {
        case Nil => prev
        case n if prev.last != next.head => concat(prev :+ next.head, next.tail)
        case _ => concat(prev, next.tail)
      }
    }
    concat(list.take(1), list.tail)
  }

  def pack(list: List[Symbol]): List[List[Symbol]] = {
    ???
  }

  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    ???
  }

}