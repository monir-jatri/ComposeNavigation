pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
rootProject.name = "ComposeNavigation"
include (":app")
include(":data")
include(":domain")
include(":model")
include(":core")
include(":cache")
include(":feature-repolist")
include(":feature-profile")
include(":common")
include(":assets")
