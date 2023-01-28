import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashCode {
    static class Car {
        private final String name;

        public Car(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return Objects.equals(name, car.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    /*
    ※ hash 값을 사용하는 Collection(HashMap, HashSet, HashTable)은 객체가 논리적으로 같은지 비교할 때 1,2 과정을 거친다.
    1. hashCode 메서드의 리턴 값이 우선 일치하고
    2. equals 메서드의 리턴 값이 true여야 논리적으로 같은 객체라고 판단한다.

    hashCode 메서드가 재정의 되어있지 않다면 Object 클래스의 hashCode 메서드가 사용된다.
    Object 클래스의 hashCode 메서드는 객체의 고유한 주소 값을 int 값으로 변환하기 때문에 객체마다 다른 값을 리턴한다.
    */
    public static void main(String[] args) {
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("foo"));
        cars.add(new Car("foo"));
        /*
        위의 내용에 따라서 Collection을 상속 받는 Set 인터페이스는 객체가 같은지 비교할때 1,2 과정을 거친다.
        따라서 hashcode,equals 메서드가 오버라이드 되어 있지 않다면 논리적으로 다른 객체로 판단한다.
         */
        System.out.println(cars.size()); // 재정의 전 2, 재정의 후 1
    }
}
