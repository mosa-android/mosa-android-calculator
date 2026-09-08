plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "org.mosa.calculator"
    compileSdk = 37

    defaultConfig {
        applicationId = "org.mosa.calculator"
        minSdk = 36
        targetSdk = 37
        versionCode = 37
        versionName = "17"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.mariuszgromada.mathparser.org.mxparser)
    implementation(libs.mediarouter)
    implementation(libs.gson)
    implementation(libs.json)
    implementation(libs.security.crypto)
    implementation(libs.viewpager2)
}