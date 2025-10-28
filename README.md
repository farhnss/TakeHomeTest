# TakeHomeTest

Project ini merupakan otomatisasi pengujian form pada website [DemoQA - Practice Form](https://demoqa.com/automation-practice-form) menggunakan **Katalon Studio**.  
Pendekatan yang digunakan adalah **Data Driven Testing (DDT)**, di mana data pengujian diambil dari file Excel (`formdata1.xlsx`) berisi 8 skenario — baik valid maupun invalid test case.

Komponen	             Versi Minimum	                 Keterangan
Katalon Studio	   v8.6.0+	                   IDE utama automation test
Java JDK	         v11+	                       Runtime untuk Katalon
Chrome Browser	   v110+	                     Browser default untuk test
Excel File	       Microsoft Excel 2016+	     Untuk menyimpan data test
OS	Windows        10/11	                     Disarankan untuk kestabilan
Driver Chrome	     Otomatis dari Katalon	     Harus match dengan versi browser


## Cara Menjalankan Test

### 1️⃣ Buka Project
- Jalankan **Katalon Studio v8.x**
- Klik **File → Open Project...**
- Pilih folder project (`KatalonProject/`)

### 2️⃣ Hubungkan Data Excel
- Buka tab **Data Files → formdata1**
- Pastikan semua kolom terbaca (terutama `expectedResult`)

### 3️⃣ Jalankan Test Case
- Buka **Test Cases → TakeHomeTest**
- Klik kanan → **Run → Chrome**

### 4️⃣ (Opsional) Jalankan Semua Data via Test Suite
- Buka **Test Suites → FormTestSuite**
- Klik kanan → **Run → Chrome**
- Katalon akan menjalankan seluruh 8 skenario dari Excel secara otomatis.
