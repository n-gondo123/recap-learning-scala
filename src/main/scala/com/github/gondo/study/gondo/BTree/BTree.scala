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
  override def size = 1
  override def max = num
  override def min = num
  override def sum = num
  override def avg = num
  override def find(searchNum: Int): Option[Node] = {
    if (num == searchNum) {
      Some(this)
    } else {
      None
    }
  }
}

case class Branch(leftNode: Node, num: Int, rightNode: Node) extends Node {
  override def size = leftNode.size + rightNode.size + 1
  override def max = rightNode.max
  override def min = leftNode.min
  override def sum = leftNode.sum + rightNode.sum + num
  override def avg = sum.toDouble / size
  override def find(searchNum: Int): Option[Node] = {
    if (searchNum == num) {
      Some(this)
    } else if (searchNum < num) {
      leftNode.find(searchNum)
    } else {
      rightNode.find(searchNum)
    }
  }
}

case class BTree(node: Node) {
  def size = node.size
  def max = node.max
  def min = node.min
  def sum = node.sum
  def avg = node.avg
  def find(searchNum: Int): Option[Node] = node.find(searchNum)
}

object BTree {
  def apply(list: List[Int]): BTree = {
    // リストが平衡二分木にならないものは対象外とする
    def check(num: Int): Boolean = {
      if (num == 0 || num == 2) {
        true
      } else {
        num % 2 match {
          case 0 => check(num / 2)
          case 1 => false
        }
      }
    }

    if (check(list.size + 1)) {
      ???
    } else {
      throw new IllegalArgumentException
    }
  }
}

object BTreeTest {
  def main(args: Array[String]): Unit = {
    val bTree1 = BTree(Leaf(1))
    val bTree2 = BTree(Branch(Leaf(1), 2, Leaf(3)))
    val bTree3 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))

    println(bTree1.size)
    println(bTree2.size)
    println(bTree3.size)
    println(bTree1.max)
    println(bTree2.max)
    println(bTree3.max)
    println(bTree1.min)
    println(bTree2.min)
    println(bTree3.min)
    println(bTree1.sum)
    println(bTree2.sum)
    println(bTree3.sum)
    println(bTree1.avg)
    println(bTree2.avg)
    println(bTree3.avg)
    println(bTree1.find(1))
    println(bTree2.find(1))
    println(bTree3.find(1))

    val bTree4 = BTree((1 to 7).toList)
    println(bTree4)
  }
}
