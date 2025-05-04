from django.shortcuts import render


from django.views.generic import ListView, TemplateView
from .models import Log
# Create your views here.

def index(request):
    return render(request, 'index.html')

# 일기 작성
def log_create_view(request):
    if request.method == "POST":
        title = request.POST.get('title')
        content = request.POST.get('content')
        print(f'제목: {title}')
        print(f'내용: {content}')
        return render(request, 'log/log_form.html') 

    return render(request, 'log/log_form.html') 

 # 일기 감정 태그 
def log_emotion_view(request, id):
    return render(request, 'log/log_emotion.html')      

# 일기 목록
class LogList_view(ListView):
    model = Log
    template_name = 'log/log_list.html'
    context_object_name = 'logs'

    def get_queryset(self):
        return Log.objects.all()
    
# 일기 캘린더
class LogCalendar_view(TemplateView):
    template_name = 'log/log_calendar.html'
    

