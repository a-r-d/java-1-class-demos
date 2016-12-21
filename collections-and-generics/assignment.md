# Week 10 Assignment

You will create a program that will allow you to practice using the collections List, Map and Set. Here are the instructions.

## Instructions

1. This program will begin by reading in 3 sentences the user enters by typing into the console (System.in). You can
use Scanner and call .nextLine() to read in the 3 sentences.
2. Split each sentence into words. You can do this by splitting on space character.
3. Take each word and add it to a List of strings (List&lt;String&gt; is the type). You will use the same list for each sentence.
4. When you are done reading in all of the sentences and adding all of the sentences, and collecting all of the words into a list, print out how many words TOTAL were entered.
5. Now, create a Set of type "Set&lt;String&gt;" from your List. Your set will enforce uniqueness. Print out how many unique words there are.
6. Next, create a Map of type "Map&lt;String, Integer&gt;" to count how many times each word was used. Please see the example program "CountWordInstances.java" if you need a hint of how to do this.
7. Print out each word and how many times each word was used.
8. Print out the word that was used the most times and indicate that (no, you can't just print it out during step 7, you actually have to figure which word was used the most times of all, and print it out seperately).


## Grading

Each homework is worth 100 points. This homework has 8 steps, therefore each step is worth (100 / 8) points.

 - DO NOT ENFORCE CASE SENSITIVITY. "Today" and "today" are the same word in this problem.
 - If you have a tie for the most frequently used word, you don't have to print them both out, any of them is fine.


## Example input / Output

The use may type these 3 sentences:
```
Hello world, today is Halloween.
The sky is very blue today.
Goodbye world.
```

The output should be exactly as follows:

```
Total words typed: 13
Total unique words typed: 10
Word frequencies:
  hello: 1
  world: 2
  today: 2
  is: 2
  halloween: 1
  the: 1
  sky: 1
  very: 1
  blue: 1
  goodbye: 1

Most frequently used word: "world" was used 2 times.
```
