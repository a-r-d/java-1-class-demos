# Week 13 Assignment - List, Set, Map and Word Frequencies.

[Intro video for this assignment](https://youtu.be/epX1M0HAbzw)

You will create a program that will allow you to practice using the collections List, Map and Set. Here are the instructions. 

Here is a detailed example of code that can help you to generate an word frequency map. 
[Unique word frequency map](https://github.com/a-r-d/java-1-class-demos/blob/master/collections-and-generics/week10/UniqueWords.java)

Understanding how hashmaps work can help you to write fast, efficient, and good code. Hashmaps can used to create in memory caches, key-value data stores, and reduce the running time complexity of many operations on arrays and collections. They also appear frequently in interview questions. 

## Instructions

1. Prompt the user to enter 3 sentences. The user enters by typing into the console (System.in). You can use Scanner and call ```scanner.nextLine()``` 3 times to read in the 3 sentences to 3 Strings.
2. Split each sentence into words. You can do this by splitting on space character ```someString.split(" ")```.
3. Take each word and add it to a List of strings (```List<String>``` is the type). USE THE SAME LIST FOR ALL OF THE SENTENCES. YES, YOU NEED TO FIGURE OUT HOW TO COMBINE ALL OF THE STRINGS TOGETHER *hint hint*.
4. When you are done reading in all of the sentences and adding all of the sentences, and collecting all of the words into a list, print out how many words TOTAL were entered.
5. Now, create a Set of type "```Set<String>```" from your List. Your set will enforce uniqueness. Print out how many unique words there are.
6. Next, create a Map of type "```Map<String, Integer>;```" to count how many times each word was used. Please see the example program "CountWordInstances.java" if you need a hint of how to do this.
7. Print out each word and how many times each word was used.
8. Print out the word that was used the most times and indicate that (no, you can't just print it out during step 7, you actually have to figure which word was used the most times of all, and print it out seperately).

__Extra Credit:__ Turn this into a command line application that can read the text of a file in and analyze word frequencies. You can use a library like [Apache commons CLI](https://commons.apache.org/proper/commons-cli/) to help you parse the command line argument for the file if you wish. 


## tl;dr: Example input / Output

Make the user enter 3 sentences as follows: 
```
Please enter sentence 1 >
Hello world, today is Halloween.

Please enter sentence 2 >
The sky is very blue today.

Please enter sentence 3 >
Goodbye world.
```

The output should be exactly as follows. Part 1 of the output is the size of all of the words entered. Part 2 is the number of unique words. Part 3 is the word frequency map. 

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


## Grading

Follow the instructions. Each homework is worth 100 points. This homework has 8 steps, therefore each step is worth (100 / 8) points. You must also use the collections interface correctly, so for example when you create a List create an ArrayList but assign the type as List. [Check this link if you have no idea what I'm talking about because you didn't come to class](http://stackoverflow.com/questions/13395114/how-to-initialize-liststring-object-in-java).

 - DO NOT ENFORCE CASE SENSITIVITY. "Today" and "today" are the same word in this problem.
 - If you have a tie for the most frequently used word, you don't have to print them both out, any of them is fine.
