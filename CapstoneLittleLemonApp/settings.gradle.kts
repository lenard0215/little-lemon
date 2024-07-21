pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url= "https://mvnrepository.com/artifact/com.google.code.gson/gson")
    }
}

rootProject.name = "Capstone Little Lemon App"
include(":app")
 