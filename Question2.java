import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Collections;

public class Question2 {// bantuan chatgpt untuk strukturnya karena udah mepet deadline
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Selama masih ada input grup baru
        while (sc.hasNextInt()) {
            int n = sc.nextInt(); // Jumlah operasi dalam grup ini

            // 1. Siapkan ketiga wadah
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            // Ingat jebakan Max-Heap!
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            // 2. Siapkan status praduga tak bersalah (semua true di awal)
            boolean isStack = true;
            boolean isQueue = true;
            boolean isPQ = true;

            // 3. Mulai simulasi
            for (int i = 0; i < n; i++) {
                int tipe = sc.nextInt();
                int nilai = sc.nextInt();

                if (tipe == 1) {
                    stack.push(nilai);
                    queue.offer(nilai);
                    pq.offer(nilai);
                } else if (tipe == 2) {

                    if (isStack) {
                        if (stack.isEmpty() || stack.pop() != nilai) {
                            isStack = false;
                        }
                    }

                    if (isQueue) {
                        if (queue.isEmpty() || queue.poll() != nilai) {
                            isQueue = false;
                        }
                    }

                    if (isPQ) {
                        if (pq.isEmpty() || pq.poll() != nilai) {
                            isPQ = false;
                        }
                    }
                }
            }

            int state = (isStack ? 4 : 0) + (isQueue ? 2 : 0) + (isPQ ? 1 : 0);

            switch (state) {
                case 4:
                    System.out.println("stack");
                    break;
                case 2:
                    System.out.println("queue");
                    break;
                case 1:
                    System.out.println("priority queue");
                    break;
                case 0:
                    System.out.println("tidak ada");
                    break;
                default: // Kombinasi lainnya (> 1 true)
                    System.out.println("tidak yakin");
                    break;
            }
        }
        sc.close();
    }
}
