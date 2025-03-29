package roboKeywords
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import java.awt.Robot
import java.awt.event.KeyEvent


class RobotKeywords {
	private static Robot robot = new Robot()
	
		/**
		 * Presses a key multiple times with a delay between presses.
		 * @param keyName  Key to press (e.g., "TAB", "ENTER", "DOWN").
		 * @param times    Number of times to press the key.
		 * @param delayMs  Delay between presses (milliseconds).
		 */
		@Keyword
		static void pressKeyMultipleTimes(String keyName, int times, int delayMs = 100) {
			// Convert key name (e.g., "TAB") to KeyEvent constant (e.g., VK_TAB)
			int keyCode = KeyEvent.getField("VK_${keyName.toUpperCase()}").get(null) as int
	
			// Press the key 'times' times
			times.times { i ->
				robot.keyPress(keyCode)
				robot.keyRelease(keyCode)
				Thread.sleep(delayMs)
			}
		}
		@Keyword
    static void typeAdvancedString(String text, int delayMs = 50) {
        text.each { String character ->
            try {
                // Handle space separately
                if (character == " ") {
                    robot.keyPress(KeyEvent.VK_SPACE)
                    robot.keyRelease(KeyEvent.VK_SPACE)
                }
                // Handle dot (period)
                else if (character == ".") {
                    robot.keyPress(KeyEvent.VK_PERIOD)
                    robot.keyRelease(KeyEvent.VK_PERIOD)
                }
                // Handle uppercase letters (A-Z)
                else if (character == character.toUpperCase() && character.matches("[A-Z]")) {
                    robot.keyPress(KeyEvent.VK_SHIFT)
                    pressBasicKey(character)
                    robot.keyRelease(KeyEvent.VK_SHIFT)
                }
                // Handle special characters requiring SHIFT
                else if (isShiftCharacter(character)) {
                    robot.keyPress(KeyEvent.VK_SHIFT)
                    pressMappedSymbol(character)
                    robot.keyRelease(KeyEvent.VK_SHIFT)
                }
                // Default case (lowercase letters, numbers)
                else {
                    pressBasicKey(character)
                }
                Thread.sleep(delayMs)
            } catch (Exception e) {
                KeywordUtil.logInfo("Failed to type character: $character")
            }
        }
    }
    
    /** Handles basic keys (a-z, 0-9) */
    private static void pressBasicKey(String key) {
        String upperKey = key.toUpperCase()
        int keyCode = KeyEvent.getField("VK_$upperKey").get(null)
        robot.keyPress(keyCode)
        robot.keyRelease(keyCode)
    }
    
    /** Checks if character requires SHIFT */
    private static boolean isShiftCharacter(String character) {
        return character.matches(/[!@#$%^&*()_+{}|:"<>?~]/)
    }
    
    /** Handles special symbol mapping */
    private static void pressMappedSymbol(String symbol) {
        switch(symbol) {
            case '!': pressBasicKey("1"); break
            case '@': pressBasicKey("2"); break
            case '#': pressBasicKey("3"); break
            case '$': pressBasicKey("4"); break
            case '%': pressBasicKey("5"); break
            case '^': pressBasicKey("6"); break
            case '&': pressBasicKey("7"); break
            case '*': pressBasicKey("8"); break
            case '(': pressBasicKey("9"); break
            case ')': pressBasicKey("0"); break
            case '_': pressBasicKey("-"); break
            case '+': pressBasicKey("="); break
            // Add more symbols as needed
            default: 
                KeywordUtil.logInfo("Unsupported symbol: $symbol")
        	}
    	}
	}

	

	