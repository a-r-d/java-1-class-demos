# Intro to assignment week 12 - Grep in Java

This week we will be focusing on reading and writing files. This will build on what we learned last week about
creating "Path" objects.

This week for the assignment we will be reading in a file, filtering the lines based on a search word and then
writing a new file with the filtered data. If you have heard of the command line utility "grep" we will essentially be
making a grep that takes in a files and writes out to another file.

[grep wikipedia page](https://en.wikipedia.org/wiki/Grep)


## The assignment described at a high level

 Create a program that will ask the user for input (2 files paths and a "search string"), you will open one file for writing and other file for reading. __The file you open for reading MUST EXIST__, and it MUST BE A CSV file. You will use "search string" to filter out lines from the first file before you write them to the second file. __The 2nd file you open for writing MUST NOT EXIST__ before you start writing to it.
 
You may solve this homework multiple ways, you can read the entire contents of the first file into memory and then filter, or you can do this more cleverly and elegantly by simulataneously streaming (with an INPUT STREAM) and filter the input of the first file directly into an OUTPUT STREAM for the second file. I will leave this up to your problem solving skills.



## Example Input and operation

1. You have a file called __"traffic-data.csv"__ with the following lines of text:

```
1,8933 South,Commercial Ave,03/07/2006,10500,North Bound: 4900 / South Bound: 5600,41.732725,-87.55132,"(41.732725, -87.55132)"
12,9379 South,Commercial Ave,03/07/2006,12700,North Bound: 6000 / South Bound: 6700,41.724444,-87.551124,"(41.724444, -87.551124)"
13,9730 South,Commercial Ave,03/07/2006,9000,North Bound: 4000 / South Bound: 5000,41.718183,-87.551016,"(41.718183, -87.551016)"
14,4107 South,Cottage Grove Ave,03/30/2006,10800,North Bound: 5600 / South Bound: 5200,41.820171,-87.606798,"(41.820171, -87.606798)"
15,4750 South,Cottage Grove Ave,03/01/2006,14200,North Bound: 7000 / South Bound: 7200,41.807987,-87.606532,"(41.807987, -87.606532)"
16,5325 South,Cottage Grove Ave,02/01/2006,13700,North Bound: 7200 / South Bound: 6500,41.797881,-87.606302,"(41.797881, -87.606302)"
17,6144 South,Cottage Grove Ave,03/01/2006,20900,North Bound: 10300 / South Bound: 10600,41.78269,-87.605979,"(41.78269, -87.605979)"

```

2. Your program prompts the user to enter a CSV file to READ FROM. In this case you enter "./traffic-data.csv".

3. Your program prompts the user to enter "search string". You enter the string "Cottage".

4. Your program prompts the user to enter a CSV file to WRITE TO. The file must not exist. You enter "./output-1.csv".

5. Your program completes and you can open up the file "output-1.csv" You find the following data has been written:

```
14,4107 South,Cottage Grove Ave,03/30/2006,10800,North Bound: 5600 / South Bound: 5200,41.820171,-87.606798,"(41.820171, -87.606798)"
15,4750 South,Cottage Grove Ave,03/01/2006,14200,North Bound: 7000 / South Bound: 7200,41.807987,-87.606532,"(41.807987, -87.606532)"
16,5325 South,Cottage Grove Ave,02/01/2006,13700,North Bound: 7200 / South Bound: 6500,41.797881,-87.606302,"(41.797881, -87.606302)"
17,6144 South,Cottage Grove Ave,03/01/2006,20900,North Bound: 10300 / South Bound: 10600,41.78269,-87.605979,"(41.78269, -87.605979)"
```

What Happened? Well we filterd on the word "Cottage" and only wrote lines of the file that contained this search string. 



## Detailed steps to solve this homework. Including the things I will be grading on.

 1. Ask the user to enter the name of the input file to read from. __This MUST BE A CSV file. The file MUST EXIST.__
 2. If the input file does not exist, continue to prompt the user until you get a valid, existing CSV file.
 3. Ask the user to enter a search string. Just use __scanner.nextLine()__.
 4. Make sure the user entered something at least 3 chars long,  continue to prompt the user for a string at least 3 chars long.
 5. Ask the user to enter a filepath to wrote the file out to. THIS FILEPATH MUST NOT CURRENTLY EXIST.
 6. Make sure the filepath is valid, if a file already exists at this path, prompt the user until they get it right.
 7. Open the file from step 1 for reading. You may read all of the lines into an array of strings OR you open this a an input stream and stream the lines in.
 8. Open the filepath from step 5 for writing. 
 9. __Read each line from the file you opened in step 7.__ Do a string contains search of the line for the search term from step 3.
 10. If you find the line from step 9 contains the search string, print the line to the console AND write the line to file you opened for writing in step 8.
 11. When you are done reading and searching each line, close both of the files.
 12. __Print the number of lines of text you matched and wrote to the console, indicating your results to the user.__
 
 __EACH STEP IS WORTH (12 / 100) POINTS OUT OF 100 points total for the 12 steps__
 
 
