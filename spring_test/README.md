#  Spring boot 예시 실해을 위한 폴더

## hello 폴더 내용
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