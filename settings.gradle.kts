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
    }
}

rootProject.name = "CleanArchApp"
include(":app")
include(":data:api")
include(":data:data_source:api")
include(":domain:entities")
include(":base:initializator")
include(":data:impl")
include(":domain:usecases")
include(":data:data_source:impl_someapi")
include(":data:data_source:impl_otherapi")
include(":feature:main")
