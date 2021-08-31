# Курсовой проект "Путешествие дня"

Курсовой проект представляет собой автоматизацию тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

## Начало работы

Скачать проект по [ссылке](https://github.com/aidthebest/coursework1) 

### Prerequisites

Окружение и инструментарий должны соответствовать данным из [этого документа](https://github.com/aidthebest/coursework1/blob/master/docs/Plan.md)

### Установка и запуск

1. Открыть проект в Intellej IDE Ultimate Edition
2. В превом окне терминала выполнить команду docker-compose up
3. Дождаться запуска СУБД MySQL, СУБД PostgreSQL, Node
4. Открыть новое окно терминала и выполнить команду java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar для запуска и интеграции приложения с базой MySQL 
   или выполнить команду java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar для запуска и интеграции приложения с базой PostgreSQL
5. Запустить тесты командой ./gradlew "-Ddatasource.url=jdbc:mysql://localhost:3306/app" clean test для СУБД MySQL  
   или ./gradlew "-Ddatasource.url=jdbc:postgresql://localhost:5432/app" clean test для СУБД PostgreSQL

## Лицензия

Опишите условия лицензии



[comment]: <> (java -jar artifacts/aqa-shop.jar --spring.config.location=./application.postgres.properties)

[comment]: <> (- запускаем приложение с доступом в постгрес)

[comment]: <> (java -jar artifacts/aqa-shop.jar --spring.config.location=./application.mysql.properties)

[comment]: <> (запускать SUT с помощью команды вида &#40;для mysql&#41;)

[comment]: <> (java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar)

[comment]: <> (тесты с помощью)

[comment]: <> (./gradlew "-Ddatasource.url=jdbc:mysql://localhost:3306/app" clean test)

[comment]: <> (URL базы данных в коде можно будет получить с помощью)

[comment]: <> (System.getProperty&#40;"datasource.url"&#41;)
