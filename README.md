![status: inactive](https://img.shields.io/badge/status-inactive-red.svg)

This project is no longer actively developed or maintained.  

For new work on this check out the [Java](https://github.com/GoogleCloudPlatform/java-docs-samples/tree/master/bigquery) or [Python](https://github.com/GoogleCloudPlatform/python-docs-samples/tree/master/bigquery) documentation samples repositories.


## bigquery-samples

Sample code documenting usage of [Google BigQuery](https://cloud.google.com/bigquery/) using the [BigQuery Client Libraries](https://cloud.google.com/bigquery/client-libraries)

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/bigquery-samples-python.svg)](https://travis-ci.org/GoogleCloudPlatform/bigquery-samples-python)

## Setup

1. [Setup a project to use Google BigQuery](https://cloud.google.com/bigquery/sign-up) if you haven't already.

2. [Generate a private key (JSON format)](https://cloud.google.com/storage/docs/authentication#generating-a-private-key) for your account.

3. Make an environment variable:
   ```
    export GOOGLE_APPLICATION_CREDENTIALS=<path>/<to>/<your>/<private-key>
   ```


## Run

### Python

From the `python/` directory run

```
pip install -r requirements.txt
```

Then to run a sample, simply use the interpreter

```
$ python
>>> from samples import <sample-of-your-choice>
>>> <sample-of-your-choice>.main()
```

### Java

Install [Maven version 3.10 or later](http://maven.apache.org/index.html) and from `java/` run

```
mvn clean install -Dmaven.test.skip=true
java src/main/java/com/google/cloud/bigquery/samples/<sample-of-your-choice>.java
```


## Contributing changes

* See [CONTRIBUTING.md](CONTRIBUTING.md)


## Licensing

* See [LICENSE](LICENSE)
