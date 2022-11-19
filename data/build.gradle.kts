import core.Dependencies
import core.ModuleDep

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.soyaeeb.data"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            getByName("debug"){
                isMinifyEnabled = true
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Core
    implementation (Dependencies.core_ktx)
    implementation(Dependencies.runtime_ktx)
    implementation (Dependencies.androidx_lifecycle)
    implementation (Dependencies.activity_compose)
    implementation (Dependencies.compose_ui)
    implementation (Dependencies.compose_preview)
    implementation (Dependencies.compose_material3)


    implementation(Dependencies.retrofit)
    implementation(Dependencies.gson_converter)

    implementation(Dependencies.javax)
    implementation(Dependencies.google_gson)
    implementation(Dependencies.okhttp3)

    // Test
    testImplementation (Dependencies.junit)
    androidTestImplementation (Dependencies.junit_ext)
    androidTestImplementation (Dependencies.espresso)
    androidTestImplementation (Dependencies.compose_ui_test_junit)
    debugImplementation (Dependencies.debug_compose_ui)
    debugImplementation (Dependencies.compose_ui_test_manifest)

    // Module Dependencies

    implementation(project(ModuleDep.domain))
    implementation(project(ModuleDep.model))
    implementation(project(ModuleDep.core))
}