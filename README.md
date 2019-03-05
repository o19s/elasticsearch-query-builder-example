## Demo Elasticsearch Query Builder Plugin

A plugin for a query builder that searches terms backwards. 

| Not intended for production use, rather as an example/starting point for your own code. |
| --- |

## To build

1. Ensure Java 11 is installed, and in your java home*
2. Build with `./gradlew clean check`

### *Use Dot Env to manage different java environments
I personally use [dotenv](https://github.com/motdotla/dotenv) to manage different Java versions across my Elasticsearch, Solr, and Lucene development.

## To Install 

1. Download and unpack Elasticsearch 6.5.2
2. Run `elasticsearch-plugin install` to install the plugin

```
./bin/elasticsearch-plugin file:///Users/doug/ws/hello-world-plugin/build/distributions/backwards-1.1.0-es6.5.2.zip 
```

## Open in IntelliJ or Eclipse

1. Run `./gradlew idea`
2. Open (dont import) the directory into IntelliJ

(or in Eclipse import as Gradle Project)

## To Debug

Set Java options on command line

```
export ES_JAVA_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
./bin/elasticsearch
```

Attach the IDE to port 5005 remote debugger if debugging the plugin is desired

## Try it out...

In Sense / Kibana Dev Tools, run the following example

```
PUT test/doc/1
{
    "tweet": "hello I am dog"
}

PUT test/doc/2
{
    "tweet": "hello I am god"
}

GET test/_search 
{
    "query": {
        "backwards": {
            "query": "dog",
            "field": "tweet"
        }
    }
}
```
