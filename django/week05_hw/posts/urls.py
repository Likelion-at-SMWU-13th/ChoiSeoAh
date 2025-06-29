from django.urls import path, include
from django.contrib import admin
from rest_framework import routers

from .views import PostModelViewSet, CommentViewSet, login_view

app_name="posts"

# viewset을 사용하여 URL을 자동으로 생성
# DefaultRouter를 사용하여 URL을 자동으로 생성
router_post = routers.DefaultRouter()
router_post.register('posts', PostModelViewSet, basename='post')
router_post.register('comments', CommentViewSet, basename='comment')

urlpatterns = [
    path('', include(router_post.urls)),
    path('login/', login_view, name='login'),  # 로그인 뷰 추가
    path('admin/', admin.site.urls)

]
