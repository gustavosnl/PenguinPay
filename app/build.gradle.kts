plugins {
    id("com.android.application")
    id("kotlin-android")
}


android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationName
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures.viewBinding = true
}

dependencies {
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    // Dependency Injection
    implementation(Koin.core)
    implementation(Koin.android)
    implementation(Koin.navigation)


    // Android X
    implementation(AndroidX.core)
    runtimeOnly(AndroidX.material)
    implementation(AndroidX.compat)
    implementation(AndroidX.navigation_ui)
    runtimeOnly(AndroidX.constraint_layout)
    implementation(AndroidX.navigation_fragment)


    //Test
    testImplementation(Test.junit)
    androidTestImplementation(Test.android_junit)
    androidTestImplementation(Test.espresso)

}