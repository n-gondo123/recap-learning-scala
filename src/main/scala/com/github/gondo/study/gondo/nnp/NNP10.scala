package com.github.gondo.study.gondo.nnp

/**
 * Created by naoki.gondo on 2015/06/12.
 */
trait NNP10 {

  // P01 (*) Find the last element of a list.
  def last(list: List[Int]): Int = {
    list.last
  }

  // P02 (*) Find the last but one element of a list.
  def penultimate(list: List[Int]): Int = {
    list.init.last
  }

  def nth(n: Int, list: List[Int]): Int = {
    list(n)
  }

  def length(list: List[Int]): Int = {
    list.size
  }

  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }

  def isPalindrome(list: List[Int]): Boolean = {
    list == list.reverse
  }

  def flatten(nested: List[Any]): List[Any] = {
    ???
  }

  def compress(list: List[Symbol]): List[Symbol] = {
    def concat(prev: List[Symbol], next: List[Symbol]): List[Symbol] = {
      if (next.isEmpty) {
        prev
      } else {
        if (next.head != prev.last) {
          concat(prev :+ next.head, next.tail)
        } else {
          concat(prev, next.tail)
        }
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