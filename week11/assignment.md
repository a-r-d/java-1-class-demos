# week 11

This week we will review collections, and talk about various topics in Chapter 15.

## Agenda

 - Homework questions
 - Homework comments
  - [comparing floating point numbers is hard](https://www.youtube.com/watch?v=PZRI1IfStY0)
  - Integers do division with truncation in Java, FP are the correct thing to use for division.
  - How to remove punctuation? RegEx of course: ```.replaceAll(",|!|\\.|\"", "")```
 - Topic: Arrays util
 - In class work: create an array, sort it, then do binary search on it.


Example of an FP rounding error.
```
> 0.3 === 0.2 + 0.1
false

// How do you deal with this?
// you use an error factor:
> 0.3 - (0.2 + 0.1) < 0.00000000001
true

```



## Topics (new content)

 - copying an array
 - comparing arrays
 - sorting arrays (Comparable interface, and comparator classes)
 - binarySearch on array.
 - Date objects
 - Calendar objects
 - Regex (Matcher and mather.find())
