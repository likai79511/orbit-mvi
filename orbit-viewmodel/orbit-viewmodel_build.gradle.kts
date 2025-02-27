/*
 * Copyright 2021-2023 Mikołaj Leszczyński & Appmattus Limited
 * Copyright 2020 Babylon Partners Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * File modified by Mikołaj Leszczyński & Appmattus Limited
 * See: https://github.com/orbit-mvi/orbit-mvi/compare/c5b8b3f2b83b5972ba2ad98f73f75086a89653d3...main
 */

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-parcelize")
    id(libs.plugins.gradleMavenPublishPlugin.get().pluginId)
    id(libs.plugins.dokkaPlugin.get().pluginId)
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(libs.kotlinCoroutines)

    api(project(":orbit-core"))

    implementation(libs.androidxLifecycleSavedState)
    implementation(libs.androidxLifecycleViewmodelKtx)
    implementation(libs.androidxLifecycleRuntimeKtx)
    implementation(libs.androidxEspressoIdlingResource)

    // Testing
    testImplementation(project(":orbit-test"))
    testImplementation(project(":test-common"))
    testImplementation(libs.androidxEspressoCore)
    testImplementation(libs.robolectric)

    testImplementation(libs.kotlinTest)
    testImplementation(libs.kotlinCoroutinesTest)

    testImplementation(libs.androidxCoreTesting)
    testImplementation(libs.turbine)
}

android {
    namespace = "org.orbitmvi.orbit.viewmodel"

    testOptions.unitTests.isIncludeAndroidResources = true
}
