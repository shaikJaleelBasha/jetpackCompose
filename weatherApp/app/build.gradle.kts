plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.jaleel.weather_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.jaleel.weather_app"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // Coil for image loading with Compose
    implementation("io.coil-kt:coil-compose:2.4.0") // Latest stable version for Coil Compose

// Material3 for Compose
    implementation("androidx.compose.material3:material3:1.1.0") // Updated to the latest stable version of Material3

// Lifecycle dependencies
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0") // Latest lifecycle version
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0") // Latest lifecycle version

// Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit is stable, no update needed
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Retrofit Gson converter (no update needed)

// Gson for JSON parsing
    implementation("com.google.code.gson:gson:2.10.1") // Latest stable version for Gson

// Coroutine and Flow
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2") // Latest stable version for Kotlin Coroutines


//    // Coil for image loading (optional, if you want to load icons or images)
//    implementation ("io.coil-kt:coil-compose:1.4.0")
//
//    // Material3 for UI
//    implementation ("androidx.compose.material3:material3:1.0.0")
}
