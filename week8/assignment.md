# Assignment week 8

  You may combine these parts all into one class, despite what the instructions say. The instructions are just here for
  clarity, so if you combine the classes, make sure to CLEARLY separate them and leave me comments about what code corresponds to what homework section!


## Part 1 - Does the file exist?

  1. Create a new class called Part1 with a "public static void main(String args [])" method because you will run it directly.
  2. Prompt the user to type a filename or filepath. We are going to save the user input and check if this file exists.
  3. Check if what the user typed is a valid path. If not, have the user re-enter it.
  4. When the user types a valid path, use Files.exists() to see if the path exists.
  5. If the path exists, print something to the console that says so. If not, let the user know that also.


## Part 2 - What kind of file is it?

  1. Create a new class called Part2 with a "public static void main(String args [])" method because you will run it directly.
  2. Prompt the user to type a filename or filepath. We are going to save the user input and check if this is a file or directory, or something else (e.g. a link).
  3. Check if what the user typed is a valid path. If not, have the user re-enter it.
  4. When the user types a valid path, use Files.exists() to see if the path exists.
  5. If the file does not exist, prompt the user again to enter a valid filepath.
  6. Once the use enters a valid file that exists, create a "BasicFileAttributes" object using Files.readAttributes().
  7. Print out the basic information about the file.


## Part 3 - List the contents of a directory, and tell us about it

  1. Create a new class called Part3 with a "public static void main(String args [])" method because you will run it directly.
  2. Prompt the user to type a filename or filepath that is a directory. We are going to save the user input and list the directory contents.
  3. Check if what the user typed is a valid path. If not, have the user re-enter it.
  4. When the user types a valid path, use Files.exists() to see if the path exists.
  5. If the file does not exist, prompt the user again to enter a valid filepath.
  6. Once the use enters a valid file that exists, create a "BasicFileAttributes" object using Files.readAttributes().
  7. Check if the file is a directory. If not, re-prompt the user to enter a filepath that points to a directory!
  8. Once the user enters a valid, existing directory, list the contents of the directory and display this to the user.
  9. Count how many plain files there are inside of the directory, print the count.
  10. Count how many directories are inside of this dir, print the count.
  11. what is the most recently created file in this dir? Print it out.
  12. What is the oldest file in this dir? Print it out.
