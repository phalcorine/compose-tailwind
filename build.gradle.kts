plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "io.phalcorine"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig(Action {
                cssSupport {
                    enabled.set(true)
                }
            })
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)

                implementation(npm("tailwindcss", "3.2.1"))
                implementation(npm("@tailwindcss/forms", "0.5.3")) // optional

                // webpack
                implementation(devNpm("postcss", "8.4.17"))
                implementation(devNpm("postcss-loader", "7.0.1"))
                implementation(devNpm("autoprefixer", "10.4.12"))
                implementation(devNpm("css-loader", "6.7.1"))
                implementation(devNpm("style-loader", "3.3.1"))
                implementation(devNpm("cssnano", "5.1.13"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}