buildscript {
    repositories {
        gradlePluginPortal()
        //jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
        classpath("com.android.tools.build:gradle:7.1.0-alpha02")
    }
}

allprojects {
    repositories {
        google()
        //jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}