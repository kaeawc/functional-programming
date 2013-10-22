package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    val open = chars.indexOf('(')
    var close = chars.indexOf(')')

    if (open >= 0) {
      if (open < close) {

        var i = 1

        val depth = chars.slice(open + 1, chars.length) map {
          char:Char =>
          char match {
            case '(' => 1
            case ')' => -1
            case _ => 0
          }
        }

        if(depth == 0) balance(chars.slice(close + 1,chars.length))
        else false
      } else false
    } else if (close >= 0) {
      false
    } else {
      true
    }

    //if there is an open
    //need to find its closing
    //balance the rest of the string
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    var change = money
    var ways:Int = 0

    while(change > 0) {
      ways = countChange(money, coins)
    }

    ways
  }
}
