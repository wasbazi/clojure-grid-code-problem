# grid-problem

Some fun playing around with clojure and attempting to solve this [code problem
from reddit](https://www.reddit.com/r/dailyprogrammer/comments/58n2ca/20161021_challenge_288_hard_adjacent_numbers/?st=ivfvkfod&sh=e217fd3c)

This was a fun learning exercise in how Clojure works.


## Running

To test out this application you need the [Leiningen](http://leiningen.org/) tool
for running Clojure. The installation is self-explanatory on that website.

Once you have that you can run:

```bash
$ lein run
```

This will run with a 5x5 grid generated of all 1's and output a Grid that
fulfills the requirements specified in the reddit thread. To modify the grid
that is generated one must open up `src/grid_problems/core.clj` and make a code
modification.
