import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import roboKeywords.RobotKeywords as RobotKeywords
import thinkTimeKeywords.WaitKeywords as WaitKeywords

// Fixed wait with logging
//WaitKeywords.efficientWait(2.5, 200, "Page load")
// Random think time (between 1-3 seconds)
//WaitKeywords.randomWait(1, 3)
// Simple millisecond wait (no logging)
//Thread.sleep(500)  // Fallback for simple cases


WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.ignou.ac.in/')
WaitKeywords.efficientWait(2.5, 200, "Page load")
//WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('ignou-obj/closePopupBtn'))
WaitKeywords.randomWait(1, 3)

WebUI.click(findTestObject('ignou-obj/clickOnStudentservice'))
WaitKeywords.efficientWait(2.5, 200, "Page load")

WebUI.click(findTestObject('ignou-obj/clickOnAdmission'))
WaitKeywords.randomWait(2, 4)

WebUI.click(findTestObject('ignou-obj/applyForOnlineProgram'))
WaitKeywords.randomWait(2, 6)

WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('ignou-obj/newTabRegistrationBtn'))
WaitKeywords.efficientWait(2.5, 200, "Page load")
//WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('ignou-obj/appName'), 'vijeshv')
Thread.sleep(500)

RobotKeywords.pressKeyMultipleTimes('TAB', 1)
RobotKeywords.typeAdvancedString("Vijesh V", 100)

RobotKeywords.pressKeyMultipleTimes('TAB', 1)
RobotKeywords.typeAdvancedString("vijesh@gmail.com", 100)

RobotKeywords.pressKeyMultipleTimes('TAB', 1)
RobotKeywords.typeAdvancedString("vijesh@gmail.com", 100)

RobotKeywords.pressKeyMultipleTimes('TAB', 1)
RobotKeywords.typeAdvancedString("Pass@123", 100)

RobotKeywords.pressKeyMultipleTimes('TAB', 1)
RobotKeywords.typeAdvancedString("Pass@123", 100)

RobotKeywords.pressKeyMultipleTimes('TAB', 1)
RobotKeywords.typeAdvancedString("87878787878", 100)

RobotKeywords.pressKeyMultipleTimes('TAB', 1)
RobotKeywords.typeAdvancedString("87878787878", 100)


