# week 11 Assignment


## Part 1: Dates, Calendar, and DateFormatter.

For this part please use the Date Format mask:
```
"yyyy-MM-dd HH:mm:ss Z"
```

1. Print the current date (just do ```new Date()```) using the above format mask (use ```SimpleDateFormat```).
2. Use the ```GregorianCalender``` to set the date to one month, one day, and one hour ago. Print this date out.
3. Read in a timestamp from the user (use Scanner, it will be a ```long```, so use ```.nextLong()```). Create a ```Date``` Object from this, and print it out formatted, with the above format mask.


## Part 2: Comparables

1. Create a class called ```Lizard```. If should have 2 attributes:
```java
    public String name;
    public float age; // in years.
```
2. Implement Comparable on the Lizard. You must compare it to another Lizard (see ```Cat.java``` for clues).
3. In the ```compareTo()``` method you implement on lizard do the following:
  1. Primary Sort by name (Ascending)
  2. Secondary Sort by age (Ascending)
4. Make another class, and use it to create 10 lizards. Some of them must have the SAME NAME, but DIFFERENT AGES. We are going to use this learn how to do a secondary sort. Add all of the Lizards to a single ```List<Lizard>```.
5. Print out the unsorted list. The ```toString()``` on Lizard MUST display the name and age.
6. Call ```Collections.sort()``` on the list of Lizards.
7. Print out the sorted list. Your lizards must be sorted in Ascending order by name. Your lizards that had the same name must be secondarily sorted by AGE!



## Grading

Part 1 is worth 30 points. Part 2 is worth 70 points. Please see the example code, there will be examples of how to do everything you need to do. Your job is to understand it and put it all together.
