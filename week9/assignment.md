# assignment week 9

This week we will be focusing on reading and writing files. This will build on what we learned last week about
creating "Path" objects.

This week for the assignment we will be reading in a file, filtering the lines based on a search word and then
writing a new file with the filtered data. If you have heard of the command line utility "grep" we will essentially be
making a grep that takes in a files and writes out to another file.

## The assignment.

 Create a program that will ask the user for 3 pieces of input.

 1. Ask the use to enter a path to a file with CSV data in it (it just has to be multiple lines of text, not necessarily CSV, could be server logs as well).
 2. Ask the use to enter a string to filter the content by (e.g. if you have a list of street addresses in your data, the use may enter a street number)
 3. Ask the user to enter a path to write the filtered data out to.

 The program will produce one piece of output: using the path from input #3, write a file with the filtered data.


## Example.

You have a file with the following lines of text:

```
1,8933 South,Commercial Ave,03/07/2006,10500,North Bound: 4900 / South Bound: 5600,41.732725,-87.55132,"(41.732725, -87.55132)"
12,9379 South,Commercial Ave,03/07/2006,12700,North Bound: 6000 / South Bound: 6700,41.724444,-87.551124,"(41.724444, -87.551124)"
13,9730 South,Commercial Ave,03/07/2006,9000,North Bound: 4000 / South Bound: 5000,41.718183,-87.551016,"(41.718183, -87.551016)"
14,4107 South,Cottage Grove Ave,03/30/2006,10800,North Bound: 5600 / South Bound: 5200,41.820171,-87.606798,"(41.820171, -87.606798)"
15,4750 South,Cottage Grove Ave,03/01/2006,14200,North Bound: 7000 / South Bound: 7200,41.807987,-87.606532,"(41.807987, -87.606532)"
16,5325 South,Cottage Grove Ave,02/01/2006,13700,North Bound: 7200 / South Bound: 6500,41.797881,-87.606302,"(41.797881, -87.606302)"
17,6144 South,Cottage Grove Ave,03/01/2006,20900,North Bound: 10300 / South Bound: 10600,41.78269,-87.605979,"(41.78269, -87.605979)"

```

You Enter that data for input #1.

Next, you enter the search string of "41.8" (input #2). As a result your program filters the above data and writes a file with the following lines (the name of the file is input #3):

```
14,4107 South,Cottage Grove Ave,03/30/2006,10800,North Bound: 5600 / South Bound: 5200,41.820171,-87.606798,"(41.820171, -87.606798)"
15,4750 South,Cottage Grove Ave,03/01/2006,14200,North Bound: 7000 / South Bound: 7200,41.807987,-87.606532,"(41.807987, -87.606532)"
```


## Detailed steps to solve this homework.

 1. Ask the user to enter the name of the file to read.
 2. Make sure the file exists, and ask again if it does not.
 3. Ask the user to enter a search string.
 4. Make sure the user entered something at least 3 chars long, ask again if they did not.
 5. Ask the user to enter a filepath to write the data to
 6. Make sure the filepath is valid, but if the file does not exist that is OK. We will create the file.
 7. Open the file from step 1 for reading.
 8. Open the file from step 5 for writing.
 9. Read each line from the file you opened in step 7. Do a string contains search of the line for the search term from step 3.
 10. If you find the line from step 9 contains the search string, write the line to file you opened for writing in step 8.
 11. When you are done reading and searching each line, close both of the files.
 12. Print the number of lines of text you matched and wrote to the console, indicating your results to the user.
