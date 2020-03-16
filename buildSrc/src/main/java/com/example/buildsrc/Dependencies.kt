package com.example.buildsrc

object AppMetaData {
    const val id = "com.example.igdb"
    const val compileSdkVersion = 29
    const val buildToolsVersion = "29.0.3"
    const val targetSdkVersion = 29
    const val minSdkVersion = 19
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    // Application
    const val kotlin = "1.3.70"
    const val gradle = "3.6.1"

    // Core
    const val androidX = "1.1.0"
    const val coreKtx = "1.2.0"
    const val androidLegacySupport = "1.0.0"
    const val googleMaterial = "1.1.0"
    const val coroutines = "1.3.3"
    const val lifecycle = "2.2.0"
    const val chucker = "3.1.2"
    const val retrofit = "2.7.2"
    const val timber = "4.7.1"
    const val dagger = "2.26"
    const val room = "2.2.4"

    // UI
    const val constraintLayout = "1.1.3"
    const val glide = "4.11.0"
    const val groupie = "2.7.0"

    // Test
    const val jUnit = "4.12"
    const val extjUnit = "1.1.1"
    const val espresso = "3.2.0"

    // Helper
    const val prettytime = "4.0.4.Final"
}

object Libraries {
    // Kotlin
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // AndroidX
    const val appCompat = "androidx.appcompat:appcompat:${Versions.androidX}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.androidX}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.androidLegacySupport}"
    const val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"

    // Groupie
    const val groupie =  "com.xwray:groupie:${Versions.groupie}"
    const val groupieAndroidExtensions =  "com.xwray:groupie-kotlin-android-extensions:${Versions.groupie}"

    // Chucker
    const val chuckerDebug = "com.github.ChuckerTeam.Chucker:library:${Versions.chucker}"
    const val chuckerRelease = "com.github.ChuckerTeam.Chucker:library-no-op:${Versions.chucker}"

    // Dagger
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    // Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // Lifecycle & ViewModel
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    // Room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomCoroutines = "androidx.room:room-ktx:${Versions.room}"

    // prettytime
    const val prettytime = "org.ocpsoft.prettytime:prettytime:${Versions.prettytime}"

    // Test
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val extjUnit = "androidx.test.ext:junit:${Versions.extjUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
