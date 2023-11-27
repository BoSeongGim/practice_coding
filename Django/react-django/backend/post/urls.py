from django.urls import path

from . import view

urlpatterns = [
    path('', view.ListPost.as_view() ),
    path('<int:pk>/', view.DetailPost.as_view() ),
]