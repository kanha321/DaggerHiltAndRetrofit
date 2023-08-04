@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.kanha.daggerhiltandretrofit"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kanha.daggerhiltandretrofit"
        minSdk = 28
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Hilt
    implementation (libs.dagger.hilt)
    kapt (libs.dagger.hilt.compiler)
    implementation(libs.dagger.hilt.lifeCycle.viewModel)
    kapt(libs.dagger.hilt.lifeCycle.viewModel.compiler)

    // Activity KTX for viewModels()
    implementation(libs.ktx.activity)

    // Architecture Components
    implementation(libs.viewmodel.lifeCycle)

    // LifeCycle
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation(libs.lifecycle.runtime)
//    implementation(libs.lifecycle.livedata)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp)

    // Coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    // Coroutines Lifecycle Scopes
    implementation(libs.coroutines.lifeCycle.viewModel)
    implementation(libs.coroutines.lifeCycle.runtime)


}

kapt {
    correctErrorTypes = true
}