# Динамические массивы, неполный массив, очередь с приоритетом

Написать разные алгоритмы для реализации Динамического массива и сравнить их производительность.

## Результаты

### Временные показатели 100 000 операций (ms)

| | Вставка в начало | Вставка в конец | Вставка в случайное место | Удаление иэ начала | Удаление из конца | Удаление из случайного места |
| :------ | :----- | :----- | :----- | :----- |:------ | :------ |
| SingleArray | 2755 | 1754 | 1836 | 1686 | 1751 | 1877 |
| VectorArray | 543 | 168 | 356 | 432 | 5 | 190 |
| FactorArray | 427 | 4 | 189 | 423 | 4 | 189 |
| MatrixArray | 32992 | 26 | 18191 | 37941 | 1 | 22314 |
| ArrayList Wrapper | 414 | 1 | 191 | 413 | 2 | 187 |

Ожидаемо лидером оказался ArrayList. Далее идет FactorArray, так как его реализация похожа на ArrayList. Немного хуже проявил себя VectorArray.
SingleArray стабильно плохо работает со всеми операциями, у всех остальных реализаций хорошие показатели по операциям в конце массива, так как отсутствует излишнее копирование.
MatrixArray - определенный лузер, хотя показатели операций в конце массива такие же хорошие, как и у большинства.
