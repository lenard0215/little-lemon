plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //id("com.google.gms.google-services")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.smartherd.capstonelittlelemonapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.smartherd.capstonelittlelemonapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true

            javaCompileOptions {
                annotationProcessorOptions {
                    arguments += mapOf(
                        "room.schemaLocation" to "$projectDir/schemas",
                        "room.incremental" to "true"
                    )
                }
            }

        }
    }
    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}




dependencies {


    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.fragment:fragment-ktx:1.8.1")

    //Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.8.3")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.compose.runtime:runtime-livedata:1.6.8")
    //Firebase
    implementation (platform("com.google.firebase:firebase-bom:32.4.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-auth:22.3.0")
    implementation("com.google.android.gms:play-services-auth:20.7.0")

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material:1.6.8")
    //implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.compose.material:material-icons-extended:1.6.8")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

    // Navigation libraries
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.6")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.7.6")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    //Room
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    ksp("com.google.dagger:hilt-android-compiler:2.48.1")
    //Glide
    ksp ("com.github.bumptech.glide:ksp:4.14.2")
    // Moshi
    implementation ("com.squareup.moshi:moshi-kotlin:1.9.3")

    // Retrofit with Moshi Converter
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

    // Coil
    implementation("io.coil-kt:coil-compose:2.7.0")
    // circular ImageView
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Swipe Delete
    implementation ("com.github.xabaras:RecyclerViewSwipeDecorator:1.4")

    //ImageView Converter
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")
    // SnackBar
    implementation("com.google.android.material:material:1.12.0")

    implementation("io.ktor:ktor-client-android:2.3.3")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
    implementation("io.ktor:ktor-client-core:2.3.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    implementation("com.google.code.gson:gson:2.10")
    implementation("com.github.bumptech.glide:glide:4.14.2")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    debugImplementation("androidx.fragment:fragment-testing:1.8.1")
    //Dagger Hilt Test
    testImplementation  ("com.google.dagger:hilt-android-testing:2.48.1")
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.48.1")
    kspAndroidTest("com.google.dagger:hilt-compiler:2.48.1")
    kspTest("com.google.dagger:hilt-compiler:2.48.1")


    //Room Test
    testImplementation("androidx.room:room-testing:2.6.1")

    //Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test:core:1.6.1")
    testImplementation("androidx.test.ext:junit:1.2.1")
    testImplementation("androidx.test.ext:junit-ktx:1.2.1")

    debugImplementation("androidx.compose.ui:ui-test-manifest")

}

