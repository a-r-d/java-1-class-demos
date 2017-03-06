# Assignment week 11 - Exploring the filesystem

Each section builds on the last. You may break each part into a method in a single class.


## Part 1 - Does the file exist?

  1. Create a new class called HomeworkWeek11 with a "public static void main(String args [])" method because you will run it directly.
  2. Prompt the user to type a filename or filepath. We are going to save the user input and check if this file exists.
  3. Check if what the user typed is a valid path. If not, have the user re-enter it.
  4. When the user types a valid path, use Files.exists() to see if the path exists.
  5. If the path exists, print something to the console that says so. If not, let the user know that also and force the user to enter a path that exists.


## Part 2 - What kind of file is it?

  1. You should now have a valid, existing file path from Part 1. You are now going to read the file attributes for the path. Create a "BasicFileAttributes" object using Files.readAttributes().
  2. Using the BasicFileAttributes object please print out the following information about the file:
    a. Name of file
    b. full path of file
    c. size of the file
    d. Is the file a directory? If not is it a normal file? 
    e. When was the file created?
    f. When was the file modified?
  3. If the file was NOT A DIRECTORY MAKE THE USER ENTER ANOTHER PATH! This means you must repeat Part 1 if the file is not a directory.  


## Part 3 - List the contents of a directory, and tell us about what is inside of it (NOT RECURSIVELY!!!)

  1. You should now have a file path that is: valid, does exist, and is a directory. If that is not the case you need to prompt the user to enter filepath that is a directory. 
  2. Once the user enters a valid, existing directory, list the contents of the directory and display this to the user. Make sure to print out the filename of each file in the directory.
  3. Count how many plain files (isRegularFile() on BasicFileAttributes) there are inside of the directory, print the count. YOU DO NOT NEED TO DO THIS RECURSIVELY! 
  4. Count how many directories are inside of this dir, print the count. YOU DO NOT NEED TO DO THIS RECURSIVELY!
  5. what is the most recently created file in this dir? Print it out. YOU DO NOT NEED TO DO THIS RECURSIVELY!
  6. What is the oldest file in this dir? Print it out. YOU DO NOT NEED TO DO THIS RECURSIVELY!
