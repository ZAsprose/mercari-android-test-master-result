#mercari-android-test-result
For Technical interview 

##Overview
There are three potential choices for this task: 
TableLayout, GridView and ListView. Since ListView 
requires a lot of customization, and the requirement 
indicates that further implementation might be possible. 
Let's have GridView as the basic holder.

Taking future improvement and current data size into consideration, 
we implement classes for the convinence of modifying different functions
 and parts of the program.
 
##Important Data Structure
- MainActivity  
Implemented by Mercari and Zijun to load GridView. ScrollListener included for 
dynamtic loading the data.
- GridAdapter  
Implemented by Zijun as the adapter for loading GridView.
- Item  
Implemented by Mercari for storing every entity in `all.json`.
- Response  
Implemented by Mercari to store data from `all.json`.
- HomeResponse  
Implemented by Mercari and Zijun to parse `all.json` and 
store the result in a `Response` object.

#modified and created files
- app/src/main/java/com.mercari.mercaritest/data.model/HomeResponse.java
- app/src/main/java/com.mercari.mercaritest/data.model/Response.java 
- app/src/main/java/com.mercari.mercaritest/GridAdapter.java
- app/src/main/java/com.mercari.mercaritest/MainActivity.java
- app/src/main/res/layout/activity_main.xml
- app/src/main/res/layout/grid_cell.xml

##Built with
Android Studio 2.3.3  
Gradle 2.3.3

##Authors
Mercari  
https://www.mercari.com  
https://drive.google.com/open?id=0B6BblBzgS-MzYXhVSEJsYzZCWE0  

ZAsprose  
https://github.com/ZAsprose

# Attached original README

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
