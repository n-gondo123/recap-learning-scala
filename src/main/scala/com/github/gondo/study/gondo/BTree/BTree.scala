package com.github.gondo.study.gondo.BTree

/**
 * Created by naoki.gondo on 2015/06/25.
 */

//
// https://gist.github.com/j5ik2o/7332812
//
trait Node {
  def size: Int
  def max: Int
  def min: Int
  def sum: Int
  def avg: Double
  def find(searchNum: Int): Option[Node]
}

case class Leaf(num: Int) extends Node {
  def size = 1
  def max = num
  def min = num
  def sum = num
  def avg = num
  def find(searchNum: Int): Option[Node] = {
    if (num == searchNum) {
      Some(this)
    } else {
      None
    }
  }
}

case class Branch(leftNode: Node, num: Int, rightNode: Node) extends Node {
  def size = leftNode.size + rightNode.size + 1
  def max = rightNode.max
  def min = leftNode.min
  def sum = leftNode.sum + rightNode.sum + num
  def avg = sum / size
  def find(searchNum: Int): Option[Node] = {
    ???
  }
}

case class BTree(node: Node) {

  def size(): Int = {
    node.size
  }

  def max(): Int = {
    node.max
  }

  def min(): Int = {
    node.min
  }

  def sum(): Int = {
    node.sum
  }

  def avg(): Double = {
    node.avg
  }

  def find(searchNum: Int): Option[Node] = {
    node.find(searchNum)
  }

}

object BTree {
  def main(args: Array[String]): Unit = {

    val bTree1 = BTree(Leaf(1))
    val bTree2 = BTree(Branch(Leaf(1), 2, Leaf(3)))
    val bTree3 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))

    println(bTree1.size())
    println(bTree2.size())
    println(bTree3.size())
    println(bTree1.max())
    println(bTree2.max())
    println(bTree3.max())
    println(bTree1.min())
    println(bTree2.min())
    println(bTree3.min())
    println(bTree1.sum())
    println(bTree2.sum())
    println(bTree3.sum())
    println(bTree1.avg())
    println(bTree2.avg())
    println(bTree3.avg())
    println(bTree1.find(1))
    println(bTree2.find(1))
    println(bTree3.find(1))
  }
}
