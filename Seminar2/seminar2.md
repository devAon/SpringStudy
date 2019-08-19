Seminar2 - Assignment
=====================
##### 1. Class 생성 - 대학교, 학과, 학생, 교수
##### 2. Builder 생성 - 대학교, 학과, 학생, 교수
##### 3. Interface 생성 - 대학교, 학과, 학생, 교수
##### 4. 상속 - 학과는 대학교 상속 && 교수, 학생을 학과 상속
##### 5. Main Class 생성 및 구현체 생성 - 대학교, 학과, 학생, 교수
##### 6. 각 ArrayList에 3개씩 객체 Add(데이터 상관 X)
##### 7. 각 ArrayList에 넣은 객체의 toString 메소드 호출
 
 
 
 
 
## spring seminar2 정리
 
### JAVA 기초2
***
#### static
* 전역, 정적의 의미로 사용됨
* JVM 구동 시, Runtime Data Areas의 Method(Static) Area에 적재됨 (== 프로그램 시작 시 인스턴트화 됨) 
=> 따라서, 프로그램 시작 후 클래스나 메소드에서 별도의 인스턴스화 없이도 사용 가능
* 특징
  * static으로 설정하면 같은 곳의 메모리 주소(동일한 참조 값)만을 가리키기 때문에 static 변수의 값을 공유하게 됨
* 종류
  * static 변수
  * static 메소드
   * Override 불가능
   * static 변수에만 접근 가능

#### final
* 해당 Entity가 오직 한 번 할당 될 수 있음을 의미 => 즉, 상속/변경 금지하는 규제
* final 키워드가 붙으면 해당 객체는 immutable이 됨
* 종류
  * final 변수 : 한 번만 초기화 가능
  * final 메소드 : 해당 메소드를 @Override 또는 숨길 수 없음을 의미
  * final 클래스 : 해당 클래스를 상속할수 없음을 의미 
 
 
 
### 서버란
***
#### Server & Client
* 분산 애플리케이션 구조 
* 네트워크 아키텍처
* Server : 서비스 자원의 제공자
* Client : 서비스 요청자. 서비스를 사용하는 사용자, 다른 Server

#### Http (Hyper Text Transfer Protocol)
* TCP, UDP, IP프로토콜을 사용하며 www 상에서 데이터를 주고 받는 프로토콜
* Client 와 Server 사이에 이루어지는 요청(Request)/응답(Response) 프로토콜
* 80번 포트 사용함 (Https는 443포트 사용)
* 연결상태 유지하지 않는 프로토콜
  * 서버에 접속하여 클라이언트의 요청에 대한 응답을 전송 후 연결 종료
  * 전산 자원이 적게 들지만, 클라이언트 구분이 힘듦
  * Cookie, Session, Token등을 사용해 단점 해소
* Http Message
  * Request : 요청메시지. Client -> Server. 서버의 동작을 일으킴
  * Response : 응답메시지. Server -> Client. 요청에 대한 서버의 회신
* Http Method
  * GET    : 조회. READ 
  * POST   : 생성. CREATE 
  * PUT    : 수정. UPDATE 
  * DELETE : 삭제. DELETE 
* Status Code
  * 2xx : Success
   *200
   *201
  * 3xx : Redirect
   *304
  * 4xx : Client Error
   *400
   *401
   *404
   *405
  * 5xx : Server Error
   *500   
  
  
   
#### MVC (Model - View - Controller Architecture)
* 사용자의 인터페이스로부터 비즈니스 로직을 분리
* 세가지 역할로 구분한 패턴
  * Model        : data, DB
  * View         : 사용자 인터페이스, 프론트엔드
  * Controller   : data - business logic 사이의 상호작용 관리
   * 사용자가 접근 한 URL에 따라 요청에 맞는 데이터를 Model로 처리
   * 데이터를 View에 반영해 사용자에게 알려줌

#### WAS (Web Application Server)
* 인터넷 상에서 HTTP를 통해 사용자 컴퓨터나 장치에 애플리케이션을 수행해 주는 미들웨어
* 동적 서버 컨텐츠를 수행하는 것. 주로, DB서버와 같이 수행됨
* 대부분 자바 기반


#### Web Server
* HTML문서 또는 CSS,이미지 파일 등 정적 컨텐츠를 전송해주는 서버
* Nginx
 
   
  
#### Servlet
* Java를 사용하여 웹 페이지를 동적으로 생성하는 서버측 프로그램
* 웹 서버의 성능을 향상하기 위해 사용되는 자바 클래스의 일종
* JSP : Html에 java코드 포함 <-> Servlet : Java코드에 Html 포함
 * 외부 요청마다 Thread로 응답함
 * Java로 구현되기 때문에 다양한 플랫폼에서 동작함
 
 
 
### Spring Presentation Layer
***
 
 
 
 
### Tomcat
***
* Apache 소프트웨어 재단에서 개발한 Servlet Container(Web Container)만 있는 Web Application Server(=WAS)
* Web Server와 연동하여 실행할 수 있는 자바 환경을 제공함
* Servlet이나 JSP를 실행하기 위한 Servlet Contatiner를 제공함
* 정적 컨텐츠를 로딩하는데 웹 서버보다 수행속도가 느림
