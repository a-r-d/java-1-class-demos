# Week 5

Week 5 is a review week.

## Agenda

 1. Again, what is a method
  1. Cover: define a method, arguments, return types, calling methods, getting back values
 2. Background again on arrays
 3. Strings, review last week + talk about char arrays

### Review homework 5 (array anxiety)

 1. create arrays
 2. min value of array
 3. average from an array
 3. copy arrays
 4. insert into array
 5. delete from array

### Review homework 6 (strings)

You can’t use any built-in string functions for the following problems except length() and charAt().

For procedures that take an index and/or length be sure to have boundary checking and test with bad values (e.g. negative or too long).  Clip values that are outside the valid range.

 1. What is a string
 2. char arrays
 3. How to count the vowels in a string? (write a method)
 4. Where is a given char in a string? (write a method)
 5. Count occurrences of a given char in a String
 6. write a substring function manually
 7. substring with method signature: (array, startIndex, length)
 8. compare two strings char by char (essentially we implement .equals)
 9. count how many words are in a string (ignore all whitespace)
  1. Easy: split on whitespace, then trim
  2. Hard: for each char increment count if word char seen, and record if you are inside a word char or not.





## Homework notes

```java

				System.out.println( "Value[ " + ( intIndex + 1 ) + " ] = " + aintValues[ intIndex ] );

```


You can use String.format() to format strings.

User %s to sub strings, %d for numbers

```java

				System.out.println(String.format("Value[%d] = %d", intIndex + 1, aintValues[intIndex]));

```



Why is this not the right way to copy an array? How should you do it differently?

```java

public static int[] AddValueToEndOfArray(int aintOldValues[], int intValueToAdd)
{
	int NewSize = 0;
	int aintNewValues [];

	// Allocate space.
	NewSize = aintOldValues.length + 1;
	aintNewValues = new int[ NewSize ];

	// Copy Values.
	aintNewValues [0] = aintOldValues[0];
	aintNewValues [1] = aintOldValues[1];
	aintNewValues [2] = aintOldValues[2];
	aintNewValues [3] = aintOldValues[3];

	// Add to end.
	aintNewValues [4] = intValueToAdd;
	return aintNewValues;
}

```
