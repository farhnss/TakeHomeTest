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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://demoqa.com/automation-practice-form')

WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Name_firstName'), 'Farhan')

WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Name_lastName'), 'Hakim')

WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Email_userEmail'), 'fardan1206@gmail.com')

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/label_Gender_custom-control-label'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/label_Male_custom-control-label'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/label_Female_custom-control-label'))

WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_(10 Digits)_userNumber'), '2331244212')

WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Date of Birth_dateOfBirthInput'), '28 Oct 2025')

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Date of Birth_dateOfBirthInput'))

WebUI.selectOptionByValue(findTestObject('Object Repository/New Folder/Page_DEMOQA/select_October 2025_react-datepicker__year-select'), 
    '2003', true)

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Sa_react-datepicker__day react-datepick_843ce5'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Subjects_subjects-auto-complete__value-_d244cf'))

WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Subjects_subjectsInput'), 'e')

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_e_react-select-2-option-0'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/label_Hobbies_custom-control-label'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Sports_custom-control custom-checkbox c_a4979b'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Picture_form-file'))

WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/textarea_Current Address_currentAddress'), 'delhi street')

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Select State_css-1gtu0rj-indicatorContainer'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Select State_react-select-3-option-0'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_NCR_css-1wa3eu0-placeholder'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Select City_react-select-4-option-0'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/button_Delhi_submit'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/td'))

WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/button_NCR Delhi_closeLargeModal'))

WebUI.closeBrowser()

