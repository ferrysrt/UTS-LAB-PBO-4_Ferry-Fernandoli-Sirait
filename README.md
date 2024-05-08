# UTS-LAB-PBO-4_Ferry-Fernandoli-Sirait

Program yang ini adalah sebuah simulasi sederhana dari sistem perbankan yang menggunakan Command Line Interface (CLI). Program ini memungkinkan pengguna untuk melakukan beberapa operasi dasar seperti registrasi akun baru, mengirim uang, menyimpan uang, dan mengecek informasi rekening pribadi.

Registrasi Akun Baru: Pengguna diminta untuk memasukkan nama, alamat, nomor telepon, dan saldo awal untuk membuat akun baru. Setelah itu, program akan membuat akun baru dan menampilkannya.
Mengirim Uang: Pengguna diminta untuk memasukkan nomor akun pengirim, nomor akun penerima, dan jumlah uang yang akan ditransfer. Program akan memeriksa apakah saldo mencukupi dan melakukan transfer jika memenuhi syarat.
Menyimpan Uang: Pengguna diminta untuk memasukkan nomor akun dan jumlah uang yang akan disimpan. Program akan menambahkan jumlah uang ke saldo akun yang sesuai.
Mengecek Informasi Rekening: Pengguna diminta untuk memasukkan nomor akun untuk mengecek informasi rekening. Program akan menampilkan informasi seperti alamat, nomor telepon, saldo, dan tanggal registrasi akun.
Program ini menggunakan konsep dasar Object-Oriented Programming (OOP) dengan membuat kelas BankAccount untuk merepresentasikan akun bank. Setiap akun memiliki atribut seperti nama, alamat, nomor telepon, nomor akun, saldo, dan tanggal registrasi. Atribut-atribut ini diakses dan dimodifikasi melalui method-method yang telah didefinisikan di dalam kelas BankAccount.

Pada method generateNomorAkun(), nomor akun dibangkitkan secara acak untuk memastikan keunikan nomor akun setiap kali akun baru dibuat.

Program utama (main) berjalan dalam loop tak terbatas yang memanggil method showMenu() untuk menampilkan menu pilihan pengguna dan mengarahkan ke fungsi yang sesuai berdasarkan pilihan pengguna. Program akan berhenti hanya jika pengguna memilih opsi "Keluar" (pilihan 5).

contoh output dapat dilihat di file SSContoh
