## spring seminar1

### JAVA 기초
***
#### 인터페이스 vs 추상클래스 
* 공통점
  * 선언만 있고 구현 내용이 없는 클래스
  * 새로운 인스턴스(객체, new)를 생성할 수 없다.
  * 자식만이 객체를 생성할 수 있으며 상속 받은 자식이 구현을 반드시 하도록 해야할 떄 사용. (is-a)

* 차이점 (목적이 다름)
  * 인터페이스
    * 목적 : 구현 객체가 같은 동작을 한다는 것을 보장하기 위한 목적.
    * 특징 : 클래스가 아니기 때문에 인터페이스는 다중 상속 o
  * 추상클래스
    * 목적 : 공통적인 기능을 하는 객체들을 추상화. (ex)가전제품 – 세탁기, 전자레인지, 냉장고, 커피머신
    * 특징 : 다중상속 x, 멤버 변수 존재 가능, 구현된 메서드 존재 가능 

#### 오버라이딩 vs오버로딩
* 부모 것(원래 sleep())  
``` public void sleep() { System.out.println(this.name+" zzz"); } ```

* 오버라이딩(Overriding == 덮어쓰기) :  메소드 덮어쓰기  
``` public void sleep() { System.out.println(this.name+" zzz in house"); } ```

* 오버로딩(Overloading == 추가) : 입력항목이 다른 경우 동일한 이름의 메소드를 만듦  
``` public void sleep(int hour) { System.out.println(this.name+" zzz in house for " + hour + " hours"); } ```

#### 제네릭 <T>
* 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법
* 다양한 타입의 객체를 다루는 메소드나, 컬렉션 클래스에서 컴파일 시 타입체크해주는 기능
* 장점
  * 타입 안정성 제공
  * 타입체크 및 형변환 생략 가능 => 코드 간결
  * 컴파일 단계에서 오류 찾을 수 있음
  * 중복제거 가능
*노드와 스프링의 차이점
노드는 javascript를 사용하며 type별 선언 하지 않는다. 따라서, 노드는 제네릭의 개념 필요없음
반면, 스프링은 java를 사용하며 type별 선언을 해야 하기 때문에 제네릭의 개념이 필요 및 용이


#### Builder 패턴
* 생성자에 들어 갈 매개변수를 차례대로 받아들이고 모든 매개변수를 받은 뒤 이 변수들을 통합하여 한 번에 사용할 수 있도록 해줌
* 장점
  * 데이터의 순서에 상관 없이 객체를 만듦
  * 명시적이어서 명확하게 이해하는데 용이함
  * 불필요한 생성자를 만들지 않고 객체를 만듦




### Spring
***
Spring이란?
* Spring Framework
* 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크
* 동적 웹 사이트를 개발하기 위해 여러가지 서비스를 제공함
* 필요한 부분만 사용할 수 있도록 모듈화 되어 있고, 각 모듈은 독립적으로 분리되어 있어 재사용이 가능 
* DI/ IoC와 AOP를 지원함
  * DI (Dependency Injection) : 의존성 주입
  * IoC (Inversion Of Control) : 제어의 역전. 컨테이너는 개발자 대신 객체의 생성부터 소멸까지 책임짐
  * AOP (Aspect Oriented Programming) : 관점 지향 프로그래밍
  
Spring boot란?
* 목적 : 자주 사용하는 프로젝트 조합을 미리 만들어 놓아 스프링을 더욱 쉽고 간단하게 사용하기 위해
* Spring project의 하나. 수작업으로 초기 세팅 과정 없이 간단히 Spring project를 생성할 수 있다.
* 프로젝트마다 기본적으로 설정하는 부분들을 이미 내부적으로 가지고 있음.
* Servlet Container를 기본 내장하고 있음(Tomcat, Jetty)
* pom.xml에서 의존 라이브러리의 버전을 자동으로 관리해줌
* 설정을 자동으로 해줌.




### Spring vs Node.js
***
* Spring
  * java
  * 멀티스레드
* Node.js
  * javaScript
  * 싱글 스레드 이벤트 루프
