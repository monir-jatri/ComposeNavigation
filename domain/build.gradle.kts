import core.ModuleDep

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.soyaeeb.domain"
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
    implementation (core.Dependencies.core_ktx)
    implementation(core.Dependencies.runtime_ktx)
    implementation (core.Dependencies.androidx_lifecycle)
    implementation (core.Dependencies.activity_compose)
    implementation (core.Dependencies.compose_ui)
    implementation (core.Dependencies.compose_preview)
    implementation (core.Dependencies.compose_material3)


    implementation(core.Dependencies.retrofit)
    implementation(core.Dependencies.gson_converter)
    implementation(core.Dependencies.okhttp3)


    implementation(core.Dependencies.javax)
    implementation(core.Dependencies.google_gson)


    implementation(project(ModuleDep.model))

    // Test
    testImplementation (core.Dependencies.junit)
    androidTestImplementation (core.Dependencies.junit_ext)
    androidTestImplementation (core.Dependencies.espresso)
    androidTestImplementation (core.Dependencies.compose_ui_test_junit)
    debugImplementation (core.Dependencies.debug_compose_ui)
    debugImplementation (core.Dependencies.compose_ui_test_manifest)
}