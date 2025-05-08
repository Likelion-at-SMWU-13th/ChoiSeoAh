from django import forms
from .models import Post

class PostModelForm(forms.ModelForm):
    class Meta:
        model = Post
        fields = '__all__'  
        
class PostBasedForm(forms.Form):
    image = forms.ImageField(label='이미지')
    content = forms.CharField(label='내용', widget=forms.Textarea)
    CATEGORY_CHOICES = [
        ('1', '일반'), 
        ('2', '스페셜'), 
        
    ]

    category = forms.ChoiceField(label='카테고리', choices=CATEGORY_CHOICES)
    