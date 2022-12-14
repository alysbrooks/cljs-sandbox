# CLJS sandbox

Sample CLJS project for my own testing purposes. Includes a working setup of
kaocha-cljs2. Forked from [this template](https://github.com/shadow-cljs/quickstart-browser.git)


## Required Software

- [node.js (v6.0.0+)](https://nodejs.org/en/download/)
- [Java JDK (8+)](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or [Open JDK (8+)](http://jdk.java.net/10/)

## User Guide

Please refer to the full [Shadow-cljs User Guide](https://shadow-cljs.github.io/docs/UsersGuide.html) for more information.


## Running the Example

```bash
git clone https://github.com/shadow-cljs/quickstart-browser.git quickstart
cd quickstart
npm install
npx shadow-cljs server
```

This runs the `shadow-cljs` server process which all following commands will talk to. Just leave it running and open a new terminal to continue.

The first startup takes a bit of time since it has to download all the dependencies and do some prep work. Once this is running we can get started.

```txt
npx shadow-cljs watch app
```

This will begin the compilation of the configured `:app` build and re-compile whenever you change a file.

When you see a "Build completed." message your build is ready to be used.

```txt
[:app] Build completed. (23 files, 4 compiled, 0 warnings, 7.41s)
```

You can now then open [http://localhost:8020](http://localhost:8020).

## Live reload

To see the live reload in action you can edit the `src/main/start/browser.cljs`. Some output will be printed in the browser console.

## REPL

During development it the REPL is very useful.

From the command line use `npx shadow-cljs cljs-repl app`.

```
shadow-cljs - config .../shadow-cljs.edn
shadow-cljs - connected to server
cljs.user=>
```

This can now be used to eval code in the browser (assuming you still have it open). Try `(js/alert "Hi.")` and take it from there. You might want to use `rlwrap npx shadow-cljs cljs-repl app` if you intend to type a lot here.

You can exit the REPL by either `CTRL+C` or typing `:repl/quit`.

## Release

The `watch` process we started is all about development. It injects the code required for the REPL and the all other devtools but we do not want any of that when putting the code into "production" (ie. making it available publicly).

The `release` action will remove all development code and run the code through the Closure Compiler to produce a minified `main.js` file. Since that will overwrite the file created by the `watch` we first need to stop that.

Use `CTRL+C` to stop the `watch` process and instead run `npx shadow-cljs release app`.

When done you can open `http://localhost:8020` and see the `release` build in action. At this point you would usually copy the `public` directory to the "production" web server.

Note that in the default config we overwrote the `public/js/main.js` created by the `watch`. You can also configure a different path to use for release builds but writing the output to the same file means we do not have to change the `index.html` and test everything as is.
