### Сравнительная таблица производительности алгоритмов сортировок массива из N элементов

#### Для массива из случайных элементов
| | 1 | 10 | 100 | 1000 | 10000 | 100000 | 1000000 |
| :------ | :----- | :----- | :----- | :----- |:------ | :------ | :------ |
| Insertion sort | 0  ms | 0 ms| 0 ms | 0 ms | 18 ms | 828 ms |  1 m 23 s 944 ms |
| Selection sort | 0  ms | 0 ms| 0 ms | 0 ms | 94 ms | 9s 942 ms | 15 m 47 s 727 ms |
| Shell sort with Shell sequence | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 31 ms | 283 ms |
| Shell sort with Knuth sequence | 0  ms | 0 ms| 0 ms | 0 ms | 79 ms | 31 ms | 314 ms |
| Shell sort with Hibbard sequence | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 31 ms | 398 ms |
| Heap sort | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 16 ms | 394 ms |

#### Для массива из цифр
| | 1 | 10 | 100 | 1000 | 10000 | 100000 | 1000000 |
| :------ | :----- | :----- | :----- | :----- |:------ | :------ | :------ |
| Insertion sort | 0  ms | 0 ms| 0 ms | 0 ms | 15 ms | 774 ms | 1 m 15 s 632 ms |
| Selection sort | 0  ms | 0 ms| 0 ms | 0 ms | 125 ms | 9s 534 ms | 15 m 44 s 510 ms |
| Shell sort with Shell sequence | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 16 ms | 259 ms |
| Shell sort with Knuth sequence | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 32 ms | 204 ms |
| Shell sort with Hibbard sequence | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 94 ms | 281 ms |
| Heap sort | 0  ms | 0 ms| 0 ms | 0 ms | 15 ms | 32 ms | 172 ms |

#### Для отсортированного массива
| | 1 | 10 | 100 | 1000 | 10000 | 100000 | 1000000 |
| :------ | :----- | :----- | :----- | :----- |:------ | :------ | :------ |
| Insertion sort | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 47 ms | 2 s 351 ms |
| Selection sort | 0  ms | 0 ms| 0 ms | 0 ms | 99 ms | 9s 364 ms | 15 m 49 s 532 ms |
| Shell sort with Shell sequence | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 31 ms | 233 ms |
| Shell sort with Knuth sequence | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 31 ms | 267 ms |
| Shell sort with Hibbard sequence | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 31 ms | 281 ms |
| Heap sort | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 15 ms | 375 ms |

#### Для обратно отсортированного массива
| | 1 | 10 | 100 | 1000 | 10000 | 100000 | 1000000 |
| :------ | :----- | :----- | :----- | :----- |:------ | :------ | :------ |
| Insertion sort | 0  ms | 0 ms| 0 ms | 16 ms | 31 ms | 1 s 712 ms | 2m  46 s 850 ms |
| Selection sort | 0  ms | 0 ms| 0 ms | 0 ms | 117 ms | 9s 585 ms | 16 m 1 s 595 ms |
| Shell sort with Shell sequence | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 32 ms | 289 ms |
| Shell sort with Knuth sequence | 0  ms | 0 ms| 0 ms | 0 ms | 15 ms | 15 ms | 173 ms |
| Shell sort with Hibbard sequence | 0  ms | 0 ms| 0 ms | 0 ms | 15 ms | 16 ms | 226 ms |
| Heap sort | 0  ms | 0 ms| 0 ms | 0 ms | 0 ms | 157 ms | 189 ms |

