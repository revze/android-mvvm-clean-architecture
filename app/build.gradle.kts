import com.example.buildsrc.AppMetaData
import com.example.buildsrc.Libraries

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppMetaData.compileSdkVersion)
    buildToolsVersion(AppMetaData.buildToolsVersion)
    defaultConfig {
        applicationId = AppMetaData.id
        minSdkVersion(AppMetaData.minSdkVersion)
        targetSdkVersion(AppMetaData.targetSdkVersion)
        versionCode = AppMetaData.versionCode
        versionName = AppMetaData.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation(Libraries.kotlin)

    // AndroidX
    implementation(Libraries.appCompat)
    implementation(Libraries.recyclerView)
    implementation(Libraries.coreKtx)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.legacySupport)
    implementation(Libraries.googleMaterial)

    // Groupie
    implementation(Libraries.groupie)
    implementation(Libraries.groupieAndroidExtensions)

    // Chucker
    debugImplementation(Libraries.chuckerDebug)
    releaseImplementation(Libraries.chuckerRelease)

    // Dagger
    api(Libraries.dagger)
    api(Libraries.daggerAndroid)
    api(Libraries.daggerAndroidSupport)
    kapt(Libraries.daggerCompiler)
    kapt(Libraries.daggerAndroidProcessor)

    // Timber
    implementation(Libraries.timber)

    // Retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.moshi)

    // Glide
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)

    // Coroutines
    implementation(Libraries.coroutines)

    // Lifecycle & ViewModel
    implementation(Libraries.viewModel)
    implementation(Libraries.liveData)
    kapt(Libraries.lifecycleCommon)
    implementation(Libraries.lifecycleExtensions)

    // Room
    implementation(Libraries.room)
    kapt(Libraries.roomCompiler)
    implementation(Libraries.roomCoroutines)

    // Test
    testImplementation(Libraries.jUnit)
    androidTestImplementation(Libraries.extjUnit)
    androidTestImplementation(Libraries.espresso)
}
