from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User

class SignupForm(UserCreationForm): #장고에서 기본 제공하는 회원가입 폼을 상속받아서 사용함 
    class Meta:
        model = User # 장고에서 제공하는 모델 
        fields = ['username','password1','password2','first_name'] # 순서대로 id, 비밀번호1, 비밀번호2, 이름을 입력받음