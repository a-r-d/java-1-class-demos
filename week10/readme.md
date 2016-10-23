# Week 10: Collections Framework and Generics



## What is a Generic?

  A generic is a placeholder for a class.


## What are Collections?

  The collections framework is a group of classes and interfaces that are used to create iterable data structures. The most commonly used collections are Lists, probably followed by Maps.



## List

Lists are like arrays that resize automatically. There are several types of lists but the most commonly used is ArrayList.

```
List<String> list = new ArrayList<>();

```

## Map (key value stores)

Maps are key-value stores. You can use them to solve many types of problems due to their lookup speed. HashMaps are one of the most common datatypes used in real world programming, and should be studied in depth. They are common interview questions and can actually be used to great benefit in many scenarios.

For maps to work work correctly, .hashCode and .equals should be implemented.

```
Map<String, String> map = new HashMap<>();

```

## Set

A set is like a list where each element is unique. For sets to work correctly, .hashCode and .equals should be implemented.

```
Set<String> list = new HashSet<>();

```
