package com.fragnostic.selenium.service

import com.fragnostic.conf.service.CakeServiceConf
import com.fragnostic.selenium.service.api.SeleniumServiceApi
import com.fragnostic.selenium.service.impl.SeleniumServiceImpl
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

object CakeSeleniumService {

  lazy val seleniumServiceChrome = seleniumServiceChromeImpl.seleniumServiceApi

  lazy val seleniumServiceFirefox = seleniumServiceFirefoxImpl.seleniumServiceApi

  lazy val seleniumServiceFirefoxImpl: SeleniumServiceApi = new SeleniumServiceImpl {
    override val webDriver: WebDriver = CakeServiceConf.confService.getConf("WEBDRIVER_GECKO_DRIVER") map (driverPath => {
      System.setProperty("webdriver.gecko.driver", driverPath)
      new FirefoxDriver()
    }) getOrElse (throw new IllegalStateException("cake.service.error.on.retrieve.gecko.driver"))
  }

  lazy val seleniumServiceChromeImpl: SeleniumServiceApi = new SeleniumServiceImpl {
    override val webDriver: WebDriver = CakeServiceConf.confService.getConf("WEBDRIVER_CHROME_DRIVER") map (driverPath => {
      System.setProperty("webdriver.chrome.driver", driverPath)
      new ChromeDriver()
    }) getOrElse (throw new IllegalStateException("cake.service.error.on.retrieve.chrome.driver"))
  }

}
