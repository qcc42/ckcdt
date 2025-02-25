#  How to run
Pre-requisites:

maven

docker

How to run:

```
$ mvn package
$ docker build -t ckcdt .
$ docker run -p 8080:8080 ckcdt
```

Open browser

Go to http://localhost:8080/input

Cloud version can be found here: https://ckcdt.onrender.com/input
