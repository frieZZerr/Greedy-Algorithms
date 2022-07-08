# The Knapsack Problem
> _"Every thief needs to have the basic knowledge of **The Knapsack Problem**..."_ ~ ***Ghandi***

![Ghandi with a backpack](https://github.com/frieZZerr/Greedy-Algorithms/blob/main/Backpack/mahatma_ghandi_with_a_backpack.jpg)

---

### What's the problem?
> "The knapsack problem is a problem in combinatorial optimization: Given a set of items, each with a weight and a value, determine the number of each item to include
> in a collection so that the total weight is less than or equal to a given limit and the total value is as large as possible."

<sup>Source: ***wikipedia.org***</sup>

### How does it work?
We simply pick the items that have **best proportions**:

```java
double proportion = item.value/item.weight
```
<sup>*The higher the proportion's value, the more valuable the item is ***(at the moment!)***.</sup>

To find the _"best item"_ we'll use `findItemWithBestProportion`:

```java
static Item findItemWithBestProportion( List<Item> items, Backpack b ) {
    //  We create temporary item with the possibly lowest proportion
    Item temp = b.new Item( 1, 0 );

    for( Item i : items ) {
        if( temp.getProportion() < i.getProportion() )
            temp = i;
    }
    return temp;
}
```

After we found the _"best item"_, we check if there's space for it in the Knapsack and either we **add it** or **remove it** _(if there's not enough space for it)_:

```java
//  Checking if there's enough space left ...
if( current_capacity+bestItem.getWeight() <= max_capacity ) {

    bestItems.add( bestItem );
    current_capacity += bestItem.getWeight();

    items.remove( bestItem );
}
else {
    items.remove( bestItem );
}
```
### Data input
Data format is simple: `item_weight [whitespace char] item_value`, e.g.:

```
5 120
```

<sup>You can set the Knapsack size [here](https://github.com/frieZZerr/Greedy-Algorithms/blob/main/Backpack/Backpack.java#L11) or change the data file [here](https://github.com/frieZZerr/Greedy-Algorithms/blob/main/Backpack/Backpack.java#L75).</sup>

### Example output for `data1.txt`:

```
Best Value: 680
Weight: 3	Value: 185
Weight: 1	Value: 60
Weight: 2	Value: 50
Weight: 5	Value: 120
Weight: 2	Value: 45
Weight: 10	Value: 200
Weight: 1	Value: 20
```
