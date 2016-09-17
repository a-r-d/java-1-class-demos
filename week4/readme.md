# Welcome to week 4

![Strings](./strings.jpg)

## Review Agenda

 1. What have we covered so far?
  1. data types
  2. boolean expressions
  3. logical Operators
  4. conditional logic
  5. loops
  6. arrays
 2. How is the homework going?
  1. review of homework for week 3.
  2. review of homework for week 4.
 3. More on arrays.
  1. a sorting algorithm coded out (Bubble sort or Insertion sort because it is easy to code (they are not efficient))
  2. Inserting elements into arrays
  3. resizing arrays
  4. removing elements from arrays
  5. making arrays so large that the memory is consumed and your program crashes

## New Content Agenda

  Strings are probably one of the most important things to have a good grasp on how to manipulate if you are
  going to be programmer. You will routinely be parsing and converting data stored or transfered as text. HTTP is a text based transfer protocol and you do parsing and encoding on either end. Maybe the format is HTML, XML, JSON, or whatever, but somewhere under the hood we are manipulating text.  

  People used to use binary formats a lot. They do not as much anymore, computers are faster, have more memory, and networks have more bandwidth. Compressed text is not significantly larger than binary formats so now everyone uses gzipped HTTP to talk between servers where they may have used binary before. Humans can read text, not binary. Text makes debugging so easy when you can clearly read messages being passed.  

 1. Strings Background
  1. What is a string
  2. What is an object
  3. How do you create strings
  4. How do strings work in memory?
  5. What is immutability? (instances cannot be modified. How does this play out in practice?)
 2. Doing cool things with Strings
  1. instantiate
  2. compare (what is equals, what is hashcode, how is hashcode used?)
  3. to char arrays
  4. split by a char
  5. join strings or char array back into strings
  6. substring, indexOf
  7. replace  (string is immutable, so how does this work?)


## Examples of real String problems

 - Parsing user agent
 - Parse and extract HTTP headers (always text) into some other format.
 - Parse an email from a large text file with RegEX
 - parse a phone number ''
 - XML is a text format
 - JSON actually has data types, but only a few
 - HTTP is all text, each side needs to parse strings and know the content type.
 - Reading in a log file, pulling out timestamps and error codes, compiling stats
 - taking output of a command line program, parsing the result as strings, and emailing it to somebody (e.g. a server error occurs and you need to notify)
 - Searching through log files using regular expressions (e.g. grep for "error", this is a string operation)
 - Formatting numerics into strings
 - Templating systems
