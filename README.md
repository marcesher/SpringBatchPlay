# Introduction

This project contains a full sample for reading a CSV file, populating a Grails domain object, and persisting it to the DB. This example uses H2.

It is a work in progress.

# Bugs

Currently, I'm hitting a significant problem: if an error occurs during file reading -- for example, if the file ends with an empty line -- the execution thread hangs and the job gets stuck. In the stacktrace.log I see:

```2012-10-15 08:14:36,017 [SimpleAsyncTaskExecutor-7] ERROR StackTrace  - Full Stack Trace:
java.lang.NumberFormatException: For input string: "1B"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:492)
	at java.lang.Integer.<init>(Integer.java:677)
	at org.fusesource.jansi.AnsiOutputStream.write(AnsiOutputStream.java:114)
....
	at org.slf4j.impl.GrailsLog4jLoggerAdapter.logMessage(GrailsLog4jLoggerAdapter.java:191)
	at org.slf4j.impl.GrailsLog4jLoggerAdapter.error(GrailsLog4jLoggerAdapter.java:166)
	at org.apache.commons.logging.impl.SLF4JLog.error(SLF4JLog.java:213)
	at java.lang.Thread.run(Thread.java:722)
```

## Configuring and Running the Application

First, props to John Rengleman (https://github.com/johnrengelman/grails-spring-batch) for the Spring Batch plugin and the sample project on which this is based.


* From the grails shell, run the command
```    create-batch-tables h2
```

* After that start the application (grails run-app), you will find it at http://localhost:8080/SpringBatchPlay/
* Check db tables were created.  Go to dbconsole at http://localhost:8080/SpringBatchPlay/dbconsole/.
* Substitute jdbc string to connect to the devDb: jdbc:h2:mem:devDb;MVCC=TRUE.
* Connect and make sure a bunch of tables that start with BATCH* exist.   All of the tables will have zero entries until the first run.
* Run Included Simple Job.  Go to console, http://localhost:8080/spring-batch-test/console.  Type in or paste the following code into console window:  


```
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder

simpleJob = ctx.simpleJob
ctx.jobLauncher.run(simpleJob,
  new JobParametersBuilder().addDate("date", new Date()).toJobParameters()
);
```

After pressing execute, you can go to the application console (i.e. shell), and you should see text "Starting Job" along with additional debug output.

* See run record in the db.   Running select queries on batch tables will now show you information written about the run.
* From the dbconsole, run `select * from TABLE_ONE;` to see your records persisted.