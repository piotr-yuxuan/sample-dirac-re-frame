# Sample project with re-frame and Dirac

A [re-frame](https://github.com/Day8/re-frame) application designed to… well, that part is up to you.

This sample project aims at showing a bit what how you can use reactive programming, functional programming and immutable data in a single-paged web application. It's much more advised to read the following page:

- [What is functionnal programming about?](http://blog.jenkster.com/2015/12/what-is-functional-programming.html)
- Just the front page of [re-frame](https://github.com/Day8/re-frame)

## Distribution

```
lein dist
```

Distributable files with be placed within `docs/` where GitHub pages look them for.

## Documentation

Additional documentation will be written under `docs/doc` if ever.

## Development

Technically, this project is a [re-frame](https://github.com/Day8/re-frame) rich single-paged application built upon [React](https://facebook.github.io/react/) — wrapped into [Reagent](http://reagent-project.github.io/). I use [Figwheel](https://github.com/bhauman/lein-figwheel), [Dirac](https://github.com/binaryage/dirac) for development so I can enjoy [live-coding](https://en.wikipedia.org/wiki/Live_coding). For the time being, this project is distributed within a [GitHub page](https://pages.github.com/) : [https://piotr-yuxuan.github.io/sample-dirac-re-frame/](https://piotr-yuxuan.github.io/sample-dirac-re-frame/)

### Update third party code

``` bash
lein ancient upgrade :all :check-clojure :allow-all
```

Required anytime Chrome Canary (hence Dirac) get new version numbers.

### Clean project state

``` bash
lein clean
```

### Automatically reload hot code and css

``` bash
lein reload
```

Local developement endpoint is accessible via [http://localhost:3456](http://localhost:3456).

### Dirac

Start Dirac agent in a Java REPL

``` bash
lein repl
```

You may prefer to launch latest Chrome Canary with a dedicated user profile:

``` bash
cd ~ # anywhere else
/Applications/Google\ Chrome\ Canary.app/Contents/MacOS/Google\ Chrome\ Canary \
  --remote-debugging-port=9222 \
  --no-first-run \
  --user-data-dir=.chrome-user-data-dir
```

Install [Dirac Chrome extension](https://chrome.google.com/webstore/detail/dirac-devtools/kbkdngfljkchidcjpnfcgcokkbhlkogi) ifneedsbe.
