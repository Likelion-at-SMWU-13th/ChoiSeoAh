from rest_framework.serializers import ModelSerializer
from .models import Post , Comment

class PostModelSerializer(ModelSerializer):
    class Meta:
        model = Post
        fields = '__all__' # 모든 필드를 직렬화
        #fields = ['id', 'writer', 'content'] # 특정 필드만 직렬화

# 게시글 목록
class PostListSerializer(PostModelSerializer):
    pass

# 게시글 상세 보기
# depth=1은 Post 모델의 writer 필드에 대한 User 모델의 모든 필드를 포함.
class PostRetrieveSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        depth = 1

# 댓글 목록 직렬화
class CommentListModelSerializer(ModelSerializer):
    class Meta:
        model = Comment
        fields = '__all__'

# 댓글 작성용
class CommentCreateModelSerializer(ModelSerializer):
    class Meta:
        model = Comment
        fields = ['content', 'post', 'writer']  # 댓글 작성 시 필요한 필드만 포함
        read_only_fields = ['created_at']  # 작성일은 자동으로 설정되므로 읽기 전용