import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.mvc.SimpleResult
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.Future

class ApplicationSpec extends Specification {

  "Application" should {

    "render the index page" in new WithApplication{

      route(FakeRequest(GET, "/")) map {
        case response:Future[SimpleResult] => {
          status(response) must equalTo(OK)
          contentType(response) must beSome.which(_ == "text/html")
        }
        case _ => failure("Route doesn't exist")
      }
    }
  }
}