@file:Suppress("UNUSED_EXPRESSION")

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.example.ayubapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ayubapp"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding { enable = true }
    }
}

dependencies {

    // Room dependencies
    implementation(libs.androidx.room.runtime)   // Room Runtime
    implementation(libs.androidx.room.ktx)       // Room KTX for Kotlin extensions
    //noinspection KaptUsageInsteadOfKsp
    kapt(libs.androidx.room.compiler)            // Room Compiler for annotation processing

    // RecyclerView
    implementation(libs.androidx.recyclerview)

    // Activity & Lifecycle
    implementation(libs.androidx.activity)           // Android Activity
    implementation(libs.androidx.activity.ktx)       // Activity KTX (includes viewModels)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Core & AppCompat
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    // External Libraries
    implementation(libs.exp4j)
    implementation(libs.material)

    // ConstraintLayout
    implementation(libs.androidx.constraintlayout)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
