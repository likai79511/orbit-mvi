/*
 * Copyright 2023 Mikołaj Leszczyński & Appmattus Limited
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

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import org.gradle.accessors.dm.LibrariesForLibs

val Project.libs: LibrariesForLibs
    get() = this.extensions.getByType()

buildscript {
    repositories {
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(libs.buildscript.detekt)
    }
}

repositories {
    mavenCentral()
}

apply<DetektPlugin>()

tasks.named("detekt", Detekt::class.java).configure {
    setSource(files(rootProject.projectDir))

    include("**/*.kt")
    include("**/*.kts")
    exclude("**/resources/**")
    exclude("**/build/**")

    parallel = true

    autoCorrect = true
    buildUponDefaultConfig = true
    config.setFrom(files("${rootProject.projectDir}/gradle/scripts/detekt.yml"))

    reports {
        xml {
            enabled = true
            destination = file("build/reports/detekt/detekt.xml")
        }
        html {
            enabled = true
        }
    }
}

dependencies {
    "detektPlugins"(libs.detektFormatting)
}
