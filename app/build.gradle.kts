plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.sovellus2"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.sovellus2"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.7"

        kotlinOptions {
            jvmTarget = "1.8" // Varmista, että JVM target on 1.8
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0") // Lisää tämä
    implementation("androidx.appcompat:appcompat:1.6.1") // Lisää tämä
    implementation("androidx.compose.ui:ui:1.4.0") // Compose UI
    implementation("androidx.compose.material:material:1.4.0") // Compose Material
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0") // Compose Preview
    implementation("org.osmdroid:osmdroid-android:6.1.10") // Osmdroid
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10") // Kotlin stdlib
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.10") // Kotlin jdk8
}
