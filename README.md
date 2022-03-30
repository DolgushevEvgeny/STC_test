Разработать приложение для хранения контактов.

Модель данных контакта
- фио (строка)
- телефон (строка)

Структура приложения:
1) Экран списка контактов (показывать все контакты, на элементах списка показывать фио и телефон). 
Должyа быть возможность добавить новый контакт или удалить существующий. 
Для добавления контакта должна быть форма на отдельном экране. При удалении контакта должен быть диалог подтверждения действия.
2) Экран добавления контакта. Должно быть 2 поля ввода (для фио и телефона) и кнопка "Добавить". П
осле выполнения данный экран должен закрыться и добавленный новый контакт появиться в общем списке контактов. 
Должна выполняться верификация полей - оба поля должны быть заполнены (т.е. не пустыми). 
Для номера телефона также сделать валидатор на соответствие российским номерам (+7хххххххххх) - об этом ниже. 
Если какие-то поля не заполнены или номер телефона заполнен неправильно, показывать диалог соответствующей ошибкой. 
Также не должно быть возможности добавлять контакт с номером, который уже есть у других контактов.

Ожидаемая структура приложения:
- MainActivity (основная активити)
- ContactListFragment (фрагмент для отображения списка контактов)
- NewContactFragment (фрагмент для добавления нового контакта)

Для организации навигации между экранами - навигатор из AndroidX.

Для связи данных в приложении ожидается использование модели представления (ViewModel). 

Данная модель представления должна в качестве зависимости получать объект класса ContactPhoneValidator, в котором должен быть нативный jni-метод (external/native) validatePhone(phone: String): Bool.
Метод должен проверять, что строка начинается с "+7", имеет длину 12 (т.е. знак "+" и 11 цифр), и содержит только цифры. 
В таком случае метод должен вернуть true, иначе false. Например, строки "+79990002211" и "+71112223344" пройдут проверку успешно, а строки "+9344", "вфцв" и "ъъъъ" - нет. (можно применить юнит-тесты)

Приложение должно поддерживать поворот экрана. При повороте не должны пропадать контакты или введенные значения в форме добавления нового контакта.
