plugins {
    id("com.android.library")
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
    id("signing")
}

version = "1.0.3"  // Define the version of your SDK


android {
    namespace = "com.mycube.android_utils"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        viewBinding = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.ShanmugavelGK"
            artifactId = "android-utils"
            version = version

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}