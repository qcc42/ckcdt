#  Code test - Mortage plan

The new customer centric bank Money Bin Inc. in Duckburg would like to have a new product on the market. For that they need your help! There is a demand from their customers that they want to be able to borrow money and get to know the exact amount they have to pay each month over a period of time.

The CEO of the bank has given the requirement like this:

"Given a total loan of X € and a fixed yearly interest rate of Y %. The customer wants to pay the same amount each month for Z years. How much should the customer pay each month to pay off the whole debt?"

Your task is to create a Java application that reads the attached file and print out the result for each customer given the formula below.

**Mortage formula:**

- E = Fixed monthly payment
- b = Interest on a monthly basis U = Total loan
- p = Number of payments

 `E = U[b(1 + b)^p]/[(1 + b)^p - 1]`

Output for each customer should look like:

> Prospect 1: CustomerName wants to borrow X € for a period of Z years and pay E € each month 

## Requirements
- A build tool used to compile, build, test and run project, such as Gradle or Maven
- Readme of how to start the application
- Unit test for testing application logic
- Usage of java.math or similar math dependencies are not allowed

### Optional

These parts are not mandatory, but gives a great advantage especially when there are many applicants. Since Docker may be a technology you have never worked with, there is a small educational block at the end of this document.
- Create a Dockerfile which can be used to build an Docker image for running this application
- Create a web interface where the user can view all prospect calculations and enter new prospect data
- Publish application in a public cloud service (such as AWS) and add a link to it in the Readme file


## How to get help

Follow this article: [how to get help](https://help.alvalabs.io/en/articles/9028899-how-to-ask-for-help-with-coding-tests) if you run into an issue with your coding test.

## When you are done

1. [Create a new Pull Request](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request) from the branch where you've committed your solution to the default branch of this repository. **Please do not merge the created Pull Request**.
2. Go to your application in [Alva Labs](https://app.alvalabs.io) and submit your test.


## Education
**Docker**

Docker is a technology used for building and running images of virtual machines. Usually a Dockerfile is created to define our images. In such a file, you can define a base image with an operating system image, and various commands that need to be run to configure our image correctly, such as install python or Java. If our image should run a certain program we can define an entrypoint which initiates that program when the image is run as a container.

**Docker Compose**

Compose is a tool for defining and running multi-container Docker applications. You do not need to use Docker Compose for this task, but it is quite convenient if you want to run your application as one container and your database in another. An example of a docker compose file running a DB and an application can be found here.
