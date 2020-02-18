package com.fragnostic.selenium.service

import java.util.concurrent.TimeUnit

import com.fragnostic.conf.service.CakeServiceConf
import com.fragnostic.selenium.service.api.SeleniumServiceApi
import com.fragnostic.selenium.service.impl.SeleniumServiceImpl
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

object CakeSeleniumService {

  lazy val seleniumServiceChrome = seleniumServiceChromeImpl.seleniumServiceApi

  lazy val seleniumServiceFirefox = seleniumServiceFirefoxImpl.seleniumServiceApi

  private def manageTimeoutsImplicitlyWait(webDriver: WebDriver): WebDriver = {

    CakeServiceConf.confService.getConf("WEBDRIVER_TIMEOUTS_IMPLICITLY_WAIT") fold(
      error => throw new IllegalStateException("cake.service.error.on.retrieve.chrome.driver"),
      timeout => {
        webDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.MILLISECONDS)
        webDriver
      }

    )


  }

  lazy val seleniumServiceFirefoxImpl: SeleniumServiceApi = new SeleniumServiceImpl {
    override val webDriver: WebDriver = CakeServiceConf.confService.getConf("WEBDRIVER_GECKO_DRIVER") map (driverPath => {
      System.setProperty("webdriver.gecko.driver", driverPath)
      manageTimeoutsImplicitlyWait(new FirefoxDriver())
    }) getOrElse (throw new IllegalStateException("cake.service.error.on.retrieve.gecko.driver"))
  }

  lazy val seleniumServiceChromeImpl: SeleniumServiceApi = new SeleniumServiceImpl {
    override val webDriver: WebDriver = CakeServiceConf.confService.getConf("WEBDRIVER_CHROME_DRIVER") map (driverPath => {
      System.setProperty("webdriver.chrome.driver", driverPath)
      manageTimeoutsImplicitlyWait(new ChromeDriver())
    }) getOrElse (throw new IllegalStateException("cake.service.error.on.retrieve.chrome.driver"))
  }

}
