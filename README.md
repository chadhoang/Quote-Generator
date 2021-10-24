# Quote Generator
## About 
Quote Generator is an Android application that is written in Java, and utilizes multiple Public APIs in order to produce quotes at a simple click of a button.

## Features
Upon starting the application, the user is greeted by the following categories representing the topic/theme of their desired randomly generated quote:
- Anime - Using the [AnimeChan](https://github.com/RocktimSaikia/anime-chan) public API, this category generates a random anime quote. In addition to the quote, the name of the character that states the quote, along with the anime title will be provided.
- Dad Joke - Using the [icanhazdadjoke](https://icanhazdadjoke.com/api) public API, this category will generate a random dad joke.
- Quote of the Day - Using the [FavQs.com](https://favqs.com/api) public API, this category will generate a random Quote of the Day, along with proving the author of the quote.
- Inspirational/Zen - Using the [Zen Quotes](https://zenquotes.io/) public API, this category provides random Zen quotes that can be used for inspiration. The quote author will also be provided along with the quote.
- Random - This category provides a random quote chosen among all of the previously mentioned categories.

## Public APIs 
I accredit the following Public APIs for contributing to the completion of this application:
- [AnimeChan](https://github.com/RocktimSaikia/anime-chan)
- [icanhazdadjoke](https://icanhazdadjoke.com/api)
- [FavQs.com](https://favqs.com/api)
- [Zen Quotes](https://zenquotes.io/)

Please feel free to send requests as to ideas for other quote topics or APIs to include in order to further improve the application, or also feel free to download the code and modify it to however you would like it :^D.

## Use 
As I do not own an Android device, this application was tested using Android device emulators provided via [Android Studio](https://developer.android.com/studio). Steps to use the application through Android Studio include:

1. Download the zip of the [Quote Generator Github Repository](https://github.com/chadhoang/Quote-Generator).
2. Launch the unzipped file with a chosen emulated Android device through Android Studio.

The application requires use of the internet to obtain the quotes, so please be sure that you are connected to the internet in order for the application to work properly.

## Lessons Learned
I was introduced to the world of Android app development through working on this project. I wrote this app using Java in order to solidify my skills with the language. Through working on this particular app, I was introduced to the design aspects of Android application development through familiarizing myself with xml files, creating buttons, placing and anchoring Views, and much more. I also worked with Public APIs through this project, where I relied on data provided by the APIs in order to produce this functioning application. I worked and familiarized myself with the [Volley](https://developer.android.com/training/volley) library in order to send GET requests to the APIs and obtain JSON data from them. The main challenge of the project was parsing JSON data in order to format it to the output that I desired, and I feel that I have become very accustomed to working with JSON and Public APIs through this project, along with Java and Android Application development.
