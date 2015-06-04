package com.github.gondo.study.gondo.wordcount

/**
 * Created by naoki.gondo on 2015/06/04.
 */
class WordCount {

  //------------------------------------------------------
  // ワードカウント問題
  // https://gist.github.com/j5ik2o/7210762
  //------------------------------------------------------
  def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
    lines
      .reduceLeft((a, b) => a + " " + b)
      .split(" ")
      .groupBy(w => w)
      .map { case (key, list) =>
        key -> list.length
      }
  }
}
