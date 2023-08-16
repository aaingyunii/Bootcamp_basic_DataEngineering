#  Bootcamp_basic_DataEngineering 👨‍🔧💪
플레이데이터 부트캠프 데이터 엔지니어링 과정 - '데이터엔지니어링' 에 관한 기초 학습 파일들을 담은 repo입니다.

<br>

## 이번 강의의 총 과정 
### : **`데이터 수집 -> DB 적재 -> Spring boot Restful API 작성`**

<br>

## `pip install virtualenv`
- ### 가상환경 설치 및 `jupyter notebook` 사용 <br>
: `conda` 명령어 말고 `python virtualenv` 로 가상환경을 만드는 과정을 진행.<br>
<= `conda` 의 경우, 아나콘다를 쓰지 못하는 경우를 대비해서 `python` 명령어로 하는 방법으로 진행하였음.

1. CLI 환경에서 `python -m virtualenv venv` 명령어를 통해 가상환경 설치 후
2. 해당 path에서 `Scripts` 으로 이동 후
3.  `activate` 명령어를 통해 가상환경을 활성화
4.  `requirements.txt` 를 통해 필요한 `pip` 설치


- ### 데이터베이스 MySQL 사용.

- ### VScode 개발 편집기 사용
    - `Terminal` 창에서 `PS (Power shell)` 이 아닌  `CMD` 창으로 열어서<br>
    `virtualenv` 의 `/Scripts/activate` 접근 가능.
    
        - `Terminal` 창의 default profile 을 선택해 `CMD` 를 기본 창으로 변경 가능
        - `F1 > python interpreter` 선택을 통해 기본 가상환경을 설정할 수 있다.

- ### Django 와 Spring
    - **디자인 패턴** :
        1. `Spring` : **MVC (Model-View-Controller)**
        2. `Django` : **MVT (Model-View-Template)**
            - 해당 디자인 패턴에서는 MVC 에서의 View를 `Template`, Controller를 `View` 로 표현한 것.
        

<br>

## API (Application Programming Interface)

### REST (REpresentational State Transfer) API
- `WWW` 와 같은 분산 하이퍼미디어 시스템을 이용한 자원을 주고 받는 이름을 규정하고<br>
`http` 메서드(`GET`, `POST`, `PUT`, `DELETE`,...)를 통해 해당 자원의 상태를 주고 받는 것

- ### Talend API Tester
: chrome 웹 스토어에서 `Talend API Tester` 를 설치하여 API 동작을 확인


<br>

---

### ➕➕➕

### 🧩 네트워크 포트  확인
- `CMD` 창에서 `netstat -nao` 를 통해 로컬 주소와 포트넘버를 확인하고 'PID' 도 확인 가능하여 무엇이 사용 중인지 확인 가능하다.

#### ✅ 부트캠프 기간 동안 많은 환경들이 설치되고 다양한 프로그램들이 활용되기 때문에 중간 중간 오류가 발생했을 때 확인할 수 있는 방법들을 알고 있는 것이 좋다.

### 🧩 sqlite3 (Django 프레임워크의 내장 DB)
- `Django` 에서는 설치가 필요없는 `sqlite3` 를 따로 기본 제공해준다.
    - 그러나, **이번 학습 과정에서는 `MySQL` 을 연결해서 사용할 예정**

- 해당 파일을 확인하고 싶다면, `DB Browser for SQLite` 프로그램을 따로 설치하여 확인이 가능하다.
