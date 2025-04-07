
package hangDoi;

import java.util.Scanner;

class Node {

    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

    Node(int x, Node t) {
        data = x;
        next = t;
    }

    public String toString() {
        return data + " ";
    }
}

class myQueue {

    Scanner sc = new Scanner(System.in);

    Node head, tail;

    public myQueue() { // tạo hàng đợi rỗng 
        head = tail = null;
    }

    boolean EmptyQ() { // ktra hàng đợi có rỗng không
        return head == null;
    }

    void addQ(int x) {
        Node t = new Node(x);
        if (head == null) {
            head = tail = t;
        } else {
            tail.next = t;
            tail = t;
        }
    }

    int removeQ() {
        int x = 0;
        if (head == null) {
            System.out.println("Hàng đợi rỗng !");
        } else {

            x = head.data;
            if (head.next == null) {
                head = tail = null;
            } else {
                head = head.next;
            }
        }
        return x;
    }

    void nhap() {
        int x;
        while (true) {
            System.out.print("Nhập 1 số (!=0) để thêm vào hàng đợi: ");
            x = sc.nextInt();
            if (x == 0) {
                break;
            }
            addQ(x);
        }
        System.out.println("Đã thêm xong !");
    }

    void in() {
        myQueue t = new myQueue();
        System.out.println("Nội dung hàng đợi:");
        while (!EmptyQ()) {
            int x = removeQ();
            System.out.print(x + " ");
            t.addQ(x);
        }
        while (!t.EmptyQ()) {
            int x = t.removeQ();
            addQ(x);
        }
        System.out.println();
    }

    void tong() {
        int sum = 0;
        myQueue t = new myQueue();
        while (!EmptyQ()) {
            int x = removeQ(); // lấy phần tử từ hàng đợi gốc   
            sum += x;
            t.addQ(x); // lưu phần tử đó vào hàng đợi tạm 
        }
        while (!t.EmptyQ()) {
            int x = t.removeQ(); // lấy phần tử từ hàng đợi tạm 
            addQ(x); // lưu phần tử đó vào hàng đợi gốc 
        }
        System.out.println("Tổng: " + sum);
    }

    int demLe() {
        int dem = 0;
        myQueue t = new myQueue();
        while (!EmptyQ()) {
            int x = removeQ();
            t.addQ(x);
            if (x % 2 != 0) {
                dem++;
            }
        }
        while (!t.EmptyQ()) {
            int x = t.removeQ();
            addQ(x);
        }
        return dem;
    }

    int timMax() {
        myQueue t = new myQueue();
        int max = 0;
        while (!EmptyQ()) {
            int x = removeQ();
            t.addQ(x);
            if (max < x) {
                max = x;
            }
        }
        while (!t.EmptyQ()) {
            int x = t.removeQ();
            addQ(x);
        }
        return max;
    }

    void xoaCuoi() {
        if (EmptyQ()) {
            System.out.println("Hàng đợi rỗng!");
            return;
        }
        if (head == tail) {
            removeQ();
            return;
        }
        myQueue t = new myQueue();
        int dem1 = 0;
        int dem2 = 0;
        while (!EmptyQ()) {
            int x = removeQ();
            t.addQ(x);
            dem1++;
        }
        while (dem2 < dem1 - 1) {
            int x = t.removeQ();
            addQ(x);
            dem2++;
        }
    }

    void themCuoi() {
        myQueue t = new myQueue();
        System.out.print("Nhập phần tử muốn thêm vào cuối hàng đợi: ");
        int x = sc.nextInt();
        if (EmptyQ()) {
            addQ(x);
            return;
        }
        while (!EmptyQ()) {
            int y = removeQ();
            t.addQ(y);
        }
        t.addQ(x);
        while (!t.EmptyQ()) {
            int y = t.removeQ();
            addQ(y);
        }
    }

    void themX() {
        System.out.print("Nhập phần tử muốn thêm: ");
        int x = sc.nextInt();
        System.out.print("Nhập vị trí muốn thêm: ");
        int k = sc.nextInt();
        
        myQueue t = new myQueue();

        if (EmptyQ()) {
            addQ(x);
            return;
        }
        int temp = 0;
        while (!EmptyQ()) {
            int y = removeQ();
            t.addQ(y);
        }
        while (!t.EmptyQ()) {
            temp++;
            int y = t.removeQ();
            if (temp == k) {
                addQ(x);
            }
            addQ(y);
        }
    }
}

public class HangDoi {

    public static void main(String[] args) {
        myQueue m = new myQueue();
//        m.addQ(3);
//        m.addQ(2);
//        m.addQ(7);
//        m.addQ(6);
//        while (!m.EmptyQ()) {
//            int x = m.removeQ();
//            System.out.println(x + " ");
//        }
        m.nhap();
        m.in();

//        m.tong();
//
//        System.out.println("Số phần tử lẻ trong hàng đợi: " + m.demLe());
//
//        System.out.println("Phần tử lớn nhất trong hàng đợi: " + m.timMax());
//
//        m.xoaCuoi();
//        System.out.println("Hàng đợi sau khi xoá phần tử cuối: ");
//        m.in();
//
//        m.themCuoi();
//        System.out.println("Hàng đợi sau khi thêm phần tử cuối: ");
//        m.in();
        
        m.themX();
        System.out.println("Hàng đợi sau khi thêm phần tử: ");
        m.in();
    }
}
