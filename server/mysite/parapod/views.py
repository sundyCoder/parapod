from django.shortcuts import render
from django import forms
from django.http import HttpResponse
from models import User
from models import Photo 
from forms  import PhotoForm
import datetime
import json
import time
import random

# Create your views here.
#class UserForm(forms.Form):
#    username = forms.CharField()
#    headImg = forms.FileField()
#
#def register(request):
#    if request.method == 'POST':
#        uf = UserForm(request.POST,request.FILES)
#        if uf.is_valid():
#            #get form information
#            username = uf.cleaned_data['username']
#            headImg = uf.cleaned_data['headImg']
#            #write into database
#	    user = User()
#            user.username = username
#            user.headImg = headImg
#            user.save()
#            return HttpResponse('upload ok!')
#    else:
#        uf = UserForm()
#    return render(request,'register.html',{'uf':uf})
#

def register_new_user(request):
    out_data = {}
    errors = []
    if request.method == 'POST':
        user_name = request.POST.get('username', '')
        if not user_name:
            errors.append('user name post error')
        password_md5 = request.POST.get('password', '')
        if not password_md5:
            errors.append("password post error")

        if len(errors) > 0:
            out_data['ret'] = 'failed'
        else:
            if len(User.objects.filter(username = user_name)) == 0:
                out_data['ret'] = 'ok'
                reg_data = User(username = user_name, password = password_md5)
                reg_data.save()
                request.session['user'] = user_name
            else:
                out_data['ret'] = 'user_exist'
    return HttpResponse(json.dumps(out_data), content_type="application/json")

def login(request):
    errors = []
    out_data = {}
    if request.method == 'POST':
        user_name = request.POST.get('username', '')
        if not user_name:
            errors.append('user name post error')
        password_md5 = request.POST.get('password', '')
        print password_md5 
        if not password_md5:
            errors.append("password post error")
        if len(errors) > 0:
            out_data['ret'] = 'failed'
        login_usr = User.objects.filter(username = user_name)
        if len(login_usr) == 0:
            print 'user_not_exist'
            out_data['ret'] = 'not_exist'
        else:
            login_usr_obj = login_usr[0]
            if login_usr_obj.password == password_md5:
                request.session['user'] = user_name
                out_data['ret'] = 'ok'
            else:
                out_data['ret'] = 'password_error'
#    print user_name
#    print password_md5 
    return HttpResponse(json.dumps(out_data), content_type="application/json")
