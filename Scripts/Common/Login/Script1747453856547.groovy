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

def baseUrl = GlobalVariable.base_url
def email = GlobalVariable.email
def password = GlobalVariable.password

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
