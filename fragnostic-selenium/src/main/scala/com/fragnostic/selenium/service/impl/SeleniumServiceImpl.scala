package com.fragnostic.selenium.service.impl

import com.fragnostic.selenium.service.agnostic.DriverAgnostic
import com.fragnostic.selenium.service.api.SeleniumServiceApi
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{ By, WebDriver, WebElement }

trait SeleniumServiceImpl extends SeleniumServiceApi with DriverAgnostic {

  def seleniumServiceApi = new DefaultSeleniumService

  class DefaultSeleniumService extends SeleniumServiceApi {

    def getWebDriver(url: String): WebDriver = {
      webDriver.get(url)
      webDriver
    }

    def waitForAjaxResponse(amount: Long): Unit =
      Thread.sleep(amount)

    def findById(id: String): WebElement =
      webDriver.findElement(By.id(id))

    def findByName(id: String): WebElement =
      webDriver.findElement(By.name(id))

    def click(id: String): Unit =
      findById(id).click()

    def sendKeysToTxf(id: String, keys: String): Unit = {
      val webElement: WebElement = findById(id)
      webElement.clear()
      webElement.sendKeys(keys)
    }

    def getSelect(id: String): Select =
      new Select(findById(id))

    def selectOptionByValue(id: String, value: String): Unit =
      getSelect(id).selectByValue(value)

    def selectOptionByIndex(id: String, index: Int): Unit =
      getSelect(id).selectByIndex(index)

    def quit: Unit =
      webDriver.quit()

  }

}
