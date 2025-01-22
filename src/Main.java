public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int a = 5;
        int b = 10;
        long INF = Integer.MAX_VALUE;
        System.out.println((a + b) / 2);
        // sout 에 그대로 Integer.MAX_VALUE 를 넣거나 int 형 변수에 담을 경우 overflow 발생!
        // 그러나 long 형에 넣으면 overflow 가 발생하지 않음.
        // 2,147,483,647 이 int형이 가질 수 있는 최대값이기 때문이다.
        System.out.println(INF + 1);
    }
}