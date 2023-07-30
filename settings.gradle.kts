pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.springframework.boot") {
                useModule("org.springframework.boot:spring-boot-gradle-plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "MarsRoverTdd"
include(":presentation")
include("presentation:main")
findProject(":presentation:main")?.name = "main"
include("presentation:test")
findProject(":presentation:test")?.name = "test"
include("presentation")
include("businessMarsRover")
include("businessMarsRover:src:main:kotlin")
findProject(":businessMarsRover:src:main:kotlin")?.name = "kotlin"
include("businessMarsRover")
include("businessMarsRover:src:main:kotlin")
findProject(":businessMarsRover:src:main:kotlin")?.name = "kotlin"
include("businessMarsRover:src:test")
findProject(":businessMarsRover:src:test")?.name = "test"
include("businessMarsRover:src:test:kotlin")
findProject(":businessMarsRover:src:test:kotlin")?.name = "kotlin"
