package recfun

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.mvc.SimpleResult
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.Future

class BalanceSpec extends Specification {

  import Main.balance

  "RecFun's balance" should {

    "'(if (zero? x) max (/ 1 x))' is balanced" in new WithApplication {

      balance("(if (zero? x) max (/ 1 x))".toList) mustEqual true

    }

    "'I told him ...' is balanced" in new WithApplication {

      balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList) mustEqual true

    }

    "':-)' is unbalanced" in new WithApplication {

      balance(":-)".toList) mustEqual false

    }

    "counting is not enough" in new WithApplication {

      balance("())(".toList) mustEqual false

    }
  }
}
