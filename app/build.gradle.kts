plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.cleanarchapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cleanarchapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        flavorDimensions += "version"
        productFlavors {
            create("someApi") {
                dimension = "version"
                applicationIdSuffix = ".someApi"
                versionNameSuffix = "-someApi"
            }
            create("otherApi") {
                dimension = "version"
                applicationIdSuffix = ".otherApi"
                versionNameSuffix = "-otherApi"
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":feature:main"))
    implementation(project(":domain:usecases"))
    implementation(project(":domain:entities"))
    implementation(project(":base:initializator"))
    implementation(project(":data:api"))
    implementation(project(":data:impl"))
    implementation(project(":data:data_source:api"))

    "someApiImplementation"(project(":data:data_source:impl_someapi"))
    "otherApiImplementation"(project(":data:data_source:impl_otherapi"))

    val koin = "3.3.2"
    implementation("io.insert-koin:koin-core:$koin")
    implementation("io.insert-koin:koin-android:$koin")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}