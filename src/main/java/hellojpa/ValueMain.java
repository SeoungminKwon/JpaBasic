package hellojpa;

public class ValueMain {
    public static void main(String[] args) {
        int a = 10;
        int b = a; // 타입이 복사되는 것임 공유 x
        a = 20;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
