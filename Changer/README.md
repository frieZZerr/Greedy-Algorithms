# The problem of spending change

![money](https://user-images.githubusercontent.com/105242009/178106970-2ad8e722-b296-4064-aefb-c014fae2fa3b.jpg)

### Quick explanation

If you somehow end up as a cashier in some grocery store, it would be in your best interest to know about this algorithmic issue.
The base goal is to, from the `given cash`, change it by giving back `the lowest possible amount of coins/banknotes`.

For example:

`We receive an amount of 325$`
---
We're giving back:
- `3 times 100$`
- `1 time 20$`
- `1 time 5$`

<sup>The nominals list can be different for other currencies.</sup>

### How is it done?

First of all we need to determine with what types of nominals we want to work with. Let's add these nominals the our list:

```java
static void add_nominals( ArrayList<Integer> nom ) {

  nom.add( 1   );
  nom.add( 2   );
  nom.add( 5   );
  nom.add( 10  );
  nom.add( 20  );
  nom.add( 50  );
  nom.add( 100 );
  nom.add( 200 );
  nom.add( 500 );
}
```

Then we can compare the `given amount` with the `current nominal value` (firstly, from obvious reasons, it's **the highest one**).
We can create an _Integer_ to store this value:

```java
int div = value/nominals.get(index);
```

After that we check if we can give back the `nominal's value`. If it's not physically possible to change the money, we try to change it with a `lower nominal`.

<sup>The amount of money to be changed can be modified [here](https://github.com/frieZZerr/Greedy-Algorithms/blob/main/Changer/Changer.java#L77)</sup>

### Example output for `239PLN`:

```
Nominal = 2     Quantity = 2
Nominal = 20     Quantity = 1
Nominal = 5     Quantity = 1
Nominal = 200     Quantity = 1
Nominal = 10     Quantity = 1
```
