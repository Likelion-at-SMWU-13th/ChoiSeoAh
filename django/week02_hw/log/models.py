from django.db import models

# Create your models here.

class Log(models.Model):
    title = models.CharField(verbose_name="제목", max_length=100)
    image = models.ImageField(verbose_name="이미지")
    content = models.TextField(verbose_name="내용")  #"내용"
    created_at = models.DateTimeField(verbose_name="작성일", auto_now_add=True)  # 생성 시 자동 설정
    updated_at = models.DateTimeField(verbose_name="수정일", auto_now=True)      # 저장 시 자동 갱신
