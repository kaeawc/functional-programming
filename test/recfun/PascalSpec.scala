package recfun

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.mvc.SimpleResult
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.Future

class PascalSpec extends Specification {

  import Main._

  "RecFun's Pascal function" should {

    "given 0 columns and 2 rows, return 1" in new WithApplication{

      pascal(0,2) mustEqual 1

    }

    "given 1 columns and 2 rows, return 2" in new WithApplication {

      pascal(1,2) mustEqual 2

    }

    "given 1 columns and 3 rows, return 3" in new WithApplication {

      pascal(1,3) mustEqual 3

    }
  }
}
