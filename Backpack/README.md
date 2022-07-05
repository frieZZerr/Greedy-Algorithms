# The Knapsack Problem
> _"Every thief needs to have the basic knowledge of **The Knapsack Problem**..."_ ~ ***Ghandi***

![Ghandi with a backpack](https://github.com/frieZZerr/Greedy-Algorithms/blob/main/Backpack/mahatma_ghandi_with_a_backpack.jpg)

---

### What's the problem?
> "The knapsack problem is a problem in combinatorial optimization: Given a set of items, each with a weight and a value, determine the number of each item to include
> in a collection so that the total weight is less than or equal to a given limit and the total value is as large as possible."

<sub>Source: ***wikipedia.org***</sub>

### How does it work?
We simply pick the items that have **best proportions** _( item.value/item.weight )_. The higher the proportion's value, the more valuable the item is ***(at the moment!)***. After we found the _"best item"_, we check if there's space for it in the Knapsack and either we **add it** or **remove it** _(if there's not enough space for it)_.

### Data input
Data format is simple: ***item_weight [whitespace char] item_value***, e.g **( 3 120 )**.

<sub>You can set the Knapsack size [here](https://github.com/frieZZerr/Greedy-Algorithms/blob/main/Backpack/Backpack.java#L11) or change the data file [here](https://github.com/frieZZerr/Greedy-Algorithms/blob/main/Backpack/Backpack.java#L75).</sub>
