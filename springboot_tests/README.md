#  Spring boot 예시 실행을 위한 폴더

## `hello` 폴더 내용
1. `HelloApplication.java` 파일을 실행해 `localhost:8080` 으로 접근이 가능하다.
2. `/controller/HelloController.java` 파일을 통해 실행 `localhost:8080/hello` 주소를 통해<br>화면에 'Hi!!' 메시지를 확인할 수 있다.

### `application.properties` 내용 수정 중 >> `spring.jpa.hibernate.ddl-auto=update` 관련 내용.

- `ddl-auto` 의 의미 : 의미 그대로 데이터베이스를 자동으로 조작하는 옵션 
	- `create` 
		- 애플리케이션이 가동되고 SessionFactory가 실행될 때 기존 테이블을 지우고 새로 생성 
	- `create-drop` 
		- "create"와 동일한 기능을 수행하나 애플리케이션을 종료하는 시점에 테이블을 삭제 
	- `update`
		- SessionFactory가 실행될 때 객체를 검사해서 변경된 스카마를 갱신 
		- 기존에 저장된 데이터는 유지 
	- `validate` 
		- "update" 처럼 객체를 검사하지만 스키마는 건드리지 않음 
		- 검사 과정에서 데이터베이스의 테이블 정보와 객체의 정보가 다르면 에러가 발생 
	- `none` : ddl-auto 기능을 사용하지 않음 


> 운영환경에서는 `validate나 none` 를 사용
> 개발환경에서는 `create 또는 update` 를 사용하는 편 
>
> `show-sql` 은 로그에 하이버네이트가 생성한 쿼리문을 출력하는 옵션 
> 아무 설정이 없으면 저장에 용이한 형태로 출력되기 때문에 사람이 보기에는 불편하게 한 줄로 출력 
> 
> `format_sql` 옵션으로 사람이 보기 좋게 포매팅할 수 있음 


## `api` 폴더 내용

### 각종 `API method` 를 테스트 시행하고 학습

## `jpa` 폴더 내용

- DAO에서 구현한 기능을 서비스 인터페이스에서 호출해 결과 값을 가져오는 작업을 수행
- 서비스에서는 클라이언트가 요청한 데이터를 적절하게 가공해서 컨트롤러에게 넘기는 역할 


![image](https://github.com/aaingyunii/Bootcamp_basic_DataEngineering/assets/31847834/3e8cf52a-8c99-46cb-907a-a41d309fbfdc)


> 위의 코드에서 리턴 타입이 DTO 객체인 것을 확인할 수 있는데 DAO 객체에서 엔티티 타입을 사용하는 것을 고려하면 서비스 레이어에서 DTO 객체와 엔티티 객체를 각 레이어에 변환해서 전달하는 역할도 수행한다고 볼 수 있음 
> 서비스와 DAO의 사이에서 엔티티로 데이터를 전달하는 것으로 표현 
> 회사나 팀에 규정에 따라 DTO를 사용하기도 함 
> 위 구조는 각 레이어 사이의 큰 데이터의 전달을 표현한 것이고, 단일 데이터나 소량의 데이터를 전달하는 경우 DTO나 엔티티를 사용하지 않기도 함 


- 서비스 레이어에서는 도메인 모델을 활용해 애플리케이션에서 제공하는 핵심 기능을 제공
	- 이번 수행의 아키텍처는 서비스 레이어에서 비즈니스 로직을 처리하는 방식 
	- 기본적인 CRUD의 기능을 호출하기 위해 간단하게 메서드를 정의

## `stock` 폴더 내용

- `naver_finance.ipynb` 에서 크롤링한 데이터들을 `MySQL` 에 "stock" 이란 테이블에 저장하였고,
- 해당 스프링 부트 어플리케이션에서 이를 활용한 웹 페이지를 구현함.

1. `Entity` : DB의 데이터를 전달해주는 역할, DB와 가장 가까운 클래스로서, DB 테이블과 각 필드들이 1:1 매칭되어야함.

2. `Dto` : Entity를 통해 꺼내온 **데이터에 대한 접근** 을 수행하는 역할. 엔티티에 직접 접근하지 않기때문에 엔티티가 변경되어도 dto만 변경하면 됨.

3. `Repository` : <br> `JPA` 를 사용하면서 `Repository`를 통해 **DB에 실제로 접근** 가능, <br> *Service 객체 와 DB를 연결해주는 역할* 을 하며, 서비스 계층에서 레포지토리를 이용하여 데이터를 관리함.

4. `Service` : Dto를 통해 받은 데이터를 이용해 **비즈니스 로직을 처리하고, `Repository` 를 통해 DB에 접근하여 데이터를 관리하는 역할** , <br>여기에서는 `StockService` 를 `interface` 로 정의한 후 추상 메서드 오버라이딩을 `StockServiceImpl class` 에서 정의하며 파일들을 분리함.
