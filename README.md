ausregistryhomework1
====================

Simple Domain Registraiton price list for AusRegistry Group

Overview
-----------
This is an assignment for Ausregistry to calculate the purchases of domains

Justifications
--------------
The concept of the project was fairly simple building a basic calculator.
I initially thought it would be easy to implement a
MAP<Domain_name,Price_per_year> style function, giving a fairly basic container to
hold a domain name and its price. However I also thought this was NOT scalable, in the event
should a domain object contain more information in the future. An example of this could
be that the domain now carries with it billing information, country for the suffix etc.

As such I developed new classes such as
Domain
PremiumDomain (subclass of Domain)
DomainRequests

And held most of my data via `Map<String domainName, Domain>`

This gave me the power of O(1) search using HashMap via domain name, and accessed all information
to the domain object.


Things to improve on
---------------------
I unfortunately did this assignment late in the evening as I was fairly busy tonight.
If I had additional time I would have implemented flags that would allow file input.

One concept would have been allowing users to use flags like the below example

`java -jar domainregistrar.jar -z <zonefile> -p <premiumzonesfile> -r <requesteddomains>`

How to build
------------
I built this Domain registrar calculator using the awesomeness of Maven.
So if you have maven installed on your computer, all you have to do is the following commands
at the root project folder (where reagrouprobot folder exists)

`mvn clean compile assembly:single`

This will compile an executable JAR with all dependencies pre-packaged
* `domainregistrar\target\domainregistrar.jar`

with the main function in com.winnergenic.ausregistry.domain.DOMAINREGISTRAR already referenced to in the MANIFEST.MF file

How to run
----------
From the target folder where the `domainregistrar.jar` file is, you can 
run the calculator by

`java -jar domainregistrar.jar`

Then follow the prompts via command line input.
The order of execution is in the following format

* Input Zone Domains with yearly prices
* Input Premium Domains with yearly prices
* Input domain requests with years requested

eg.

```
=======================================================
=	AUSREGISTRY ASSIGNMENT 1
=======================================================


Step 1. Zone Domains
Please enter all zone domains with their prices per year. If duplicates are found, the LAST entry will be considered
When complete just press ENTER
eg - .com,10
```
<b>.com,10
.net,9
.com.au,20</b>

```
Step 2. Premium Domains
Please enter all PREMIUM domains with their prices per year. If duplicates are found, the LAST entry will be considered
When complete just press ENTER
eg - apple.com.au,10
```
<b>apple.com.au,1000
dict.com,800
education.net,300</b>

```
Step 2. Domain Requests
Please enter all domain requests with the years you would like to have them for. If duplicates are found, the LAST entry will be considered
When complete just press ENTER
eg - dict.com,1
```
<b>a-domain.com,1
another-domain.net,2
dict.com,5</b>

<emp>$4028.00</emp>


Attributions
-------------
* Apache Maven - http://maven.apache.org/license.html
* JUnit 4.10 - http://junit.org/
* log4j 1.2.14 - http://logging.apache.org/log4j/1.2/
* commons-io 2.4 - http://commons.apache.org/proper/commons-io/
* commons-lang 2.4 - http://commons.apache.org/proper/commons-lang/

Thanks
-------
Finally I'd like to say thanks for the opportunity to participate in this assessment task.
I had quite a lot of fun putting it together and continually find new ways to improve the robot.
Whether it be through fun easter eggs, by letting the robot make complaints (when asked to move off
the table), or possibly causing the robot to self-destruct.
Ultimately, I dreamed of wanting to name this robot 'terminator 2000' and allowing it to resurrect itself 
with catchy phrases like 'I'll be back', 'its NOT a tumor!' or 'get to da choppa!!!'

I had a lot fun and I sincerely thank the REA group for the opportunity and hope to hear
your feedback soon.

Alwin Chin

alwin.chin@gmail.com
