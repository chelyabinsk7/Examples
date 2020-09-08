Тестовое задание от одной компании на позицию fullstack-разработчика.
Так как навыки работы с фронтом минимальны, в выполнении задания ограничился backend-частью.

Как работает:
1) Запускается как Java-приложение
2) /organizations-jooq/src/main/resources/schema.sql - создаст БД
3) http://localhost:8080/ - стартовая страница
4) При вводе некорректных данных, противоречащих условиям, будут выбрасываться различные исключения и ошибки.

## Создать приложение для учета организаций и сотрудников

# Структура объектов:

# Организация
- Идентификатор
- Наименование
- Идентификатор головной организации
# Сотрудник
- Идентификатор
- Наименование
- Идентификатор организации
- Идентификатор руководителя

# Функционал:

back-end
Функционал
Организации:
- API создание организации
- API изменение организации
- API удаление организации: если у организации есть дочерние элементы, удалить ее нельзя
- API список организаций с количеством работающих в ней сотрудников с параметрами: пагинация и поиск по наименованию

Сотрудники:
- API создание сотрудника (при выборе организации можно выбрать руководителя только из этой организации)
- API изменение сотрудника (при выборе организации можно выбрать руководителя только из этой организации)
- API удаление сотрудника: если у сотрудника есть дочерние элементы, удалить его нельзя
- API список сотрудников (в списке показывать еще его организацию и руководителя) с параметрами: пейджинг и поиск по наименованию организации и/или сотрудника

front-end:
вкладки: список организаций, список сотрудников
В зависимости от вкладки список организаций или список сотрудников осуществляется переход по кнопке создать на необходимую форму.

# Применить при реализации: 
1) spring boot 2
2) postgres
3) для доступа к db использовать jooq
4) использовать транзакции где необходимо
5) использовать connection pool для db
6) использовать React
7) собирать фронт с помощью webpack
8) желательно придерживаться стандартов es6
9) код тестового задания необходимо разместить на github , в readme должна быть инструкция по запуску