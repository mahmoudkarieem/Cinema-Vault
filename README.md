# Cinema Vault

Cinema Vault is a movie discovery app that allows users to explore trending movies, TV shows, and various categories like Action, Animation, and more. With detailed information about each movie, including cast, ratings, and synopsis, Cinema Vault provides a comprehensive movie-watching experience.

## Features
- Discover **Trending Movies** and TV shows.
- Browse movies by **Categories** (e.g., Action, Animation, etc.).
- Get detailed information about movies, including **cast**, **ratings**, and **synopsis**.
- **Seamless UI** built with **Jetpack Compose**.
- **Real-time data** with **Retrofit** and **Coil** for image loading.

## Dependencies

### Hilt (Dependency Injection)
The app uses **Hilt** for dependency injection, making it easy to manage dependencies and improve testability.

- `implementation("com.google.dagger:hilt-android:2.50")`
- `kapt("com.google.dagger:hilt-compiler:2.50")`
- `implementation("androidx.hilt:hilt-navigation-compose:1.2.0")`

### Retrofit (API Networking)
For API calls and data handling, **Retrofit** is used to interact with remote servers.

- `implementation("com.squareup.retrofit2:retrofit:2.11.0")`
- `implementation("com.squareup.retrofit2:converter-gson:2.9.0")`

### Image Loading with Coil
**Coil** is used for loading images in a Compose-friendly manner.

- `implementation("io.coil-kt:coil-compose:2.7.0")`

### Coroutines
The app uses **Kotlin Coroutines** for handling background tasks asynchrono
