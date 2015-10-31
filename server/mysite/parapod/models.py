from django.db import models
from django.core.validators import MaxValueValidator, MinValueValidator

# Create your models here.
#class parapod(models.Model):
#    username = models.CharField(max_length=20)
#    passwd = models.CharField(max_length=8)

#class User(models.Model):
#    username = models.CharField(max_length = 30)
#    headImg = models.FileField(upload_to = './parapod/upload')
#
#    def __unicode__(self):
#        return self.username

class User(models.Model):
    name = models.CharField(max_length = 100)
    password = models.CharField(max_length = 200)
    sex = models.CharField(max_length = 2, default = 'F')
    location = models.CharField(max_length = 100, blank = True)
    user_image = models.CharField(max_length = 1024, default = 'test.png')
    label = models.CharField(max_length = 1000, blank = True)
    img = models.ImageField(upload_to='photo',default = 'photo/user_photo.png')
    title = models.CharField(max_length = 1000, blank = True )

class Photo(models.Model):
    category = models.CharField(max_length = 20)
    begin_datatime = models.DateTimeField()
    theme = models.CharField(max_length = 1000)
    location = models.CharField(max_length = 1024)
    submit_peopleId = models.IntegerField(default = 0)
    joined_peopleId = models.CharField(max_length = 1000, blank = True)
    details = models.CharField(max_length = 3000)
