from django.urls import path
from . import views
app_name="users"

urlpatterns = [
    path('signup/', views.signup, name='signup'),  # POST 요청 (회원가입)
    path('user/<int:user_id>/', views.user_info, name='user'),  # POST 요청 (계산기)
    path('update/<int:user_id>/', views.update_user, name='update'),  
    path('delete/<int:user_id>/',views.delete_user, name = 'delete'),
]