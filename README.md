# StringCalculator

## Overview
This is a TDD (Test-Driven Development) exercise for implementing a simple string calculator.

## Steps to Implement

### Step 1: Basic Addition
Create a method with the following signature:

```java
int add(String numbers)
```

- **Input:** A string containing numbers separated by commas.
- **Output:** An integer representing the sum of the numbers.

#### Examples:
```java
add("")       // Output: 0
add("1")      // Output: 1
add("1,5")    // Output: 6
```

### Step 2: Handle Multiple Numbers
Modify the method to handle an arbitrary number of values.

### Step 3: Support New Line as a Delimiter
Allow newline characters (`\n`) as valid delimiters in addition to commas.

#### Example:
```java
add("1\n2,3")   // Output: 6
```

### Step 4: Support Custom Delimiters
Enable support for custom delimiters defined at the beginning of the string.

#### Format:
```
//[delimiter]\n[numbers...]
```

#### Example:
```java
add("//;\n1;2")   // Output: 3
```

- Any character can be used as a delimiter.
- Multiple delimiters can be supported if enclosed in square brackets (`//[*][%]\n1*2%3` should return `6`).

### Step 5: Handle Negative Numbers
- If the input contains negative numbers, throw an exception.
- The exception message should list all negative numbers.

#### Example:
```java
add("1,-2,3,-4")
// Exception: "Negative numbers not allowed: -2, -4"
```

### Additional Considerations
- Numbers greater than `1000` should be ignored.
- Custom delimiters of any length should be supported (e.g., `//[***]\n1***2***3` should return `6`).

## Running Tests
Ensure that unit tests cover all the above scenarios for correctness and robustness.

