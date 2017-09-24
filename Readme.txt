#### Порядок развертывания

1. создать ответвление репозитория (Fork) 
2. клонировать на локальную машину (любой клиент для mercury) 
3. импортировать проект в eclipse
	* становить плагин m2e отсюда 
          http://download.eclipse.org/technology/m2e/releases/
	* в Эклипсе нажать File -> Import -> Maven -> Existing Maven project 
	* добавить папку куда  сколнировали проект и выбрать из нее pom.xml
4. создать БД в postgresql
5. выполнить sql скрипт, который находится в дереве проекта (\sql_script\rc_verlioka_11082016.sql)  
6. запустить проект на tomcat


 Настройки доступа к БД в файле src/main/webapp/WEB-INF/spring/root-context.xml
	 БД postgresql
	 имя     VerliokaRAD
	 логин   postgres
	 пароль  0000
----------------------------------------------------------------------------
Пользователи  

 логин    пароль
 admin    admin
 expert   expert
 teacher  teacher
----------------------------------------------------------------------------