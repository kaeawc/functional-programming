package funsets

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.mvc.SimpleResult
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.Future

class FunSetsSpec extends Specification {

  import FunSets._

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  "FunSets" should {

    "have contains implemented" in new WithApplication {
      contains(x => true, 100) mustEqual true
    }

    "singletonSet(1) contains 1" in new WithApplication {
      
      /**
       * We create a new instance of the "TestSets" trait, this gives us access
       * to the values "s1" to "s3". 
       */
      new TestSets {
        /**
         * The string argument of "assert" is a message that is printed in case
         * the test fails. This helps identifying which assertion failed.
         */
        contains(s1, 1) mustEqual "Singleton"
      }
    }.pendingUntilFixed("| Not Yet Implemented")

    "union contains all elements" in new WithApplication {
      new TestSets {
        val s = union(s1, s2)
        contains(s, 1) mustEqual true
        contains(s, 2) mustEqual true
        contains(s, 3) mustEqual false
      }
    }.pendingUntilFixed("| Not Yet Implemented")
  }
}
