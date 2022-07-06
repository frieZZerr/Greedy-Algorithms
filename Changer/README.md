# The problem of spending change

![Money](https://github.com/frieZZerr/Greedy-Algorithms/blob/main/Changer/money.jpg)

### Quick explanation

If you somehow end up as a cashier in some grocery store, it would be in your best interest to know about this algorithmic issue.
The base goal is to, from the cash given, change it by giving back **the lowest possible amount of coins/banknotes**.

For example:

`We receive an amount of 325$`
---
We're giving back:
- 3 times 100$
- 1 time 20$
- 1 time 5$

<sup>The nominals list can be different for other currencies.</sup>

### How is it done?

First of all we need to determine with what types of nominals we want to work with.
