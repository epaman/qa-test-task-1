## QA test task
Решение QA test task:
- логин в личный кабинет
- переход в раздел чат-ботов
- переход в подраздел "Виджеты подписки"
- создать виджет (опционально - assert создания)
- зайти в виджет, переименовать, сохранить (опционально - assert переименования)
- удалить виджет

### Как запустить
Для запуска теста, набрать в cmd:

```
gradle cleanTest test -Dusername=<your-login> -Dpassword=<your-password>
```
 
### Видео
[Демонстрация запуска теста](https://youtu.be/bdSszbE_LzU)

### Что использовано
- java 1.8
- senelide 5.10.0
- testng 7.1.0
- gradle 6.2.2
- idea 2019.3.4