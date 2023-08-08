# Titanoboa
Это, Titanoboa - язык программирования понятный и для машины, и для человека. Это делает язык быстрым, и в то же время понятным. Автор - Kisel13.

# Установка
## Windows
В релизах, найдите самый новый и скачайте установщик для windows.

Установите Java (Если нужно), установщик в архиве.

Откройте install.bat.

Пользуйтесь.
## Android 

> [!WARNING]
> На Android не работет модуль canvas!

В релизах, найдите самый новый и скачайте boa.jar

Закиньте куда-нибудь, чтобы termux видел лучше всего создайте в downloads папку boa а потом закиньте в неё boa.jar.

Затем поставьте Termux, лучше всего из f-droid.

В Termux по порядку пропишите эти команды:
```
pkg install openjdk-17 (Не забудте согласиться на установку.)
```
```
termux-setup-storage (Нужно вводить каждый раз при перезаходе в Termux. При первом вводе дайте разрешение.)
```
```
cd storage/downloads/boa/
```
Теперь, в любом текстовом редакторе напишите скрипт на Titanoboa. Сохраните скрипт там же где и boa.jar.
Для запуска скрипта напишите:
```
java - jar boa.jar скрипт.boa
```
# Запуск скриптов
## Windows
Для того чтобы запустить скрипт, просто откройте его.
Редактировать можно в любых редакторах, но в NotePad++ есть [синтаксис](https://github.com/Kisel13/Titanoboa/tree/%D0%A1%D0%B8%D0%BD%D1%82%D0%B0%D0%BA%D1%81%D0%B8%D1%81).
## Android
Для запуска скрипта напишите:
```
java - jar boa.jar скрипт.boa
```
Перед этим убедитесь что вы прописали termux-setup-storage, и находитесь в storage/downloads/boa/

Редактировать можно в любых редакторах.
# Документация
Ниже приведена документация по языку.
### Комментарии
```
//строковый
/*
блочный
*/
```
### Переменные
Переменные объявляются легко, писать тип данных не надо.
Пример:
```
a = 10
b = "Hello"

print a
print b
```
Вывод:
```
10
Hello
```
### Одномерные массивы
Можно создать массив и манипулировать им. Отсчет начинается с нуля.
Пример:
```
abc = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"]

print abc
print abc[10] + abc[20]
```
Вывод:
```
[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
ku
```
### Многомерные массивы
Создаются через функцию newarray из модуля [std](https://github.com/Kisel13/Titanoboa#std) Импортировать не надо. Модуль всегда импортирован.
От количества аргументов зависит то, скольки-мерным будет массив, сами аргументы, размер массив по этой оси.
Пример:
```
x = newarray(5, 5)

x[3][2] = "a"

print x
print x [3][2]
```
Вывод:
```
[[0.0, 0.0, 0.0, 0.0, 0.0],
[0.0, 0.0, 0.0, 0.0, 0.0],
[0.0, 0.0, 0.0, 0.0, 0.0],
[0.0, 0.0, a, 0.0, 0.0],
[0.0, 0.0, 0.0, 0.0, 0.0]]
a
```
### print
Выводит значение переменной или текст с новой строки.
Пример:
```
x = "blablabla"

print x
print "Hello, world!"
```
Вывод:
```
blablabla
Hello, world!
```
### Арифметика
Простейшие арифметические действия. Также можно складывать и умножать строки.
Пример:
```
print 1 + 1
print 2 - 1
print 10 * 10
print 100 / 2
```
Вывод:
```
2
1
100
50
```
### логика
Операторы сравнения. Также можно сравнивать строки. 
Таблица:
| Оператор | Действие |
|------------|:-----------:|
| ==  | Равно  |
| >  | Больше  |
| <  | Меньше  |
| <=  | Меньше или равно  |
| >=  | Больше или равно  |
| !=  | Не равно  |

### If
Выполняет код если условие верно.
Пример: 
```
if (x == 9) {
    print "x это 9" 
}
```
### else
Выполняет код если условие верно.
Пример: 
```
if (x == 9) {
    print "x это 9" 
} else {
    print "x не 9"
```
### else if
Выполняет код если условие верно.
Пример: 
```
if (x == 9) {
    print "x это 9" 
} else if (x = 10) {
    print "x не 9, x это 10"
}
```
### while
Выполняет код по кругу пока условие верно.
Пример
```
i = 1
while (i < 10) {
    print(i)
    i = i + 1
}
```
Вывод:
```
1
2
3
4
5
6
7
8
9
10
```
### do...while
Выполняет код по кругу пока условие верно.
Пример:
```
do {
       print i
       i = i + 1
    } while (i < 10)
```
Вывод:
```
1
2
3
4
5
6
7
8
9
10
```
### for
Первый параметр в for это счётчик, переменная которая обычно хранит то сколько раз цикл выполнился, второй это условие при котором цикл продолжится, третий - шаг, обычно увеличение счётчика. В скобках{} код, который будет выполняться по кругу.
Пример:
```
for (i = 0, i < 10, i = i + 1) {
        print  i
}
```
Вывод:
```
1
2
3
4
5
6
7
8
9
10
```
### break
Прерывает цикл даже если условия выполняются.
### continue
Продолжает выполнение цикла даже если условия не выполнены.
### use
Импорт модулей. Пример:
```
use "math"
```
### функции
### def
Объявление функций. Функции бывают двух типов - возвращающая(возвращает значения через return) и void(ничего не возвращает). Пример:
```
//Возвращающая
def sum(a, b) {
   return a + b
}
```
```
//Void
def summ(a, b) {
   print a + b
}
```
### вызов функции
Вы можете использовать возвращающую функцию везде, так же, как переменную. Пример:
```
print sum(10, 15)
```
Вызвать void функцию можно так:
```
summ(10, 15)
```
если функция не принимает на вход значений:
```
func()
```
# Документация по встроенным модулям
## std
Стандартный модуль, который всегда импортирован.
### Функции
newarray - описана в [многомерные массивы](https://github.com/Kisel13/Titanoboa#%D0%BC%D0%BD%D0%BE%D0%B3%D0%BE%D0%BC%D0%B5%D1%80%D0%BD%D1%8B%D0%B5-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D1%8B).

rand(от, до) - возвращает случайное число в определённом диапазоне. Пример:
```
print rand (0, 100)
```
echo - выводит несколько значений в одну строчку. Пример:
```
x = 10

echo ("x =", x) 
```
Вывод:
```
x = 10.0
```
input(Текст поля) - возвращает то что написал пользователь. Пример:
```
x = input("Ввод: ")

print x
```
wait - останавливает программу пока пользователь не нажмёт enter.

exit - завершает программу.

about - выводит короткое описание языка.

sleep(Время) - останавливает программу на определённое значение миллисекунд поданное на вход.

thread - мега крутая штука, которая позволяет выполнять какую то функцию параллельно другому коду.
## math
Математика
### Функции
abs - Возвращает абсолютное значение числа.

cos - Возвращает косинус угла в радианах.

sin - Возвращает синус угла в радианах.

sqrt - Возвращает квадратный корень числа.

toDegrees - Преобразует угол из радианов в градусы.

toRadians - Преобразует угол из градусов в радианы.

pow - Возводит число в указанную степень.

atan2 - Возвращает арктангенс угла между двумя координатами.
### Константы
PI - Константа, представляющая число π (пи).

E - Константа, представляющая число e (основание натурального логарифма).
## canvas
Холст, геометрические фигуры, окна.
### Функции
window - Создает графическое окно с заданными параметрами. Аргументы: (опционально) название окна, ширина, высота.

prompt - Выводит диалоговое окно с запросом ввода пользовательского значения. Аргументы: текст запроса (строка). Возвращает введенное пользователем значение (строка).

keypressed - Возвращает последнюю нажатую клавишу (код клавиши) или -1, если ни одна клавиша не была нажата.

mousehover - Возвращает массив из двух элементов: x-координата и y-координата текущего положения мыши на холсте.

line, oval, foval, rect, frect, clip - Рисуют линию, овал, заливной овал, прямоугольник, заливной прямоугольник и устанавливают область отсечения соответственно. Аргументы: координаты и размеры фигур (целые числа).

drawstring - Рисует строку на холсте.

Аргументы - текст, x-координата и y-координата начальной точки.

color - Устанавливает текущий цвет для рисования. Аргументы: код цвета (целое число) или значения красного, зеленого и синего компонентов (целые числа).

repaint - Обновляет холст, вызывая его перерисовку.
## DateTime
### Функции
currentDate - Возвращает текущую дату в формате "день-месяц-год"

getYear - Возвращает текущий год.

getMonth - Возвращает текущий месяц.

getDay - Возвращает текущий день.

currentTime - Возвращает текущее время в формате "часы:минуты:секунды" (например, "15:30:45").

getHour - Возвращает текущее значение часов.

getMin - Возвращает текущее значение минут.

getSec - Возвращает текущее значение секунд.
