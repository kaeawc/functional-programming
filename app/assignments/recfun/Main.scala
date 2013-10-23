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


    def findDepth(chars:List[Char],depth:Int = 0):Int = {

      if (chars.length > 0) {
        val current = chars.head match {
          case '(' => 1
          case ')' => -1
          case _ => 0
        }

        if (depth + current < 0) -1
        else findDepth(chars.slice(1,chars.length),depth + current)
      } else 0
    }

    findDepth(chars) == 0
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
