# Django Form
Django의 폼은 사용자가 텍스트를 입력하고 옵션을 선택하는 등의 작업을 수행한 다음 해당 정보를 서버로 전송할 수 있도록 하는 요소


## GET & POST

- HTML 폼을 처리할 때 사용할 수 있는 메소드 : GET, POST가 전부임

### GET
- 시스템 상태에 영향을 주지 않는 요청에 사용
- 제출된 데이터를 문자열로 묶어 URL에 포함시킴

### POST
- 시스템 상태를 변경할 수 있는 요청에 사용
- 사용자 입력값을 HTTP 요청의 body에 담아 전송



## 폼에서 Django의 역할

1. 렌더링 할 수 있도록 데이터를 준비하고 재구성
2. 해당 데이터에 대한 HTML 양식 생성
3. 클라이언트로부터 제출된 양식 및 데이터 수신 및 처리


## Django의 Form 클래스

`Form` 클래스는 **폼을 설명하고 폼이 어떻게 작동하는지**를 정의

Django에서 객체를 렌더링할 때는 일반적으로 다음과 같은 절차를 따름

1. 뷰에서 해당 객체를 가져옴
2. 템플릿 컨텍스트로 전달
3. 템플릿 변수(`{{ variable_name }}`)를 사용하여 HTML 마크업으로 렌더링



## 장고에서 Form 구현

### 1. Form 클래스 생성 (`forms.py`)

- `forms.py` 파일에서 폼 클래스를 생성합니다.
- `from django import forms`로 `forms` 모듈을 임포트합니다.

### 2. 뷰 처리 (`views.py`)

- `from .forms import 생성한 폼 클래스의 이름`으로 폼 클래스를 임포트
- `GET`, `POST` 메서드를 사용하여 뷰를 작성
- `form` 객체를 `'form'`이라는 키로 context 딕셔너리에 담아 템플릿에 전달
- context에 담은 데이터를 사용하여 HTML을 렌더링

### 3. 템플릿에서 폼 렌더링 (`template.html`)

- Django에서 폼을 템플릿에 표시하려면 폼 인스턴스를 템플릿 컨텍스트에 포함시키면 됨
- 예를 들어, 뷰에서 폼을 `form`이라는 이름으로 컨텍스트에 전달했다면, 템플릿에서는 `{{ form }}`만 사용해도 `<label>`과 `<input>` 요소들이 자동으로 렌더링됨



