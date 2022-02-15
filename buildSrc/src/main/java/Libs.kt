object AndroidX {
    const val core = "androidx.core:core-ktx:${Versions.android_core_version}"
    const val compat = "androidx.appcompat:appcompat:${Versions.android_compat_version}"
    const val material = "com.google.android.material:material:${Versions.android_material_version}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.android_navigation_version}"
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.android_navigation_version}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.android_constraint_layout_version}"
}

object Koin {
    const val core = "io.insert-koin:koin-core:${Versions.koin_version}"
    const val android = "io.insert-koin:koin-android:${Versions.koin_version}"
    const val navigation = "io.insert-koin:koin-androidx-navigation:${Versions.koin_version}"
}

object Retrofit {
    const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit_version}"
    const val coroutine_adapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofit_coroutine_version}"
}

object Moshi {
    const val core = "com.squareup.moshi:moshi:${Versions.moshi_version}"
    const val kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi_version}"
}

object OkHttp {
    const val core = "com.squareup.okhttp3:okhttp:${Versions.okhttp_version}"
    const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_version}"
}


object Test {
    const val junit = "junit:junit:${Versions.junit_version}"
    const val android_junit = "androidx.test.ext:junit:${Versions.android_junit_version}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso_version}"
}
