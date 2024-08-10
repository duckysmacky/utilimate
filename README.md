# UtiliMate

![build](https://github.com/duckysmacky/utilimate/actions/workflows/build.yml/badge.svg)
![deploy](https://github.com/duckysmacky/utilimate/actions/workflows/deploy.yml/badge.svg)
![version](https://img.shields.io/badge/version-0.2.0-blue)

The ultimate Java utility library to streamline development and reduce boilerplate code

## About

UtiliMate is a comprehensive Java utility library designed to simplify and accelerate the development process.
Inspired by the ease of use of _Python’s built-in functions_, it provides a wide array of **static**
methods that handle common programming tasks.

The library provides functions for collection, list and map processing, as well as numerical operations,
reducing the need for repetitive boilerplate code, enhancing productivity and code readability.

It is especially useful for developers who want to write clean, maintainable code without having to 
reinvent the wheel for everyday tasks. With its wide arrange of features and easy to use API, UtiliMate aims 
to make Java programming more enjoyable and efficient.

*still very work in progress*

## Install

### Maven

1. Add GitHub Packages to `repositories` in `POM.xml`:

```xml
<repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/duckysmacky/utilimate/</url>
</repository>
```

2. Add the package to `dependencies` in `POM.xml`:

```xml
<dependency>
  <groupId>io.github.duckysmacky</groupId>
  <artifactId>utilimate</artifactId>
  <version>0.2.0</version>
</dependency>
```

### Gradle

1. Add GitHub Packages to `repositories` in `gradle.build`:

```groovy
maven {
    url = uri("https://maven.pkg.github.com/duckysmacky/utilimate")
    credentials {
        username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
        password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
    }
}
```

*You can generate a token in your [account settings page](https://github.com/settings/tokens)*

2. Add the package to the dependencies in `build.gradle`:

```groovy
implementation 'io.github.duckysmacky:utilimate:0.2.0'
```

## Features

### Collection Utilities

- `min()` - Finds the smallest value in a given collection
- `max()` - Finds the biggest value in a given collection
- `sum()` - Finds the sum of all values in a given collection
- `all()` - Checks values in a collection for being valid (true or not null)
- `any()` - Checks for at least one value in a collection being valid (true or not null)

### List Utilities

- `countOccurrences()` - Counts how many times each unique value appears in a given list

### Map Utilities

- `sortByValue()` - Sorts a given map by its values based on a given order
- `sortByKey()` - Sorts a given map by its keys based on a given order

### Number Utilities

- `min()` - Finds the smallest number within given number varargs
- `max()` - Finds the biggest number within given number varargs
