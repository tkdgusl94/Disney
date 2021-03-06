object Modules {
    const val CACHE = ":cache"
    const val CORE = ":core"
    const val DOMAIN = ":domain"
    const val DATA = ":data"
    const val PRESENTATION = ":presentation"
    const val REMOTE = ":remote"
}

object Versions {
    const val KOTLIN_VERSION = "1.5.21"
    const val KOTLINX_COROUTINES = "1.5.0"
    const val BUILD_GRADLE = "4.2.2"

    const val CORE_KTX = "1.5.0"
    const val APP_COMPAT = "1.3.0"
    const val ACTIVITY_KTX = "1.2.3"
    const val FRAGMENT_KTX = "1.3.4"
    const val LIFECYCLE_KTX = "2.3.1"
    const val ROOM = "2.3.0"
    const val PAGING = "3.0.0"
    const val SWIPE_REFRESH_LAYOUT = "1.1.0"

    const val HILT = "2.35.1"
    const val MATERIAL = "1.3.0"
    const val PLAY_SERVICES_LOCATION = "18.0.0"
    const val GSON = "2.8.7"

    const val RETROFIT = "2.7.1"
    const val OKHTTP = "4.3.1"
    const val FRESCO = "0.8.1"

    const val LEAKCANARY = "2.6"

    const val JUNIT = "4.13.2"
    const val MOCKK = "1.10.0"
    const val ARCH_CORE = "2.1.0"
    const val COROUTINES_TEST = "1.5.1"

    const val ANDROID_JUNIT = "1.1.2"
    const val ESPRESSO_CORE = "3.3.0"
}

object Kotlin {
    const val KOTLIN_STDLIB      = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val COROUTINES_CORE    = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLINX_COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLINX_COROUTINES}"
}

object JavaX {
    const val INJECT = "javax.inject:javax.inject:1"
}

object AndroidX {
    const val CORE_KTX                = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT              = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"

    const val ACTIVITY_KTX            = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    const val FRAGMENT_KTX            = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"

    const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_KTX}"
    const val LIFECYCLE_LIVEDATA_KTX  = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_KTX}"

    const val ROOM_RUNTIME            = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KTX                = "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_COMPILER           = "androidx.room:room-compiler:${Versions.ROOM}"

    const val PAGING                  = "androidx.paging:paging-runtime-ktx:${Versions.PAGING}"
    const val PAGING_COMMON           = "androidx.paging:paging-common:${Versions.PAGING}"

    const val SWIPE_REFRESH_LAYOUT    = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT}"
}

object Google {
    const val HILT_ANDROID           = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_ANDROID_COMPILER  = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"

    const val MATERIAL               = "com.google.android.material:material:${Versions.MATERIAL}"

    const val PLAY_SERVICES_LOCATION = "com.google.android.gms:play-services-location:${Versions.PLAY_SERVICES_LOCATION}"

    const val GSON                   = "com.google.code.gson:gson:${Versions.GSON}"
}

object Libraries {
    const val RETROFIT                   = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON    = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"

    const val FRESCO                     = "com.facebook.fresco:fresco:${Versions.FRESCO}"

    const val LEAKCANARY                 = "com.squareup.leakcanary:leakcanary-android:${Versions.LEAKCANARY}"
}

object UnitTest {
    const val JUNIT           = "junit:junit:${Versions.JUNIT}"
    const val ARCH_CORE       = "androidx.arch.core:core-testing:${Versions.ARCH_CORE}"
    const val MOCKK           = "io.mockk:mockk:${Versions.MOCKK}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_TEST}"
}