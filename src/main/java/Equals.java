public class Equals {
    /*
    boolean equals(Object obj)로 정의된 equals 메소드는 기본적으로 2개의 객체가 동일한지 검사하기 위해 사용된다.
    equals가 구현된 방법은 2개의 객체가 참조하는 것이 동일한지를 확인하는 것이며, 이는 동일성(Identity)을 비교하는 것이다.
    즉, 2개의 객체가 가리키는 곳이 동일한 메모리 주소일 경우에만 동일한 객체가 된다.
    */
    public static void main(String[] args) {
        String a = new String("Text");
        String b = new String("Text");

        System.out.println(a == b); // false

        /*
        객체 참조 값이 동일한지 동일성을 비교하는것이라 했는데, true가 나온다 왜 일까?
        그 이유는 String 클래스에서 equals 메소드를 오버라이드하여 객체가 같은 값을 갖는지 동등성(Equality)을 비교하도록 처리했기 때문이다.
         */
        System.out.println(a.equals(b)); // true
    }
}
