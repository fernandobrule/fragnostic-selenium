package com.fragnostic.selenium

import com.fragnostic.selenium.service.CakeSeleniumService.seleniumServiceChrome.{ getWebDriver, sendKeysToTxf, waitForAjaxResponse }
import org.scalatest._

class ChromeTest extends FunSpec with Matchers {

  describe("Chrome Test") {

    it("Can Search In Google") {

      val url: String = "https://www.google.com/"

      getWebDriver(url)

      waitForAjaxResponse(3500)

      sendKeysToTxf("q", "wire")

    }

  }

}
