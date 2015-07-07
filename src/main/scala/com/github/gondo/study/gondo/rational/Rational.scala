package com.github.gondo.study.gondo.rational

case class Rational (numerator: Int, denominator: Int) {
  def +(that: Rational): Rational = {
    Rational(this.numerator * that.denominator + that.numerator * this.denominator, this.denominator * that.denominator)
  }

  def <(that: Rational): Boolean = {
    val num1 = this.numerator * that.denominator
    val num2 = that.numerator * this.denominator
    return num1 < num2
  }

  def >(that: Rational): Boolean = {
    val num1 = this.numerator * that.denominator
    val num2 = that.numerator * this.denominator
    return num1 > num2
  }

  def <=(that: Rational): Boolean = {
    val num1 = this.numerator * that.denominator
    val num2 = that.numerator * this.denominator
    return num1 <= num2
  }

  def >=(that: Rational): Boolean = {
    val num1 = this.numerator * that.denominator
    val num2 = that.numerator * this.denominator
    return num1 >= num2
  }
}

object Hoge extends App {
  val r1 = Rational(1, 3) + Rational(1, 3)
  println(r1)
}
