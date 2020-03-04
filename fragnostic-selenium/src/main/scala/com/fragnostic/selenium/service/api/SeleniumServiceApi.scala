package com.fragnostic.selenium.service.api

import org.openqa.selenium.{ WebDriver, WebElement }

trait SeleniumServiceApi {

  def seleniumServiceApi: SeleniumServiceApi

  trait SeleniumServiceApi {

    def getWebDriver: WebDriver

    def getWebDriver(url: String): WebDriver

    def findById(id: String): WebElement

    def findByName(id: String): WebElement

    def click(id: String): Unit

    def sendKeysToTxf(id: String, keys: String): Unit

    def selectOptionByValue(id: String, value: String): Unit

    def selectOptionByIndex(id: String, index: Int): Unit

    def quit(): Unit

    def waitForAjaxResponse(amount: Long): Unit

  }

}
