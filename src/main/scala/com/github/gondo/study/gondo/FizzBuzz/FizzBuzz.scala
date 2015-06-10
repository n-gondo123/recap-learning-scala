package com.github.gondo.study.gondo.FizzBuzz

/**
 * Created by naoki.gondo on 2015/06/09.
 */
object FizzBuzz {
  def main(args: Array[String]): Unit = {
    fizzBuzz1()
    fizzBuzz2()
    fizzBuzz3()
    fizzBuzz4()
    fizzBuzz5()
    fizzBuzz6()
  }

  /**
   * FizzBuzzの判定結果文字列を返す
   * @param num 整数値
   * @return 判定結果文字列
   */
  private def mkFizzBuzzString(num: Int): String = {
    (num % 3 == 0, num % 5 == 0) match {
      case (true, false) => "Fizz"
      case (false, true) => "Buzz"
      case (true, true) => "FizzBuzz"
      case _ => num.toString
    }
  }

  /**
   * FizzBuzzその1(初期バージョン)
   */
  private def fizzBuzz1(): Unit = {
    (1 to 100).foreach(num => println(mkFizzBuzzString(num)))
  }

  /**
   * FizzBuzzその2(ワンライナー)
   */
  private def fizzBuzz2(): Unit = (1 to 100).map(i => if (i % 15 == 0) "FizzBuzz" else if (i % 5 == 0) "Buzz" else if (i % 3 == 0) "Fizz" else i.toString).foreach(println)

  /**
   * FizzBuzzその3(2の倍数を除く)
   */
  private def fizzBuzz3(): Unit = {
    (1 to 100).withFilter(_ % 2 != 0).map(mkFizzBuzzString).foreach(println)
  }

  /**
   * FizzBuzzその4(カンマ区切り文字列)
   */
  private def fizzBuzz4(): Unit = {
    println((1 to 100).map(mkFizzBuzzString).mkString(","))
  }

  /**
   * FizzBuzzその5(Fizz/Buzz/FizzBuzzに該当しない数値の合計)
   */
  private def fizzBuzz5(): Unit = {
    println((1 to 100).filter(i => i % 3 != 0 && i % 5 != 0).sum)
  }

  /**
   * num〜endまで再帰処理を行う
   * @param num 開始値
   * @param end 終了値
   */
  private def recursiveFizzBuzz(num: Int, end: Int): Unit = {
    if (num <= end ) {
      println(mkFizzBuzzString(num))
      recursiveFizzBuzz(num + 1, end)
    }
  }

  /**
   * FizzBuzzその6(イテレーション/for/while 禁止)
   */
  private def fizzBuzz6(): Unit = {
    recursiveFizzBuzz(1, 100)
  }
}
