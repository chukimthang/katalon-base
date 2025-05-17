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
String monthUsed = 'June 2025'
String electricityIndex = 100
String waterIndex = 30
String amountOfMembers = 3

WebUI.callTestCase(findTestCase('Common/Login'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl(baseUrl + 'meters/new')
WebUI.waitForPageLoad(30)
WebUI.verifyElementText(findTestObject('Object Repository/Meters/FormPage/formTitle'), 'Nhập chỉ số') 
TestObject monthInput = findTestObject('Object Repository/Meters/FormPage/inputMonthUsed')
WebUI.click(monthInput)
WebUI.sendKeys(monthInput, monthUsed)
WebUI.sendKeys(monthInput, Keys.chord(Keys.ENTER))  
WebUI.setText(findTestObject('Object Repository/Meters/FormPage/inputElectricityIndex'), electricityIndex)
WebUI.setText(findTestObject('Object Repository/Meters/FormPage/inputWaterIndex'), waterIndex)
WebUI.setText(findTestObject('Object Repository/Meters/FormPage/inputAmountOfMembers'), amountOfMembers)
WebUI.click(findTestObject('Object Repository/Meters/FormPage/btnSave'))
WebUI.delay(2)
WebUI.verifyTextPresent(electricityIndex, false)
WebUI.verifyTextPresent(waterIndex, false)



