from django.shortcuts import render
from rest_framework.viewsets import ModelViewSet 

from .models import Post, Comment
from .serializers import PostModelSerializer, PostListSerializer, PostRetrieveSerializer,CommentListModelSerializer, CommentCreateModelSerializer
from rest_framework import generics
from rest_framework.decorators import action, api_view
from rest_framework.response import Response
from django.contrib.auth import authenticate
from rest_framework.authtoken.models import Token
from rest_framework.permissions import AllowAny, IsAuthenticated, IsAdminUser

# Create your views here.
# 사용자 인증
# 로그인 뷰
# POST 요청을 통해 username과 password를 받아 인증을 수행하고, 성공 시 토큰
@api_view(['POST'])
def login_view(request):
    username = request.POST.get('username')
    password = request.POST.get('password')
    user = authenticate(request,
                        username = username,
                        password = password)
    
    if user : 
        token, _ = Token.objects.get_or_create(user=user)
        return Response({'token': token.key})
    
    else:
        return Response(status=401)



    
# Viewset
# Router를 통해 url을 자동으로 생성함
class PostModelViewSet(ModelViewSet):
    queryset=Post.objects.all()
    serializer_class=PostListSerializer
    

    @action(detail = True, methods =['GET'])
    #get_comment_all 메서드 정의
    def get_comment_all(self, request, pk=None):
        post = self.get_object()
        comment_all = post.comment_set.all()
        serializer = CommentListModelSerializer(comment_all, many = True)
        return Response(serializer.data)
    
    #get_permission 메서드를 추가
    def get_permissions(self):
        action = self.action
        # 리스트는 모든 사용자에게 허용
        if action == 'list':
            permission_classes = [AllowAny]
        # 게시글 생성은 인증된 사용자에게만 허용
        elif action == 'create':
            permission_classes = [IsAuthenticated]
        # 게시글 상세 조회는 인증된 사용자에게만 허용
        elif action == 'retrieve':
            permission_classes = [IsAuthenticated]
        # 게시글 수정, 부분 수정, 삭제는 관리자에게만 허용
        elif action in ['update', 'partial_update', 'destroy']:
            permission_classes = [IsAdminUser]
        else:
        # 예외 상황을 대비한 기본 권한 설정
            permission_classes = [AllowAny]
        return [permission() for permission in permission_classes]

# 댓글 작성
class CommentViewSet(ModelViewSet):
    queryset = Comment.objects.all()
    serializer_class = CommentCreateModelSerializer
   