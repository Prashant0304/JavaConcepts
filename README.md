//-------------Concepts of Array------------------------//

Minimum Value in an Array :

Here in this problem, we find the minimum value in an array using
array indexing, comparison operator, for loop, conditional statement,
and the array length method.

Pseudo code :

Step 1 : Initialise the array values

Step 2 : Initialise the first element of the array as min
min = arr[0]

Step 3 : Use a for loop to iterate through the array
from index 0 until the length of the array

Step 4 : Inside the loop, compare the current array element
arr[index] with min

Step 5 : If arr[index] is less than min,
update min with arr[index]

Step 6 : Continue the loop until the last index of the array
is reached

Step 7 : Exit from the for loop

Step 8 : Print the min value

Maximum Value in an Array :

Here in this problem, we find the maximum value in an array using
array indexing, comparison operator, for loop, conditional statement,
and the array length property.

Pseudo code :

Step 1 : Initialise the array values

Step 2 : Initialise the first element of the array as max
max = arr[0]

Step 3 : Use a for loop to iterate through the array
from index 0 until the length of the array

Step 4 : Inside the loop, compare the current array element
arr[index] with max

Step 5 : If arr[index] is greater than max,
update max with arr[index]

Step 6 : Continue the loop until the last index of the array
is reached

Step 7 : Exit from the for loop

Step 8 : Print the max value

Maximum value problem : Same like min max value also find much difference only the oerator changed to less than to greater than

Minmax : combined both problems and used one loop and found min and max value

//-------------Concepts of Array------------------------//

Reverse Array Problem :

Here in this problem we reverse the elements of an array using
array indexing, while loop, conditional operator, array length
method and a temporary variable.

Pseudo code :

Step 1 : Initialise array values

Step 2 : Check whether the array is empty using array.length

Step 3 : If array length is 0, print "Array is empty" and exit

Step 4 : Initialise two variables:
l = 0
r = array.length - 1

Step 5 : Use while loop until l < r

Step 6 : Inside the loop, store the value at right index in a
temporary variable

Step 7 : Assign the value at left index to the right index

Step 8 : Assign the temporary value to the left index

Step 9 : Increment l by 1 and decrement r by 1

Step 10 : Continue the loop until l is no longer less than r

Step 11 : After reaching the middle of the array, exit the loop

Step 12 : Use a for loop to iterate through the array

Step 13 : Print each element of the reversed array

Palindrome String Problem :

Here in this problem, we check whether a given string is a palindrome
or not using string methods, conditional statements, character
comparison, while loop and two-pointer technique.

A palindrome is a string that reads the same from both the beginning
and the end.

Example :

GADAG → G A D A G
↑ ↑
Same

Therefore, GADAG is a palindrome.

Pseudo code :

Step 1 : Initialise the string

Step 2 : Check whether the string is null or empty

Step 3 : If the string is null or empty, print "Given string is empty"
and exit the program

Step 4 : Convert the string to uppercase so that the comparison
becomes case-insensitive

Step 5 : Initialise a boolean variable isPalindrome as true

Step 6 : Initialise two pointers:
l = 0
r = string length - 1

Step 7 : Use a while loop until l < r

Step 8 : Inside the loop, compare the characters at the left
and right positions

         str.charAt(l) != str.charAt(r)

Step 9 : If the characters are not equal: - Set isPalindrome = false - Exit the loop

Step 10 : If the characters are equal: - Increment l by 1 - Decrement r by 1

Step 11 : Continue comparing characters until the pointers
reach the middle of the string

Step 12 : After the loop, check the value of isPalindrome

Step 13 : If isPalindrome is true, print
"The given string is palindrome"

Step 14 : Otherwise, print
"The given string is not palindrome"

Vowel Count in a String :

Here in this problem, we count the number of vowels present in a
given string using string methods, for loop, conditional statements,
character comparison and string length property.

The vowels are:

A, E, I, O, U

Pseudo code :

Step 1 : Initialise the string

Step 2 : Check whether the string is null or empty

Step 3 : If the string is null or empty, print
"The given string is empty" and exit the program

Step 4 : Convert the string to uppercase so that both uppercase
and lowercase vowels can be compared using the same
conditions

Step 5 : Initialise count as 0

Step 6 : Use a for loop to iterate through each character of
the string until the string length is reached

Step 7 : Get the current character using its index

Step 8 : Check whether the current character is a vowel

         If character is A OR E OR I OR O OR U

Step 9 : If the character is a vowel, increment count by 1

Step 10 : Continue the loop until the last character of the
string is reached

Step 11 : Exit from the for loop

Step 12 : Print the total vowel count

Word Count in a String :

Here in this problem, we find the number of words present in a
given sentence using string methods, for loop, conditional
statement, character comparison and string length property.

The basic logic used here is that each space between two words
represents the separation between words.

