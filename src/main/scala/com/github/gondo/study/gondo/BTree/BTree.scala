package com.github.gondo.study.gondo.BTree

/**
 * Created by naoki.gondo on 2015/06/25.
 */

// https://gist.github.com/j5ik2o/7332812
trait Node {
  // ...
  val num: Int
}

case class Leaf(i: Int) extends Node {
  val num = i
}

case class Branch(lNode: Node, bNum: Int, rNode: Node) extends Node {
  val num = bNum
  val leftNode: Node = lNode
  val rightNode: Node = rNode
}

case class BTree(node: Node) {

  def size(): Int = {
    ???
  }

  def max(): Int = {
    ???
  }

  def min(): Int = {
    ???
  }

  def sum(): Int = {
    ???
  }

  def avg(): Int = {
    ???
  }

}

object BTree {

  val bTree1 = BTree (Leaf (1) )
  val bTree2 = BTree (Branch (Leaf (1), 2, Leaf (3) ) )
  val bTree3 = BTree (Branch (Branch (Leaf (1), 2, Leaf (3) ), 4, Branch (Leaf (5), 6, Leaf (7) ) ) )
}
