# Notes on homework code

Concatenating Strings in a loop is slow:

```java

	public static String countTo100()
	{
		String numbers1To100 = "";

		for  (int i = 1; i <= 100; i++ )
		{
			numbers1To100 += Integer.toString(i) + " ";
		}

		return numbers1To100;
	}

```

Simplest way to skip and only use every third number

```java
//sum: 667660
private static int sumOfEveryThirdNum() {
  int start = 2000;
  int end = 6;
  int sum = 0;
  for(; start >= end; start -= 3) {
    sum += start;
  }
  return sum;
}

// alternative way
// sum: 666330
private static int sumOfEveryThirdNum() {
  int start = 2000;
  int end = 6;
  int sum = 0;
  for(; start >= end; start--) {
    if(start % 3 == 0) {
      sum += start;
    }
  }
  return sum;
}

// note, these give different results
// I gave full credit for either one.

```


Capitals vs lowercase

```java

// Good:
// use caps to declare classes
public class Dog {

}

// Bad
// only do caps when declaring classes
int Dog = 0;
int Cat = 1;


// Good
// do lowercase when declaring variables.
int dog = 0;
int cat = 1;


// also good - camelCase
long aVeryCoolVariableName = 1000L;


```
