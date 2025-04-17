# path-and-query-param

## Problem

* There is an own type `StringType` which contains a `String` property
    * Has protected constructors
    * Has a `fromString` method
* For a REST call the `fromString` method is not used, but the constructor
* The call fails, because the constructor is `protected`

### The error:

```

```

## Steps to reproduce the problem