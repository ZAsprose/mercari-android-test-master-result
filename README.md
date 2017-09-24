# mercari-android-test
For Technical interview 

## Description

![screenshot](https://preview.ibb.co/fst4d5/Screen_Shot_2017_05_05_at_2_56_26_PM.png)

- Build an app that loads data from `all.json` which is stored in `assets`, and make the app look like the above screenshot.
- Write in a such way that data retrieval implementation can be easily replaced. For example, it is currenly loaded from `all.json` file but in the near future we might want to fetch the data from network.
- In the item cell view, it needs to display item image from `photo`, title from `name`, and price from `price`.
- JSON representation of Java classes are pre-defined. See `com.mercari.mercaritest.data.model.Item` and `com.mercari.mercaritest.data.model.Response`.
- For price background, use `item_price_background.xml` with a text style of `black_14_white`.
- For item name, use `regular_14_black_70op` text style.
- You are encouraged to build dependency graphs using [Dagger](https://google.github.io/dagger/)
- You are encouraged to use [RxJava](https://github.com/ReactiveX/RxJava)
- display `sold.png` as shown when `Item.status` equals to `sold_out`.
- Even though this app is relatively simple, please write code in "production ready" level; that is, write in a way that you would normally do on production app.
- Basic unit tests for bonus points
- Please use a known architecture with justification for your choice included, explained in README

When you have questions, please don't hesitate to ask!

### Estimated time commitment: 2 hours

## Instructions for submitting the exercise
1. Create a new git repo and use the provided project as a base to complete the assignment, committing with frequency and with the type of commit messages you would write on a typical project.
2. Submit with README that gives and overview of the project with technical detail
3. Zip up the repo and send back an email with attachment when you’ve completed the exercise and we will review it as soon as possible.
4. We’ll build it your app directly from the repo you provide
