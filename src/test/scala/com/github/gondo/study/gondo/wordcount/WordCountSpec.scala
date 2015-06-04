package com.github.gondo.study.gondo.wordcount

import org.scalatest._

/**
 * Created by naoki.gondo on 2015/06/04.
 */
class WordCountSpec extends FunSpec with Matchers {

  describe("A WordCount") {
    it("count each fruit") {
      val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
      val target = new WordCount
      target.countFruitsFromLines(lines) should be (Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1))
    }
  }
}
