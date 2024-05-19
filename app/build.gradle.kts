plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    id("com.google.devtools.ksp")

    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.basicapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.basicapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation ("com.google.dagger:hilt-android:2.51.1")
    ksp("com.google.dagger:hilt-compiler:2.51.1")

    // For instrumentation tests
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.51.1")
    kspAndroidTest ("com.google.dagger:hilt-compiler:2.51.1")

    // For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:2.51.1")
    kspTest ("com.google.dagger:hilt-compiler:2.51.1")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")
    // ViewModel utilities for Compose
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")
    // LiveData

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")

    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    val nav_version = "2.7.7"

    implementation("androidx.navigation:navigation-compose:$nav_version")
    //navigation compose iss liye add kiya hai ye view model ke object bn apaye aur view model ke object kaise bane vo hilt ki help se bannege
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")


}