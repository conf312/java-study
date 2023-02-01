
public class StringBuilderBuffer {
    public static void main(String[] args) {
        /*
        java에서 synchronized 키워드는 여러개의 스레드가 한 개의 자원에 접근할려고 할 때,
        현재 데이터를 사용하고 있는 스레드를 제외하고 나머지 스레드들이 데이터에 접근할 수 없도록 막는 역할을 수행

        *예를 들어 멀티스레드 환경에서 A 스레드와 B스레드 모두 같은 StringBuffer 클래스 객체 sbf의 append() 메서드를 사용하려고 하면, 다음과 같은 절차를 수행하게 된다.
        A 스레드 : sbf의 append() 동기화 블록에 접근 및 실행
        B 스레드 : A 스레드 sbf 의 append() 동기화 블록에 들어가지 못하고 block 상태가 됨.
        A 스레드 : sbf의 append() 동기화 블록에서 탈출
        B 스레드 : block 에서 running 상태가 되며 sbf 의 append() 동기화 블록에 접근 및 실행
         */
        String str = "aaa";
        StringBuilder sb = new StringBuilder("aaa"); // 동기화(Synchronization) 지원 X
        StringBuffer sbf = new StringBuffer("aaa"); // 동기화(Synchronization) 지원 O

        System.out.println(str.hashCode());
        System.out.println(sb.hashCode());
        System.out.println(sbf.hashCode());

        str += "bbb";
        sb.append("bbb");
        sbf.append("bbb");

        System.out.println("================================================");
        System.out.println(str.hashCode()); // String의 경우 불변(Immutable)성으로 객체가 새로 만들어져 주소가 바뀜
        System.out.println(sb.hashCode());
        System.out.println(sbf.hashCode());
    }
}
