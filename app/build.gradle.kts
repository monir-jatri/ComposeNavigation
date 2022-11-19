import core.Dependencies
import core.ModuleDep
import core.Versions

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.soyaeeb.composenavigation"

    compileSdk = AppConfig.compileSdkVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner  = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility  = JavaVersion.VERSION_1_8
        targetCompatibility  = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose_compiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core
    implementation (Dependencies.core_ktx)
    implementation(Dependencies.runtime_ktx)
    implementation (Dependencies.androidx_lifecycle)
    implementation (Dependencies.app_compact)
    implementation (Dependencies.compose_foundation)
    implementation (Dependencies.compose_runtime)
    implementation (Dependencies.activity_compose)
    implementation (Dependencies.compose_ui)
    implementation (Dependencies.compose_preview)
    implementation (Dependencies.compose_material3)
    implementation(Dependencies.compose_navigation)

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

    implementation(project(ModuleDep.data))
    implementation(project(ModuleDep.domain))
    implementation(project(ModuleDep.feature_repolist))
    implementation(project(ModuleDep.feature_profile))
}

kapt {
    correctErrorTypes = true
}