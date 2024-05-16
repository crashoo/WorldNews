# News App

This simple News App built to demonstrate the use of modern android architecture component with MVVM Architecture and api.


## API

This App fetches data from [News Api](https://newsapi.org/).


 ## Built using [MVVM Architecture](https://developer.android.com/topic/architecture)

 
## Technologies Used

- [Kotlin](https://kotlinlang.org/) - Programming language for Android.
- [Room Database](https://developer.android.com/training/data-storage/room/)- SQLite object mapping library.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata/) - Data objects that notify views when the underlying database changes.
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) - For asynchronous
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
- [DataBinding](https://developer.android.com/topic/libraries/data-binding) - Allows you to bind UI components in your XML layouts to data sources in your app using a declarative format rather than programmatically.
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
- [RecyclerView](https://developer.android.com/develop/ui/views/layout/recyclerview) - RecyclerView is the ViewGroup that contains the views corresponding to your data.
- [Navigation Component](https://developer.android.com/guide/navigation)
- [Glide](https://github.com/bumptech/glide) - An image loading and caching library for Android focused on smooth scrolling
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.

  
## Dependencies

dependencies 

    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.12.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.core:core-ktx:1.13.1'
    implementation 'androidx.navigation:navigation-fragment:2.7.7'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    implementation "androidx.navigation:navigation-ui-ktx:2.7.7"


    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.7.0"

    // Room
    implementation "androidx.room:room-runtime:2.6.1"
    kapt "androidx.room:room-compiler:2.6.1"
    implementation "androidx.room:room-ktx:2.6.1"

    // Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3"
    //retofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

    //okhttp
    implementation 'com.squareup.okhttp3:logging-interceptor:4.9.1'

    //glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'



## Screenshots
<img src="https://github.com/crashoo/WorldNews/assets/116108036/d9a05c51-2e56-4995-81f2-b4d581c79551" width="250" height="450">
<img src="https://github.com/crashoo/WorldNews/assets/116108036/115ebaf4-0206-47eb-a6af-c8c22205294d" width="250" height="450">

<img src="https://github.com/crashoo/WorldNews/assets/116108036/ce122105-15c1-421e-ad9b-0ae2df9156e9" width="250" height="450">
<img src="https://github.com/crashoo/WorldNews/assets/116108036/ea9e75ae-547d-4eb2-9bf5-e7b76aaf2b1c" width="250" height="450">



