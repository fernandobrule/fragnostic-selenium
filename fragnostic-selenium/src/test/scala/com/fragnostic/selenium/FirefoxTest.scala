package com.fragnostic.selenium

import com.fragnostic.selenium.service.CakeSeleniumService.seleniumServiceFirefox.{ getWebDriver, sendKeysToTxf, waitForAjaxResponse }
import org.scalatest._

class FirefoxTest extends FunSpec with Matchers {

  describe("Firefox Test") {

    it("Can Search In Google") {

      val url: String = "https://www.google.com/"

      getWebDriver(url)

      waitForAjaxResponse(3500)

      sendKeysToTxf("q", "wire")

    }

  }

}
