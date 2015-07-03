package com.github.gondo.study.gondo

import collection.mutable


abstract class IntQueue {
  def put(x: Int): Unit
  def get(): Int
}

class BasicIntQueue extends IntQueue {
  val buffer = new mutable.ArrayBuffer[Int]
  def put(x: Int) = buffer += x
  def get(): Int = buffer.remove(0)
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) = super.put(x * 2)
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = super.put(x * 1)
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (x >= 1) {
      super.put(x + 1)
    }
  }
}

object Hoge extends App {
  val q = new BasicIntQueue()
  q.put(10)
  q.put(20)
  q.get() // => 20
  q.get() // => 40

  val dbIncQ = new BasicIntQueue with Doubling with Incrementing
  dbIncQ.put(10)
  dbIncQ.put(20)
  dbIncQ.get() // => 21
  dbIncQ.get() // => 41

  val incDbQ = new BasicIntQueue with Incrementing with Doubling
  incDbQ.put(10)
  incDbQ.put(20)
  incDbQ.get() // => 22
  incDbQ.get() // => 44
}
