# kata-back-to-checkout
This is the base project/settings for the kata inspired in 'back to checkout' by Dave Thomas (@PragDave)(http://codekata.com/kata/kata09-back-to-the-checkout/)

## How to kata?
- First of all: Split all participants in pairs (more people is allowed in a group so nobody is left alone), any pair/group should be formed by people who do not usually code together.
- The exercise is splitted in iterations which resemble real-life sprints or periods of time, every iteration adds up requirements to the base exercise.
- Every iteration is composed by 5-minute periods where only one developer is allowed to code (ideally each group will work on one computer).
- It is advised to not read the following iterations as you may ruin the element of surprise (in real-life scenarios we never know when or how requirements change)
- After every iteration we must code review all groups 
## What do you need?
- IntelliJ IDEA
- Scala Plugin for IntelliJ (https://www.jetbrains.com/help/idea/discover-intellij-idea-for-scala.html)

For online katas, you might consider adding:
- Teamhub Plugin for IntelliJ (https://plugins.jetbrains.com/plugin/11955-teamhub)
# Exercise
We need to improve the checkout system of an existing fruit store, it currently supports the most basic things: 
- It has a cart where the user can add an item with a price.
- It calculates the total amount the customer has to pay.
- To reduce complexity, assume all numbers are positive and the total will never reach a number you can't process. 
## Iteration 1
After serious considerations from the research team, we are required now to add the following feature to our program:
### Promotions by bulk
If a customer reaches a certain amount of the same item, the calculation will change according to bulk price rules. 
Example rules with expected cart results:

| Item   |      Price      |  Bulk Price |
|----------|:-------------:|------:|
| Pear |  10 | 2 for 18 |
| Apple |    20   |   3 for 50 |
| Banana | 15 |    no bulk price |

- Cart with 1 pear: $10
- Cart with 2 pears in a row: $18
- Cart with 3 pears: $28
- Cart with 1 pear, 1 apple, 1 pear: $38
- Cart with 1 pear, 3 apples, 1 pear: $68
- Cart with 10 bananas: $150
## Iteration 2
The previous feature was well-received the first week but after customer complaints and sellers losing money, our research 
painfully found out those promotions don't last forever or they don't apply all the time. We need to make a change to address 
this by adding some kind of flexibility to the software.
### Time-locked promotions
For simplicity, in this exercise we'll apply promotions based on which day the customer buys fruits.
Example rules with expected cart results:

| Item   |      Price      |  Bulk Price |  When it applies |
|----------|:-------------:|------:|:-------------:|
| Pear  |    10 | 2 for 18 | Everyday|
| Apple |    20   |   3 for 50   |Monday|
| Apple |    20   |   30 for 450 |Friday|
| Banana |   15   | no bulk price |-|

- Cart with 1 pear, 3 apples, 1 pear on Monday: $68
- Cart with 1 pear, 3 apples, 1 pear on Tuesday: $78
- Cart with 30 apples on Monday: $500
- Cart with 30 apples on Wednesday: $600
- Cart with 30 apples on Friday: $450
- Cart with 31 apples on Monday: $520
- Cart with 31 apples on Wednesday: $620
- Cart with 31 apples on Friday: $470
## Iteration 3
Our previous changes were a big success, our fruit store is so big now that we need to implement special discounts and 
different ways to process prices depending on the type of customer (Regular, Premium, International, etc)
### Different rules for different users
The system must be flexible enough to allow the seller to switch rapidly discount types for a new cart. Note: sets of 
rules only apply to one kind of user, there are no shared or inherited rules.

Example rules for a premium user:

| Item   |      Price      |  Bulk Price |  When it applies |
|----------|:-------------:|------:|:-------------:|
| Pear  |    10 | 2 for 18 | Everyday|
| Apple |    20   |   3 for 50   |Everyday|
| Banana |   15   | 10 for 120 |Everyday|

Example rules for an international user:

| Item   |      Price      |  Bulk Price |  When it applies |
|----------|:-------------:|------:|:-------------:|
| Pear  |    10 | 100 for 700 | Everyday|
| Apple |    20   | 100 for 1500   |Sunday and Saturday|
| Banana |   15   | 100 for 1000 |Everyday|

Example cart results:
- Cart with 100 bananas for a regular user: $1500
- Cart with 100 bananas for a premium user: $1200
- Cart with 100 bananas for an international user: $1000

# Objective of this kata
The main objective of this exercise can be synthesized in one word: Decoupling. 

While doing this exercise, you'll see that depending on how the participants evolved they'll be forced to refactor their 
code a couple of times to address this common occurrence. Taking a bit more of time to think about making our code decoupled,
will influence positively in the long run as it will save us time when we'll really need to.
# Author

Edgar Davila - Initial work
