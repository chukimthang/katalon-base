package common

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

public class LoginHelper {
	static void login(String email, String password) {
		def baseUrl = GlobalVariable.base_url
		try {
			WebUI.navigateToUrl(baseUrl)
			WebUI.maximizeWindow()
		} catch(BrowserNotOpenedException){
			WebUI.openBrowser(baseUrl)
			WebUI.maximizeWindow()
		}
		sleep(1000)
		WebUI.setText(findTestObject('Object Repository/Login/input_Email_useremail'), email)
		WebUI.setText(findTestObject('Object Repository/Login/input_Password_userpassword'), password)
		WebUI.click(findTestObject('Object Repository/Login/input_Password_commit'))
		sleep(1000)
		WebUI.verifyElementText(findTestObject('Object Repository/Login/h1_Bng iu khin'), 'Bảng điều khiển')
	}
}
