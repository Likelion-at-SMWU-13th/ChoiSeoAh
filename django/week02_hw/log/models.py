from django.db import models
from django.contrib.auth import get_user_model

# Create your models here.

User = get_user_model()

class Log(models.Model):
    title = models.CharField(verbose_name="제목", max_length=100)
    image = models.ImageField(verbose_name="이미지", null=True, blank=True)
    content = models.TextField(verbose_name="내용")  #"내용"
    created_at = models.DateTimeField(verbose_name="작성일",auto_now_add=True)  # 생성 시 자동 설정
