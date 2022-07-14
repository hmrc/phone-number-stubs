package uk.gov.hmrc

import org.scalatest.wordspec.AnyWordSpec

class Testing extends AnyWordSpec {
  "Testing" should {
    "testing" in {
      assert(Set.empty.size === 0)
    }
  }
}