import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class Gibekkk {

    static class Surat {
        String nama;
        int durasi;
        int prioritas;
        int waktuSampai;

        public Surat(String nama, int durasi, int prioritas) {
            this.nama = nama;
            this.durasi = durasi;
            this.prioritas = prioritas;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();

            PriorityQueue<Surat> pending = new PriorityQueue<>((a, b) -> a.prioritas - b.prioritas);
            List<Surat> queued = new ArrayList<>();
            List<Surat> sent = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String nama = sc.next();
                int durasi = sc.nextInt();
                int prioritas = sc.nextInt();
                pending.offer(new Surat(nama, durasi, prioritas));
            }

            int[] waktuKurirBebas = new int[2];
            waktuKurirBebas[0] = 1;
            waktuKurirBebas[1] = 1;

            int waktuKini = 1;

            while (sent.size() < n) {
                boolean adaPerubahanState = false;

                for (int i = queued.size() - 1; i >= 0; i--) {
                    Surat s = queued.get(i);
                    if (waktuKini == s.waktuSampai) {
                        queued.remove(i);
                        sent.add(s);
                        adaPerubahanState = true;
                    }
                }

                for (int i = 0; i < 2; i++) {
                    if (waktuKurirBebas[i] <= waktuKini && !pending.isEmpty()) {
                        Surat s = pending.poll();
                        s.waktuSampai = waktuKini + s.durasi;
                        queued.add(s);
                        waktuKurirBebas[i] = waktuKini + (2 * s.durasi);
                        adaPerubahanState = true;
                    }
                }

                if (adaPerubahanState) {
                    List<String> listPending = new ArrayList<>();
                    PriorityQueue<Surat> tempPending = new PriorityQueue<>((a, b) -> a.prioritas - b.prioritas);
                    tempPending.addAll(pending);
                    while (!tempPending.isEmpty()) {
                        listPending.add(tempPending.poll().nama);
                    }
                    
                    List<String> listQueued = new ArrayList<>();
                    for (Surat s : queued) {
                        listQueued.add(s.nama);
                    }
                    
                    List<String> listSent = new ArrayList<>();
                    for (Surat s : sent) {
                        listSent.add(s.nama);
                    }

                    String stringPending = String.join(" ", listPending);
                    String stringQueued = String.join(" ", listQueued);
                    String stringSent = String.join(" ", listSent);
                    
                    System.out.println(waktuKini + " " + 
                        (stringPending.isEmpty() ? "" : stringPending + " ") + "| " + 
                        (stringQueued.isEmpty() ? "" : stringQueued + " ") + "| " + 
                        (stringSent.isEmpty() ? "" : stringSent));
                }

                waktuKini++;
            }
        }
        sc.close();
    }
}