Therefore:

Number of words = Number of spaces + 1

Pseudo code :

Step 1 : Initialise the string

Step 2 : Check whether the string is null or empty

Step 3 : If the string is null or empty, print
"Given string is empty" and exit the program

Step 4 : Initialise count as 1 because the sentence contains
at least one word

Step 5 : Use a for loop to iterate through each character of
the string until the string length is reached

Step 6 : Get the current character using its index

Step 7 : Check whether the current character is a space

Step 8 : If the current character is a space,
increment count by 1

Step 9 : Continue the loop until the last character of the
string is reached

Step 10 : Exit from the for loop

Step 11 : Print the word count

First Non-Repeated Character in a String :

Here in this problem, we find the first character in a given string
that occurs only once.

We use a frequency array to store the number of times each character
appears in the string.

The program uses:

- String methods
- Character indexing
- For loop
- Conditional statement
- Frequency array
- Character comparison

Pseudo code :

Step 1 : Initialise the string

Step 2 : Check whether the string is null or empty

Step 3 : If the string is null or empty, print
"String is empty" and exit the program

Step 4 : Initialise an integer array of size 255
to store the frequency of each character

Step 5 : Convert the string to uppercase

Step 6 : Use the first for loop to iterate through each
character of the string

Step 7 : Get the current character using str.charAt(index)

Step 8 : Use the character as an index of the frequency array
and increment its count

         arr[str.charAt(i)]++

Step 9 : After storing the frequency of every character,
use another for loop to iterate through the string
from the beginning

Step 10 : For each character, check its frequency in the array

Step 11 : If the frequency of the character is equal to 1,
the character is non-repeated

Step 12 : Print the character

Step 13 : Break the loop because we only need the first
non-repeated character

Step 14 : If no character has frequency equal to 1,
then there is no non-repeated character

Second Largest Element in an Array :

Here in this problem, we find the second largest element in an
array using array indexing, for loop, conditional statements,
comparison operators and Integer.MIN_VALUE.

We use two variables:
largest
secondLargest

The largest variable stores the largest element found so far,
while secondLargest stores the second largest element found so far.

Pseudo code :

Step 1 : Initialise largest as Integer.MIN_VALUE

Step 2 : Initialise secondLargest as Integer.MIN_VALUE

Step 3 : Initialise the array values

Step 4 : Use a for loop to iterate through each element of the array

Step 5 : Compare the current array element with largest

Step 6 : If arr[index] is greater than largest: - Assign the current largest value to secondLargest - Update largest with arr[index]

Step 7 : Otherwise, check whether arr[index] is greater than
secondLargest and not equal to largest

Step 8 : If the condition is true: - Update secondLargest with arr[index]

Step 9 : Continue the loop until the last element of the array
is reached

Step 10 : After the loop, check whether secondLargest is still
equal to Integer.MIN_VALUE

Step 11 : If secondLargest is Integer.MIN_VALUE,
print "There is no second largest element"

Step 12 : Otherwise, print the secondLargest value

Second Smallest Element in an Array :

Here in this problem, we find the second smallest element in an
array using array indexing, for loop, conditional statements,
comparison operators and Integer.MAX_VALUE.

We use two variables:
smallest
secondsmallest

The smallest variable stores the smallest element found so far,
while secondsmallest stores the second smallest element found so far.

Pseudo code :

Step 1 : Initialise smallest as Integer.MAX_VALUE

Step 2 : Initialise secondsmallest as Integer.MAX_VALUE

Step 3 : Initialise the array values

Step 4 : Use a for loop to iterate through each element of the array

Step 5 : Compare the current array element with smallest

Step 6 : If arr[index] is less than smallest: - Assign the current smallest value to secondsmallest - Update smallest with arr[index]

Step 7 : Otherwise, check whether arr[index] is less than
secondsmallest and not equal to smallest

Step 8 : If the condition is true: - Update secondsmallest with arr[index]

Step 9 : Continue the loop until the last element of the array
is reached

Step 10 : After the loop, check whether secondsmallest is still
equal to Integer.MAX_VALUE

Step 11 : If secondsmallest is Integer.MAX_VALUE,
print "No second smallest value in given array"

Step 12 : Otherwise, print the secondsmallest value

Start
↓
smallest = Integer.MAX_VALUE
secondsmallest = Integer.MAX_VALUE
↓
Start loop
↓
Is arr[i] < smallest?
/ \
 Yes No
↓ ↓
secondsmallest Is arr[i] < secondsmallest
= smallest AND arr[i] != smallest?
↓ / \
smallest = arr[i] Yes No
↓ ↓
secondsmallest Continue
= arr[i]
↓
Continue loop
↓
End of loop
↓
Is secondsmallest == Integer.MAX_VALUE?
/ \
 Yes No
↓ ↓
No second smallest Print second smallest
