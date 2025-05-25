from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.contrib.auth import get_user_model
from django.contrib.auth.hashers import make_password

User = get_user_model()

# 회원가입
@api_view(['POST'])
def signup(request):
    username = request.data.get('username')
    password = request.data.get('password')
    email = request.data.get('email')
    phone = request.data.get('phone')

    if not username or not password:
        return Response({'error': 'username과 password는 필수입니다.'}, status=400)

    if User.objects.filter(username=username).exists():
        return Response({'error': '이미 존재하는 username입니다.'}, status=400)

    user = User.objects.create(
        username=username,
        password=make_password(password),
        email=email,
        phone=phone
    )
    return Response({'message': '회원 가입 완료'})

# 회원정보 조회
@api_view(['GET'])
def user_info(request,user_id):
    try:
        user = User.objects.get(id=user_id)
    except User.DoesNotExist:
        return Response({'error': '사용자를 찾을 수 없습니다.'})

    data = {
        'id' : user.id,
        'username' : user.username,
        'email': user.email,
        'phone': user.phone
    }

    return Response(data)

# 회원정보 수정
@api_view(['PUT'])
def update_user(request,user_id):
    try:
        user = User.objects.get(id=user_id)
    except User.DoesNotExist:
        return Response({'error': '사용자를 찾을 수 없습니다.'}, status=404)

    user.email = request.data.get('email', user.email)
    user.phone = request.data.get('phone', user.phone)
    password = request.data.get('password')
    if password:
        user.password = make_password(password)

    user.save()
    return Response({
        'message': '회원정보 수정',
        'user': {
            'id': user.id,
            'username': user.username,
            'email': user.email,
            'phone': user.phone
        }
    })


# 회원탈퇴
@api_view(['DELETE'])
def delete_user(request, user_id):
    try:
        user = User.objects.get(id=user_id)
    except User.DoesNotExist:
        return Response({'error': '사용자를 찾을 수 없습니다.'}, status=404)

    user.delete()
    return Response({'message': '회원 탈퇴 완료'})