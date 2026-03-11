import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Question3 {
    
    static class Mahasiswa {
        String nama;
        int kesempatan;

        public Mahasiswa(String nama, int kesempatan) {
            this.nama = nama;
            this.kesempatan = kesempatan;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            
            String[] namaArray = new String[n];
            for (int i = 0; i < n; i++) {
                namaArray[i] = sc.next();
            }

            Queue<Mahasiswa> antrean = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                int chance = sc.nextInt();
                antrean.offer(new Mahasiswa(namaArray[i], chance));
            }

            while (!antrean.isEmpty()) {
                Mahasiswa mhs = antrean.poll();
                
                mhs.kesempatan = mhs.kesempatan - 1;

                if (mhs.kesempatan > 0) {
                    System.out.println(mhs.nama + "|Try Again|" + mhs.kesempatan);
                    antrean.offer(mhs);
                } else {
                    System.out.println(mhs.nama + "|Get Out|0");
                }
            }
        }
        
        sc.close();
    }
}