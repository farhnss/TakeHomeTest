import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement

// === STEP 1: Setup Awal ===
WebUI.openBrowser('')
WebUI.navigateToUrl('https://demoqa.com/automation-practice-form')
WebUI.maximizeWindow()

def data = findTestData('formdata')
int totalData = data.getRowNumbers()

WebUI.comment("=== MULAI PENGUJIAN DEMOQA ===")
WebUI.comment("Total data yang akan diuji: ${totalData}")

// === STEP 2: Looping Tiap Data ===
for (int index = 1; index <= totalData; index++) {
    WebUI.comment("\n---------------------------------------------")
    WebUI.comment("Uji data ke-${index}")

    try {
        WebUI.refresh()
        WebUI.delay(2)

        // === INPUT BASIC INFO ===
        WebUI.setText(findTestObject('Form/Input_FirstName'), data.getValue('firstName', index))
        WebUI.setText(findTestObject('Form/Input_LastName'), data.getValue('lastName', index))
        WebUI.setText(findTestObject('Form/Input_Email'), data.getValue('Email', index))
        WebUI.setText(findTestObject('Form/Input_Mobile'), data.getValue('Mobile', index))
        WebUI.setText(findTestObject('Form/Textarea_Address'), data.getValue('address', index))

        // === GENDER (React RadioButton pakai JS click) ===
        def gender = data.getValue('Gender', index)
        if (gender != '') {
            WebUI.executeJavaScript("document.querySelector('label[for=\"gender-radio-1\"]').click()", null)
            if (gender.equalsIgnoreCase('Female'))
                WebUI.executeJavaScript("document.querySelector('label[for=\"gender-radio-2\"]').click()", null)
            if (gender.equalsIgnoreCase('Other'))
                WebUI.executeJavaScript("document.querySelector('label[for=\"gender-radio-3\"]').click()", null)
        }

        // === SUBJECT (autocomplete React) ===
        def subject = data.getValue('Subject', index)
        if (subject != '') {
            WebUI.setText(findTestObject('Form/Input_Subject'), subject)
            WebUI.sendKeys(findTestObject('Form/Input_Subject'), Keys.chord(Keys.ENTER))
        }

        // === HOBBIES (React checkbox pakai JS click) ===
        def hobby = data.getValue('hobbies', index)
        if (hobby.contains('Sports'))
            WebUI.executeJavaScript("document.querySelector('label[for=\"hobbies-checkbox-1\"]').click()", null)
        if (hobby.contains('Reading'))
            WebUI.executeJavaScript("document.querySelector('label[for=\"hobbies-checkbox-2\"]').click()", null)
        if (hobby.contains('Music'))
            WebUI.executeJavaScript("document.querySelector('label[for=\"hobbies-checkbox-3\"]').click()", null)

        // === UPLOAD PHOTO ===
        def photoFile = data.getValue('photos', index)
        if (photoFile != '') {
            String photoPath = "C:\\Users\\Farhan\\Documents\\" + photoFile
            WebUI.uploadFile(findTestObject('Form/Upload_Photo'), photoPath)
        }

        // === STATE (React dropdown pakai sendKeys + ENTER) ===
        def state = data.getValue('State', index)
        if (state != '') {
            WebUI.scrollToElement(findTestObject('Form/Dropdown_State'), 5)
            WebUI.click(findTestObject('Form/Dropdown_State'))
            WebUI.sendKeys(findTestObject('Form/Dropdown_State'), state)
            WebUI.sendKeys(findTestObject('Form/Dropdown_State'), Keys.chord(Keys.ENTER))
        }

        // === CITY (React dropdown) ===
        def city = data.getValue('City', index)
        if (city != '') {
            WebUI.click(findTestObject('Form/Dropdown_City'))
            WebUI.sendKeys(findTestObject('Form/Dropdown_City'), city)
            WebUI.sendKeys(findTestObject('Form/Dropdown_City'), Keys.chord(Keys.ENTER))
        }

        // === SUBMIT FORM ===
        WebUI.scrollToElement(findTestObject('Form/Button_Submit'), 5)
        WebUI.delay(1)
        WebUI.click(findTestObject('Form/Button_Submit'))
        WebUI.delay(2)

        // === VERIFIKASI POPUP ===
        boolean popup = WebUI.verifyTextPresent('Thanks for submitting the form', false, FailureHandling.OPTIONAL)
        if (popup) {
            WebUI.comment("Data ke-${index}: Form berhasil disubmit.")
        } else {
            WebUI.comment("Data ke-${index}: Gagal submit atau popup tidak muncul.")
        }

        // === CLOSE MODAL ===
        if (WebUI.verifyElementPresent(findTestObject('xpath=//button[text()="Close"]'), 5, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('xpath=//button[text()="Close"]'))
        }

    } catch (Exception e) {
        WebUI.comment("Error pada data ke-${index}: ${e.message}")
        continue
    }
}

WebUI.comment("=== Semua pengujian selesai ===")
WebUI.closeBrowser()
