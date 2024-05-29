% Title: 
% Author: FG 
% Date: 2024-05-20 
--- 


# Notizen zu ADP2

## A1 - Doubly Linked List 

=> PM2 Praktikum 2 

Interface Abstract List: 

```plantuml
@startuml

abstract class AbstractList<E>{
    + get(int Index): E
    + set(int Index, E e): E Gibt das Vorherige element aus? 
    + add(E e)
    + remove(int Index): E 
    + addAll(int Index, Collection<? extends E> col): boolean
    + clear(): boolean 
   
}

class DoublyLinkedList<E> {
    - size: int
    - head: Node<E>
    - tail: Node<E>
    + DoublyLinkedList(): DoublyLinkedList<E>
    + DoublyLinkedList(Collection<? extends E>): DoublyLinkedList
    + toString(): String 
    + size(): int
    + toArray(): Array<E>
}

class Node<E>{
    - succ: Node 
    - pre: Node 
    - content: E 
    + getContent(): E
    + setContent(E e): boolean 
    + getNext(): Node 
    + getPrevious(): Node 
    + setNext(Node n): boolean 
    + setPrevious(Node n): boolean
}

AbstractList<|-- DoublyLinkedList
DoublyLinkedList-->Node

@enduml

```




### add 
- erzeugt neuen Node, 
- fügt das Elemente in Node ein 
- Setzt Succ und Pre der vorgänger und nachfolger 
- erhöht den Counter size um 1
- wird immer direkt vor Tail eingesetzt 

### addAt(index)

- erzeugt neuen Node, 
- fügt das Elemente in Node ein 

- man muss sich über die Knoten vorwärts arbeiten 
- Man beginnt bei Head 
- Zählt dann eine For-schleife bis index hoch 
- bei jedem schleifen durchlauf holt man sich den currentNode als succ des vorheringen nodes 
- wenn man bei index angekommen ist, 
  - Setze Succ und Pre der vorgänger und nachfolger 




### remove

### addAll 
- Iteriert über die Gebenen Collection und Added die Elemente 

### Kopierkonstruktor 

- erzeuge neue DoublyLinkedList 
- benutze addAll um die Übergebene Collection in die Liste auf Zu Nehmen 


### Clear (oder Remove All)
- ganz simple: 
  - Setze den succ von head auf tail
  - und setze den pre von tail auf head 
  - Damit sind alle knoten dazwischen tot//weg 
=> Kein for/forEach  


### Stream??? 
=> PM2 Praktikum 3 

Siehe : "C:\Users\fabia\Documents\Wichtig\110_Informatik_Studium\60_Studium\20_Semester_SoSe_2023\PM2\10_Folien_New\v5 Lambdas und Functional Interfaces_Korrigiert.pdf"

PM2 Script 5 : v5 Lambdas und Functional Interfaces_Korrigiert.pdf
Ab Seite 52 

=> Stream benötigen interface Iterable 
```plantuml
@startuml

interface Iterable<T>{
    + iterator(): Iterator<T>
    + forEach(Consumer...)
    + spliterator(): Spliterator<T>
}

@enduml 
```

# Laufzeit berechnung 

$T(N) = a\cdot N^b$  
Gesucht: a  
Gegeben:   
- Gemessene Daten $N = 256000,~~T(N)=63.242$
- Abgeschätzt: $b=1.8$

=> $a = \frac{T}{N^b} = \frac{63.242}{256000^{1.8}}\approx1.16\times 10^{-8}$  

alternativ:  
=> $a = \frac{T}{N^b} = \frac{3.074}{64000^{1.8}}\approx6.86\times 10^{-9}$

## Verdoppelung von 64000 auf 128000

Gemessene Werte 

| N      | T(N)   |
| ------ | ------ |
| 64000  | 3.074  |
| 128000 | 12.048 |

Berechnete Werte $T(N) = 6.86\times 10^{-9} \cdot N^{1.8}$

| N      | T(N)      |
| ------ | --------- |
| 64000  | 3.07400  |
| 128000 | 10.70429 |
=> Geringfügig unterschätzt 

Weitere Abschätzung: 

| N      | T(N)       |
| ------ | ---------- |
| 64000  | 3.074000   |
| 128000 | 10.704290  |
| 256000 | 37.274502  |
| 512000 | 129.797354 |

=> Deutliche unterschätzt 