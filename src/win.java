import java.util.*;

class Mahasiswa {
    String nama, nim, jurusan;

    Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }
}

class Universitas {
    String namaUniversitas;
    ArrayList<Mahasiswa> daftarMahasiswa;

    Universitas(String namaUniversitas) {
        this.namaUniversitas = namaUniversitas;
        this.daftarMahasiswa = new ArrayList<>();
    }

    void tambahMahasiswa(Mahasiswa mhs) {
        daftarMahasiswa.add(mhs);
    }

    void tampilkanDataMahasiswa() {
        System.out.println("Universitas " + namaUniversitas);
        for (Mahasiswa mhs : daftarMahasiswa) {
            System.out.println("Nama : " + mhs.nama + ", NIM : " + mhs.nim + ", Jurusan : " + mhs.jurusan);
        }
    }
}

public class win {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Universitas umm = new Universitas("Universitas Muhammadiyah Malang");
        int pilihan;
        do {
            System.out.println("\nMenu : 1. Tambah Data Mahasiswa 2. Tampilkan Data Mahasiswa 3. Keluar");
            System.out.print("Pilihan Anda : ");
            pilihan = sc.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama mahasiswa : ");
                    sc.nextLine();
                    String nama = sc.nextLine();
                    System.out.print("Masukkan NIM mahasiswa : ");
                    String nim = sc.nextLine();
                    while (nim.length() != 3) {
                        System.out.println("Masukkan 3 nim terakhir anda!!!. tidak usah 15 digit. Okee?");
                        System.out.println("Masukkan NIM mahasiswa : ");
                        nim = sc.nextLine();
                    }
                    System.out.print("Masukkan jurusan mahasiswa : ");
                    String jurusan = sc.nextLine();
                    umm.tambahMahasiswa(new Mahasiswa(nama, nim, jurusan));
                    System.out.println("Data mahasiswa berhasil ditambahkan.");
                    break;
                case 2:
                    umm.tampilkanDataMahasiswa();
                    break;
                case 3:
                    System.out.println("Terima Kasih");
                    break;
                    /* default berfungsi hanya jika tidak ada ekspresi case sebelumnya yang cocok
                     dengan nilai yang dievaluasi, maka akan mengeluarkan output Pilihan tidak valid
                     */
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);
        sc.close();
    }
}