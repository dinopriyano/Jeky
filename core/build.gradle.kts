@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.com.android.library)
  alias(libs.plugins.org.jetbrains.kotlin.android)
  alias(libs.plugins.ksp)
}

android {
  namespace = "id.aej.jeky.core"
  compileSdk = 33

  defaultConfig {
    minSdk = 23

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
}

dependencies {

  implementation(libs.core.ktx)
  implementation(libs.appcompat)
  implementation(libs.com.google.android.material.material)

  // Room Database
  implementation(libs.room.ktx)
  implementation(libs.room.runtime)
  ksp(libs.room.compiler)

  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.espresso.core)
}