import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Pengunjung {// pake chatgpt, nanti di commit ulang change clean nya

    String nama;
    int uang;

    public Pengunjung(String nama, int uang) {
        this.nama = nama;
        this.uang = uang;

    }
}

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine();

            String[] arrayNama = sc.nextLine().split(",\\s*");
            String[] arrayUangStr = sc.nextLine().split(",\\s*");
            sc.close();

            PriorityQueue<Pengunjung> antrean = new PriorityQueue<>((a, b) -> b.uang - a.uang);

            for (int i = 0; i < n; i++) {
                String namaKini = arrayNama[i];
                int uangKini = Integer.parseInt(arrayUangStr[i]);

                if (namaKini.equals("Jevlin Misael Chandra")) {
                    throw new IllegalArgumentException(
                            "Nama 'Jevlin Misael Chandra' tidak diperbolehkan dalam antrean. (Cry about it)");
                } else {
                    antrean.offer(new Pengunjung(namaKini, uangKini));
                }
            }
            ArrayList<String> hasilAkhir = new ArrayList<>();

            while (!antrean.isEmpty()) {
                Pengunjung p = antrean.poll();
                hasilAkhir.add(p.nama);
            }
            System.out.println(hasilAkhir);
        }
    }
}