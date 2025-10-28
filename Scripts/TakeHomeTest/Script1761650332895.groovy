import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

// Ambil data dari Excel
def testData = findTestData('Data Files/formdata1')

// Loop untuk setiap baris data
for (def index : (1..testData.getRowNumbers())) {
	
	WebUI.comment("===== Menjalankan Test ke-${index} : ${testData.getValue('expectedResult', index)} =====")

	WebUI.openBrowser('')
	WebUI.navigateToUrl('https://demoqa.com/automation-practice-form')
	WebUI.maximizeWindow()

	// Input nama depan (jika ada)
	def firstName = testData.getValue('firstName', index)
	if (firstName != null && firstName != '') {
		WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Name_firstName'), firstName)
}}

	// Input nama belakang (boleh kosong)
	def lastName = testData.getValue('lastName', index)
	if (lastName != null && lastName != '') {
		WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Name_lastName'), lastName)
}

	// Input email
	def email = testData.getValue('email', index)
	if (email != null && email != '') {
		WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Email_userEmail'), email)
}

	// Pilih gender jika tersedia
	def gender = testData.getValue('gender', index)
	if (gender == 'Male') {
		WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/label_Male_custom-control-label'))
	} else if (gender == 'Female') {
		WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/label_Female_custom-control-label'))
	} else if (gender == 'Other') {
		WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/label_Gender_custom-control-label'))
}

	// Nomor HP
	def mobile = testData.getValue('mobile', index)
	if (mobile != null && mobile != '') {
		WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_(10 Digits)_userNumber'), mobile)
}

	// Date of Birth
	def birthDate = testData.getValue('birthDate', index)
	if (birthDate != null && birthDate != '') {
	WebUI.sendKeys(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Date of Birth_dateOfBirthInput'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Date of Birth_dateOfBirthInput'), birthDate)
	WebUI.sendKeys(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Date of Birth_dateOfBirthInput'), Keys.chord(Keys.ENTER))
}
	
	// Subject
	def subject = testData.getValue('subject', index)
	if (subject != null && subject != '') {
		WebUI.setText(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Subjects_subjectsInput'), subject)
		WebUI.delay(0.5)
		WebUI.sendKeys(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_Subjects_subjectsInput'), '\n')
}

// Hobby
	def hobby = testData.getValue('hobby', index)
	if (hobby != null && hobby != '') {
		WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Sports_custom-control custom-checkbox c_a4979b'))
}

// Upload file
def picture = testData.getValue('picture', index)
def filePath = "C:\\TestData\\" + picture
File file = new File(filePath)
if(file.exists()) {
    WebUI.uploadFile(findTestObject('Object Repository/New Folder/Page_DEMOQA/input_UploadPicture_uploadPicture'), filePath)
} else {
    WebUI.comment("⚠️ File tidak ditemukan: " + filePath)
}

// State & City (hardcoded default)
def state = testData.getValue('state', index)
def city = testData.getValue('city', index)
if(state != null && state != '' && city != null && city != '') {
    WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Select State_css-1gtu0rj-indicatorContainer'))
    WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Select State_react-select-3-option-0'))
    WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Select City_css-1gtu0rj-indicatorContainer'))
    WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/div_Select City_react-select-4-option-0'))
}

// Submit
WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/button_Submit'))

// Assertion
def expectedResult = testData.getValue('expectedResult', index)
if(expectedResult.contains('Success')) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/New Folder/Page_DEMOQA/modal_ThankYou'), 10)
    WebUI.comment("✅ Form berhasil disubmit untuk data valid.")
    WebUI.click(findTestObject('Object Repository/New Folder/Page_DEMOQA/button_Close'))
} else {
    boolean isModalPresent = WebUI.verifyElementNotPresent(findTestObject('Object Repository/New Folder/Page_DEMOQA/modal_ThankYou'), 3, FailureHandling.OPTIONAL)
    WebUI.comment("⚠️ Diharapkan error muncul karena: " + expectedResult)
    assert isModalPresent == true : "Modal tidak seharusnya muncul untuk data invalid."
}

// Close browser
WebUI.closeBrowser()
