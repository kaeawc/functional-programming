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

  trait TestSet {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  trait TestUnion extends TestSet {
    val u1 = union(s1,s2)
    val u2 = union(s2,s3)
    val u3 = union(s1,s3)
  }

  trait TestInsersect extends TestUnion {
    val i1 = intersect(u1,u2)
    val i2 = intersect(u2,u3)
    val i3 = intersect(u1,u3)
  }

  trait TestDiff extends TestUnion {
    val d1 = diff(u1,u2)
    val d2 = diff(u2,s1)
    val d3 = diff(s1,u3)
  }

  "FunSets" should {

    "have contains implemented" in new WithApplication {
      contains(x => true, 100) mustEqual true
    }

    "singletonSet(1) contains 1" in new WithApplication {
      
      /**
       * We create a new instance of the "TestSet" trait, this gives us access
       * to the values "s1" to "s3". 
       */
      new TestSet {
        /**
         * The string argument of "assert" is a message that is printed in case
         * the test fails. This helps identifying which assertion failed.
         */
        contains(s1, 1) mustEqual true
      }
    }

    "union contains all elements" in new WithApplication {
      new TestUnion {

        contains(u1, 1) mustEqual true
        contains(u1, 2) mustEqual true
        contains(u1, 3) mustEqual false

        contains(u2, 1) mustEqual false
        contains(u2, 2) mustEqual true
        contains(u2, 3) mustEqual true

        contains(u3, 1) mustEqual true
        contains(u3, 2) mustEqual false
        contains(u3, 3) mustEqual true
      }
    }

    "intersect contains all elements from both" in new WithApplication {
      new TestInsersect {

        contains(i1, 1) mustEqual false
        contains(i1, 2) mustEqual true
        contains(i1, 3) mustEqual false

        contains(i2, 1) mustEqual false
        contains(i2, 2) mustEqual false
        contains(i2, 3) mustEqual true

        contains(i3, 1) mustEqual true
        contains(i3, 2) mustEqual false
        contains(i3, 3) mustEqual false
      }
    }

    "diff contains only elements not in one or the other" in new WithApplication {
      new TestDiff {

        contains(d1, 1) mustEqual true
        contains(d1, 2) mustEqual false
        contains(d1, 3) mustEqual true

        contains(d2, 1) mustEqual true
        contains(d2, 2) mustEqual true
        contains(d2, 3) mustEqual true

        contains(d3, 1) mustEqual false
        contains(d3, 2) mustEqual false
        contains(d3, 3) mustEqual true
      }
    }
  }
}
