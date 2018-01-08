Java Split Speedup
==================

Comparing performances between string.split() and regex.split() in Java.


## Objective

This app will generate a string with randomly-generated key-value pairs and calculate the average time it took to parse them into a Map.

Key-value pairs are pipe delimited, and each pair is delimited by a tab. e.g., 

```
key1|value1\tkey2|value2|...
```

The number of pairs will change to see overall performance on an array of entry sizes and complexity.

Each test will run 1 billion times before taking the average time and printing the result to screen.

Time is printed out in nanoseconds.  

## Executing
```
./gradlew run
```


