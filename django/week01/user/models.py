from django.db import models

class User(models.Model):
    profile = models.ImageField(verbose_name='프로필')
    real_name = models.CharField(max_length=20, verbose_name='실명')
    user_name = models.CharField(max_length=20, verbose_name='아이디')
    bio = models.TextField(blank=True , verbose_name='자기소개')


