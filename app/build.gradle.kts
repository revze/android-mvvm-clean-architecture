import com.example.buildsrc.AppMetaData
import com.example.buildsrc.Libraries
import kotlin.collections.*

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
        vectorDrawables.useSupportLibrary = false
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
    dynamicFeatures = mutableSetOf(":feature_login", ":feature_games", ":feature_article")
//    dynamicFeatures.add(":login")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    api(Libraries.kotlin)

    // AndroidX
    api(Libraries.appCompat)
    api(Libraries.recyclerView)
    api(Libraries.coreKtx)
    api(Libraries.constraintLayout)
    api(Libraries.legacySupport)
    api(Libraries.googleMaterial)

    // Groupie
    implementation(Libraries.groupie)
    implementation(Libraries.groupieAndroidExtensions)

    // Chucker
    debugApi(Libraries.chuckerDebug)
    releaseApi(Libraries.chuckerRelease)

    // Dagger
    implementation(Libraries.dagger)
    implementation(Libraries.daggerAndroid)
    implementation(Libraries.daggerAndroidSupport)
    kapt(Libraries.daggerCompiler)
    kapt(Libraries.daggerAndroidProcessor)

    // Timber
    api(Libraries.timber)

    // Retrofit
    api(Libraries.retrofit)
    api(Libraries.moshi)

    // Glide
    api(Libraries.glide)
    kapt(Libraries.glideCompiler)

    // Coroutines
    api(Libraries.coroutines)

    //  Lifecycle & ViewModel
    api(Libraries.viewModel)
    api(Libraries.liveData)
    kapt(Libraries.lifecycleCommon)
    api(Libraries.lifecycleExtensions)

    // Room
    api(Libraries.room)
    kapt(Libraries.roomCompiler)
    api(Libraries.roomCoroutines)

    // prettytime
    implementation(Libraries.prettytime)

    // Test
    testImplementation(Libraries.jUnit)
    androidTestImplementation(Libraries.extjUnit)
    androidTestImplementation(Libraries.espresso)
}
