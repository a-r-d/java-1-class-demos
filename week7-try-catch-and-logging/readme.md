# Week 7

  Try Catch, logging.

## Agenda

 1. Try/catch powerpoint  
  1. how to do logging, why you want to log errors
  2. what is the Cutilities.java class?
  3. errors: class name, line number, error message, exception class name, stack trace.
 2. try / catch / finally.
  1. what order do they fire in?
 3. What is an actual logging framework?
  1. Logback
  2. Log4J
  3. I highly recommend you use an open source library, and don't waste time writing this yourself.
 4. JForm
  1. JButton
  2. JLabel
  3. ActionListener
  4. Event based programming.


### Try/Catch Logging Examples

  1. try/catch basics - throw number format exceptions from scanner
  2. print error, stack trace.
  3. think very critically about what errors mean and how you should log them
  4. When does it make sense to use finally: closing resources - doing additional Logging. Doing things you ALWAYS want to do.
  5. If you have a site that gets 100 hits / day and 1 / 1000 hits causes an error you get an error every 10 days.
  6. If you have a site that gets 1000000 hits a day and 1 / 1000  hits causes an error, you get an error 1000 times per day. What do you do here?
  7. Data dependent errors are easier to solve with web applications: you can log ids for records and then go look at the data.

### JForm / JButton / JLabel / ActionListener example.

  Do class demo of the random form.
  
  
  
# Philosophy Of Exceptions in Java

In java there are two types of exceptions: __checked__ and __unchecked__. The general rule that you may want to follow is this: _if an exception can be expected, and be recovered from by your program, make it checked. If it cannot be recovered from, make it an unchecked exception_. Also, keep in mind that all exceptions will implement ["throwable"](https://docs.oracle.com/javase/7/docs/api/java/lang/Throwable.html). 

[Check out more detail here](http://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/). And read [Oracle's docs on unchecked exception controversy here](http://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html). 

### Examples of UnChecked Exceptions:

- RuntimeException
- Error
- NullpointerException
- ArithmeticException

### Examples of Checked Exceptions:

- Exception
- IOException
- [XPathException](https://docs.oracle.com/javase/7/docs/api/javax/xml/xpath/XPathException.html)
- [SAXException](https://docs.oracle.com/javase/7/docs/api/org/xml/sax/SAXException.html)

## Extending exception classes

If you want to make a checked exception, you should extend "Exception" class. If you want to make an unchecked exception you can extend "RuntimeException". 
  
