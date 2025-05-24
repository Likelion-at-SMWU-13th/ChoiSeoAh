from django.db import models
from django.contrib.auth.models import AbstractUser

# 여기서 User는 AbstractUser를 상속받고 있어.
# 기본 사용자 모델의 모든 필드 + phone 필드 1개가 추가된 구조야.
class User(AbstractUser):
    phone = models.CharField(verbose_name='전화번호', max_length=11)
    