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

WebUI.callTestCase(findTestCase('Common/Login'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl(baseUrl + 'general_setting')
WebUI.waitForPageLoad(30)
WebUI.setText(findTestObject('Object Repository/GeneralSetting/inputDescription'), 'ngõ 376, đường Bưởi, Hà Nội')
WebUI.click(findTestObject('Object Repository/GeneralSetting/btnUpdate'))
TestObject flashMessage = findTestObject('Object Repository/Common/flashMessage')
boolean isVisible = WebUI.waitForElementVisible(flashMessage, 5, FailureHandling.OPTIONAL)
if (isVisible) {
	WebUI.verifyElementText(flashMessage, 'Cập nhật thành công')
} else {
	WebUI.comment('Flash message không hiển thị')
}
