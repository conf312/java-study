import java.util.ArrayList;

public class ArrayListSerializable {
    /* Serializable
    - 자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록 바이트(byte)
    형태로 데이터 변환하는 기술과 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)을 말한다.

    - 시스템적으로 이야기하자면 JVM(Java Virtual Machine 이하 JVM)의 메모리에 상주(힙 또는 스택)되어 있는 객체 데이터를 바이트 형태로
    변환하는 기술과 직렬화된 바이트 형태의 데이터를 객체로 변환해서 JVM으로 상주시키는 형태를 말한다.

    종류: JSON,XML,CSV등
    (JSON, CSV 로의 직렬화, 역직렬화도 Jackson 등의 라이브러리를 이용하면 편리하지만,
    외부 라이브러리를 사용하지 않고 자바가 기본으로 제공하는 라이브러리만 사용한다는 전제에서..)
    */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list.size());
    }
}
