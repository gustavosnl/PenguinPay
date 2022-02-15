plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

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
}

dependencies {
    implementation(project(Modules.domain))

    // Dependency Injection
    implementation(Koin.core)
    implementation(Koin.android)


    // Network
    implementation(Retrofit.core)
    implementation(Retrofit.moshi_converter)
    implementation(Retrofit.coroutine_adapter)

    implementation(Moshi.core)
    implementation(Moshi.kotlin)

    implementation(OkHttp.core)
    implementation(OkHttp.logging)


    //Test
    testImplementation(Test.junit)
    androidTestImplementation(Test.android_junit)
    androidTestImplementation(Test.espresso)
}