from django.shortcuts import render, redirect
from .forms import SignupForm

def signup(request):
    if request.method == 'POST': # POST 요청이 들어오면
        # POST 요청으로 들어온 데이터로 폼을 생성
        form = SignupForm(request.POST) 
        if form.is_valid():
            form.save() # 폼이 유효하면 DB에 저장
            # 회원가입 후 자동으로 로그인 페이지로 이동함
            return redirect('login')
    else:
        form = SignupForm() # GET 요청이 들어오면 빈 폼을 생성

    return render(request,"signup.html", {'form': form}) #  signup.html 템플릿을 렌더링함

