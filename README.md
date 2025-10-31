# TakeHomeTest

Project ini merupakan otomatisasi pengujian form pada website [DemoQA - Practice Form](https://demoqa.com/automation-practice-form) menggunakan Katalon Studio.  
Pendekatan yang digunakan adalah Data Driven Testing (DDT), di mana data pengujian diambil dari file Excel (`formdata1.xlsx`) berisi 8 skenario — baik valid maupun invalid test case.

Tools yang digunakan untuk automation testing adalah Katalon Studio versi 8.6.0 atau lebih baru sebagai IDE utama, dengan dukungan Java JDK minimal versi 11 sebagai runtime. Pengujian dijalankan menggunakan Google Chrome versi 110 ke atas sebagai browser default, dengan Chrome Driver yang otomatis disesuaikan oleh Katalon. Untuk pengujian berbasis data, digunakan Microsoft Excel 2016 atau versi terbaru sebagai penyimpanan data uji. Sistem operasi yang digunakan adalah Windows 10 atau 11 karena memberikan kestabilan dan kompatibilitas terbaik selama proses pengujian.


## Cara Menjalankan Test

1️⃣ Buka Project
- Jalankan Katalon Studio
- Klik **File → Open Project
- Pilih folder project 

2️⃣ Hubungkan Data Excel
- Buka tab Data Files → formdata1
- Pastikan semua kolom terbaca

3️⃣ Jalankan Test Case
- Buka Test Cases → TakeHomeTest
- Jalankan Test Uji 
