## Demo Elasticsearch Query Builder Plugin

A plugin for a query builder that searches terms backwards. 

| Not intended for production use, rather as an example/starting point for your own code. |
| --- |

## To build

1. Ensure Java 11 is installed, and in your java home*
2. Build with `./gradlew clean check`

### *Use Dot Env to manage different java environments
I personally use [dotenv](https://github.com/motdotla/dotenv) to manage different Java versions across my Elasticsearch, Solr, and Lucene development.

## Open in IntelliJ

1. Run `./gradlew idea`
2. Open (dont import) the directory into IntelliJ
