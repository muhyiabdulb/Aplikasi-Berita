Aplikasi Berita

Aplikasi ini merupakan aplikasi sederhana yang menyajikan berbagai informasi dari seluruh dunia. Pengguna dapat melihat daftar berita dan detailnya tanpa perlu melakukan proses login atau pendaftaran untuk mengakses aplikasi.

Sumber API: https://ok.surf/swagger

Endpoint API: https://ok.surf/api/v1/cors/news-feed

.
.
.

Penjelasan Kode Aplikasi

Kode ini membuat tampilan splash screen selama 2 detik, lalu secara otomatis berpindah ke halaman utama (MainActivity). Tampilan splash hanya muncul satu kali saat aplikasi dibuka.
![image](https://github.com/user-attachments/assets/a52b34b6-e2be-4719-809c-bf79deebe7c4)

Kode ini membuat aplikasi berita yang:

Menampilkan loading animasi shimmer saat data sedang dimuat.

Mengambil data berita dari API.

Menampilkan data berita dalam daftar menggunakan RecyclerView.

Menangani error saat gagal mengambil atau memproses data.

Cocok untuk aplikasi ringan tanpa login, yang hanya menyajikan informasi secara cepat dan responsif kepada pengguna.
![image](https://github.com/user-attachments/assets/b543932e-11cb-4392-92ae-bb190a3c064f)

Kode ini menampilkan halaman berita secara lengkap melalui WebView.
Fitur-fitur utama:

Toolbar dengan judul dan tombol back.

WebView untuk menampilkan konten berita dari URL yang diberikan.

Navigasi yang ramah pengguna.

Activity ini sangat berguna sebagai halaman detail berita dalam aplikasi yang menyajikan daftar berita dari berbagai sumber.
![image](https://github.com/user-attachments/assets/d9583a6c-889b-452f-b9c6-9bfd2e7589a4)

Model ini berfungsi sebagai wadah data (data container) yang memungkinkan informasi berita disimpan dan digunakan dalam tampilan, seperti pada adapter RecyclerView.
Struktur ini memudahkan proses parsing data dari API dan penyajian data pada UI aplikasi.
![image](https://github.com/user-attachments/assets/e1b6dae0-bdbe-47e3-bf4f-28a15ec6d51f)

Kelas BeritaAdapter ini bertugas sebagai penghubung antara data berita dan tampilan daftar dalam RecyclerView, sekaligus menyediakan interaksi pengguna ketika item berita ditekan untuk melihat detailnya di halaman selanjutnya.
![image](https://github.com/user-attachments/assets/7778bf1c-6ea4-4d6f-aa99-201ec77feff2)

File ini merupakan sebuah layout untuk tampilan berbasis RelativeLayout yang berfungsi untuk menampilkan logo aplikasi di tengah layar,digunakan sebagai tampilan awal atau splash screen.
![image](https://github.com/user-attachments/assets/f8f2a5e9-6fc5-4163-b6e5-86b2a0d86f19)

Layout ini dirancang untuk:

Menampilkan Toolbar di bagian atas.

Menampilkan shimmer loading view saat data berita sedang dimuat.

Setelah data dimuat, menampilkan RecyclerView berisi daftar berita.
![image](https://github.com/user-attachments/assets/b2bc5b76-097a-4b8f-8793-0f4de5c18a4e)

Menampilkan:

Toolbar (judul & tombol back).

WebView untuk membuka URL berita.
![image](https://github.com/user-attachments/assets/0f8e3647-9d8e-4136-8ccd-4c012b3a0bc6)

Layout XML ini adalah item berita yang akan digunakan di RecyclerView pada aplikasi berita
![image](https://github.com/user-attachments/assets/e459641c-6960-4901-abfb-246f8b727773)

Menampilkan placeholder efek shimmer sebelum data berita tampil secara penuh.
![image](https://github.com/user-attachments/assets/0613e0a6-e27d-41b2-b8f5-c2db94db81a9)

File XML hanya mendefinisikan dua warna
<img width="1512" alt="Screenshot 2025-05-17 at 11 47 05" src="https://github.com/user-attachments/assets/14d654ac-ae03-4871-88e5-4e7fe629b91b" />

Untuk mendefinisikan nama aplikasi
<img width="1512" alt="Screenshot 2025-05-17 at 11 47 12" src="https://github.com/user-attachments/assets/000a208c-ffff-488e-af05-d4f9df37790a" />

Tema utama (AppTheme) diwariskan dari Theme.AppCompat.Light.DarkActionBar yang berarti tema terang dengan ActionBar gelap.

Warna utama toolbar diatur melalui:

colorPrimary

colorPrimaryDark

colorAccent

Ikon toolbar dan teks judul diatur berwarna putih agar kontras dengan latar toolbar yang gelap:

colorControlNormal untuk warna ikon (putih)

android:textColorPrimary untuk warna teks (putih)
<img width="1512" alt="Screenshot 2025-05-17 at 11 47 21" src="https://github.com/user-attachments/assets/6d91c806-92e5-4f1d-a454-97a2415c9b75" />

.
.
.

Screenshoot Aplikasi

Icon Aplikasi 
<img width="1512" alt="Screenshot 2025-05-17 at 10 25 01" src="https://github.com/user-attachments/assets/552b3510-793f-4e0c-97c2-456360a7526c" />

Splash Screen
<img width="1512" alt="Screenshot 2025-05-17 at 10 27 03" src="https://github.com/user-attachments/assets/3caf3036-011c-46db-a5e0-eb3c9a7d59f9" />

Loading Shimmber List Berita
<img width="1512" alt="Screenshot 2025-05-17 at 10 27 17" src="https://github.com/user-attachments/assets/3498e466-0f37-46b7-b8b8-07f68f593e27" />

List Berita
<img width="1511" alt="Screenshot 2025-05-17 at 10 22 42" src="https://github.com/user-attachments/assets/ec9ce4aa-1add-4a84-87b4-6eef062c29ae" />

Detail Berita
<img width="1512" alt="Screenshot 2025-05-17 at 10 22 53" src="https://github.com/user-attachments/assets/1e40cc47-305d-448b-8f72-dfa2168220df" />


