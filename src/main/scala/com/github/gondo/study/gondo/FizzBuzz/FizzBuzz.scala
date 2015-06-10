package com.github.gondo.study.gondo.FizzBuzz

/**
 * Created by naoki.gondo on 2015/06/09.
 */
object FizzBuzz {
  def main(args: Array[String]): Unit = {
    (1 to 100).foreach(num => println(fizzBuzz(num)))
  }

  private def fizzBuzz(num: Int): String = {
    (num % 3 == 0, num % 5 == 0) match {
      case (true, false) => "Fizz"
      case (false, true) => "Buzz"
      case (true, true) => "FizzBuzz"
      case _ => num.toString
    }
  }
}
