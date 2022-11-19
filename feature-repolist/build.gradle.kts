import core.Dependencies
import core.ModuleDep

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.soyaeeb.features_repolist"
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

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = core.Versions.compose_compiler
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
    implementation(Dependencies.compose_navigation)
    implementation(Dependencies.compose_viewModel)

    // hilt
    implementation(Dependencies.hilt_android)
    implementation(Dependencies.hilt_navigation_compose)
    kapt(Dependencies.hilt_android_compiler_kapt)

    // Test
    testImplementation (Dependencies.junit)
    androidTestImplementation (Dependencies.junit_ext)
    androidTestImplementation (Dependencies.espresso)
    androidTestImplementation (Dependencies.compose_ui_test_junit)
    debugImplementation (Dependencies.debug_compose_ui)
    debugImplementation (Dependencies.compose_ui_test_manifest)

    // Coil
    implementation(Dependencies.coil_compose)


    implementation(project(ModuleDep.domain))
    implementation(project(ModuleDep.data))
    implementation(project(ModuleDep.model))
    implementation(project(ModuleDep.assets))
    implementation(project(ModuleDep.common))
}