# Week 12 - Maven + Libraries

[Related youtube video playlist](https://www.youtube.com/playlist?list=PLWRvoIK5KFylpbX_0dFKre1SRhvRFHIwJ)

## Agenda

 - Go over homework last week
 - Any review we need to do.
 - Libraries Intro
 - Maven intro
 - In class lab: get Maven working with OkHttp, and download data from a Google trends API.
 - In class lab: get HSQLDB working. We will use this for next week's assignment.

## What is a library ?

A library is code that is meant to be packaged up and reused across multiple projects. You don't want to re-write the code, and you don't want to copy and paste it everywhere, so you bundle the common code up in a "library" project.

### Examples of Libraries

 - [Apache Commons Lang - lots of utility methods](https://commons.apache.org/proper/commons-lang/)
 - [Logback - a logging framework](http://logback.qos.ch/)
 - [OkHttp - an HTTP client for Java, it auto gzips and caches requests](http://square.github.io/okhttp/)
 - [JUnit - a Java Unit Testing system - you test your code with it](http://junit.org/junit4/)
 - [HSQLDB - a 100% Java in-memory database](http://hsqldb.org/)
 - [H2 Database Engine - another 100% Java embedded database](http://www.h2database.com/html/main.html)
 - [Java MySQL driver library - you have to use this to connect with MySQL](https://www.mysql.com/products/connector/)
 - [Java MSSQL driver library - ditto, with Microsoft MSSQL db](https://msdn.microsoft.com/en-us/library/mt484311(v=sql.110).aspx)


### How can I use these Libraries ?

Well, basically there are two ways. **One**: you download a ".jar" file and include it in your project. **Two**: you use a _dependency management system_ such as **Maven** (by the way, there are others, and every language has them).


### Okay, Jars sound easy, why use Maven, it sounds complicated?

Actually, Maven is a bit easier because it downloads your jar files for you. Yep, that is right, Maven downloads the jar files for you and includes them in your project and builds them together (it puts them on the _classpath_) with it so that you can access your library classes.


### How does maven work?

Maven needs three things to work. GroupId, artifactId, and version number. Let's take a look at how we would include OkHttp.

```xml
<dependency>
  <groupId>com.squareup.okhttp3</groupId>
  <artifactId>okhttp</artifactId>
  <version>3.4.2</version>
</dependency>
```

Where do you get this stuff? Usually it will be right on the project's website so you can copy + paste. If it is not, go to [Maven central](http://search.maven.org/) and search on it.


### In Class Lab 1

Create a new project. Right click on it and do "configure...". Click "convert to Maven project" from the menu. You will get a new file called "pom.xml". The pom is what is used to configure maven. Open this and flip to "dependencies" tab.  Now, you can add in the OkHttp dependency above.  

```java

package week12;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Okhttpexample {

	public static OkHttpClient client = new OkHttpClient();

	public static void main(String[] args) throws Exception {
		// I found this URL in this node library:
		// https://github.com/pat310/google-trends-api/blob/master/src/utils/hotTrends.js

		String result = run("http://hawttrends.appspot.com/api/terms/");
		System.out.println(result);
	}

  // you can do this in vanilla java but a good library makes it WAY WAY WAY easier!
	private static String run(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

}
```
