# Лабораторна робота №6

### Тема: Робота з колекціями в мові програмування Java

C2 = 0 -> Інтерфейс - List

C3 = 0 -> Внутрішня структура колекції - Масив із початковою кількістю елементів 15 та збільшенням кількості елементів на 30%

### Завдання
1. Створити клас, що описує типізовану колекцію (типом колекції є узагальнений клас з лабораторної роботи №5) - Train / RailwayCar.
2. Клас реалізує інтерфейс List
3. Клас має задану внутрішню структуру: Масив із початковою кількістю елементів 15 та збільшенням кількості елементів на 30%
4. Реалізувати всі методи інтерфейсу, а також створити не менше ніж 3 конструктори:(1 – порожній, 2 – в який передається 1 об’єкт узагальненого класу, 3 – в який передається стандартна колекція об’єктів).

### Стандартні вимоги
1. Програма повинна обробляти всі можливі виключні ситуації, що можуть виникнути під час виконання програми.
2. Потрібно дотримуватись стандартів кодування (Java Code Conventions або [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)).
3. Код має бути завантажений на GitHub.
4. Код повинен бути детально задокументований.
5. Всі початкові дані задаються у виконавчому методі.

### Інструкція
1. Склонуйте цей репозиторій `git clone https://github.com/java-labs-sem5-kpi/lab6-collections.git`
2. Перейдіть у склонований репозиторій `cd lab5-inheritence-polymorphism`
3. Зберіть проект за допомогою Maven `mvn clean install`
4. Запустіть виконавчий файл для тестового запуску `java -jar ./target/custom-list-1.0.jar`

### Тестування
Реалізоване за допомогою написання UNIT тестів, які автоматично запускаються під час збірки проекту Maven.

> **Автор:** Рибак Сергій  
> **Група:** ІП-24