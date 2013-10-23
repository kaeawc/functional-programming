package recfun

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.mvc.SimpleResult
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.Future

class CountChangeSpec extends Specification {

  import Main.countChange

  "RecFun's countChange" should {

    "example given in instructions" in new WithApplication {

      countChange(4,List(1,2)) mustEqual 3

    }

    "sorted CHF" in new WithApplication {

      countChange(300,List(5,10,20,50,100,200,500)) mustEqual 1022

    }

    "no pennies" in new WithApplication {

      countChange(301,List(5,10,20,50,100,200,500)) mustEqual 0

    }

    "unsorted CHF" in new WithApplication {

      countChange(300,List(500,5,50,100,20,200,10)) mustEqual 1022

    }
  }
}
