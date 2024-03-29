## ITEM 45 - 스트림은 주의해서 사용하라.

`스트림 API`는 다량의 데이터 처리 작업을 돕고자 자바 8 에 추가되었다.

### 스트림 API 가 제공하는 추상 개념 중 핵심 2가지
#### 1. 스트림은 데이터 원소의 유한 혹은 무한 시퀀스를 뜻한다.
#### 2. 스트림 파이프라인은 이 원소들로 수행하는 연산 단계를 표현하는 개념이다.
- 대표적으로 컬렉션, 배열, 파일, 정규표현식 패턴 매처(matcher), 난수 생성기 등
- 스트림 안의 데이터 원소들은 객체 참조나 기본 타입(int, long, double) 값이다.

스트림 파이프라인은 지연 평가(lazy evaluation) 된다. 평가는 종단 연산이 호출될 떄 이뤄지며, 종단 연산에 쓰이지 않는 데이터 원소는 계산에 쓰이지 않는다.
이러한 지연 평가가 무한 스트림을 다룰 수 있게 해주는 열쇠다.

스트림 API는 메서드 연쇄를 지원하는 `플루언트 API(fluent API)`다. 즉 파이프라인 하나를 구성하는 모든 호출을 연결하여 단 하나의 표현식으로 완성할 수 있다.

스트림을 제대로 사용하면 프로그램이 짧고 깔끔해지지만, 잘못 사용하면 읽기 어렵고 유지보수도 힘들어진다. `코드 45 ~ 를 살펴보자. (Main.java)`

### ❗️ 주의 사항
- 람다 매개변수의 이름은 주의해서 정해야 한다. 코드 45~ 에서 매개변수 g는 사실 `group` 이라고 하는게 나으나, 책의 지면 폭이 부족해 줄였다고 한다. `람다에서는 타입 이름을 자주 생략하므로 매개변수 이름을 잘 지어야 스트림 파이프라인의 가독성이 유지된다.`
- 벌도 메서드로 작성한 `alphabetize` 함수도 연산에 적절한 이름을 지어주고 세부 구현을 주 프로그램 로직 밖으로 빼내 전체적인 가독성을 높였다.

### 모든 반복문을 스트림으로 바꾸고 싶은 유혹이 일겠지만, 서두르지 않는게 좋다.
기존 코드는 스트림을 사용하도록 리팩터링하되, 새 코드가 더 나아 보일 때만 반영하자.

### 정리
- 반복 방식과 스트림 정답은 없다.
- 스트림과 반복 중 어느 쪽이 나은지 확신하기 어렵다면 둘 다 해보고 더 나은 쪽을 택하라.