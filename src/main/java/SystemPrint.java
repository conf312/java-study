public class SystemPrint {
    public static void main(String[] args) {
    /*
    System.out.println()을 호출하게 되면 디스크 I/O 동기화 처리가 되기 때문에 전체적인 시스템의 성능이 저하 될 수 있고,
    System.out.println() 으로 디버그 처리한 부분을 일일이 주석처리, 해제하는 것은 개발 및 운영의 효율을 떨어트릴 수 있다.
    */
        System.out.println("Ctrl + Left Click Method()");
    }
}
