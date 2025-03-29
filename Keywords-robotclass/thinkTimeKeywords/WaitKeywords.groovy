package thinkTimeKeywords
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable



import com.kms.katalon.core.util.KeywordUtil
import java.time.Duration
import java.time.Instant

public class WaitKeywords {
	/**
	 * Smart wait with configurable precision
	 * @param delaySeconds  Total wait time in seconds (supports decimals)
	 * @param intervalMs    Check interval in milliseconds (default: 100)
	 * @param reason        Optional wait reason for logging
	 */
	@Keyword
	static void efficientWait(Number delaySeconds, long intervalMs = 100, String reason = "") {
		if (delaySeconds <= 0) return
		
		long totalMillis = (delaySeconds * 1000).toLong() // Convert to whole milliseconds
		long startTime = System.currentTimeMillis()
		String logPrefix = reason ? "[$reason] " : ""
		
		KeywordUtil.logInfo("${logPrefix}Starting wait (${delaySeconds}s)")
		
		while ((System.currentTimeMillis() - startTime) < totalMillis) {
			long remaining = totalMillis - (System.currentTimeMillis() - startTime)
			long currentInterval = Math.min(remaining, intervalMs)
			
			Thread.sleep(currentInterval) // Now using long instead of double
			
			// Progress logging for intervals >=500ms
			if (intervalMs >= 500 && remaining % 1000 == 0) {
				KeywordUtil.logInfo("${logPrefix}Remaining: ${remaining/1000}s")
			}
		}
		
		double actualWait = (System.currentTimeMillis() - startTime) / 1000.0
		KeywordUtil.logInfo("${logPrefix}Completed (Actual: ${actualWait.round(2)}s)")
	}

	/**
	 * Random delay within range
	 * @param minSeconds  Minimum wait time (supports decimals)
	 * @param maxSeconds  Maximum wait time (supports decimals)
	 */
	@Keyword
	static void randomWait(Number minSeconds, Number maxSeconds) {
		double randomDelay = minSeconds.toDouble() + Math.random() * (maxSeconds.toDouble() - minSeconds.toDouble())
		efficientWait(randomDelay, 500, "Random think time")
	}
}