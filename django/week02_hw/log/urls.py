from django.urls import path

from .views import log_create_view
from .views import log_emotion_view
from .views import LogList_view, LogCalendar_view

app_name='log'

urlpatterns = [

    #fbv
    path('create/', log_create_view),
    path('<int:id>/emotions', log_emotion_view),
    #cbv
    path('', LogList_view.as_view(), name='log_list'),              
    path('calendar/', LogCalendar_view.as_view(), name='log_calendar'),  

]