package org.scalamock.handlers

import org.scalamock.context.Call
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TestHandler extends Handler {
  override private[scalamock] def handle(call: Call) = None

  override private[scalamock] def verify(call: Call) = true

  override private[scalamock] def isSatisfied = true

  override def toString: String = "test-handler"

}

class TestHandlers extends Handlers {
  override protected val prefix: String = "testPrefix"

  override private[scalamock] def handle(call: Call) = None

  override private[scalamock] def verify(call: Call) = true
}

class HandlersTest extends AnyWordSpec with Matchers {

  "Handlers" should {

    "show toString method" in {
      val handlers = new TestHandlers
      handlers.add(new TestHandler)

      handlers.toString shouldBe
        """testPrefix {
          |  test-handler
          |}""".stripMargin
    }

  }

}
