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
4. Открыть новое окно терминала и выполнить команду `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar` для запуска и интеграции приложения с базой MySQL 
   или выполнить команду `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar` для запуска и интеграции приложения с базой PostgreSQL
5. Запустить тесты командой `./gradlew "-Ddatasource.url=jdbc:mysql://localhost:3306/app" clean test` для СУБД MySQL  
   или `./gradlew "-Ddatasource.url=jdbc:postgresql://localhost:5432/app"` clean test для СУБД PostgreSQL
6. Для получения отчетов Allure необходимо ввести команду `./gradlew allureserve` находясь в корневой папке
7. Для завершения работы контейнеров Docker  использовать команду `docker-compose down` находясь в корневой папке


## Лицензия

Свободная

## Документация к проекту

1. План тестирования - https://github.com/aidthebest/coursework1/blob/master/docs/Plan.md
2. Отчетные документы по итогам автоматизирвоанного тестирования - 
3. Отчетные документы по итогам автоматизации - 


