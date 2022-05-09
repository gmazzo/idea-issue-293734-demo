plugins {
    `embedded-kotlin`
}

val gradleVersion = GradleVersion.current().version
val gradleDependency by configurations.creating

repositories {
    ivy("https://services.gradle.org/distributions/") {
        name = "GradleDistributions"
        patternLayout { artifact("[organization]-[revision]-[module].[type]") }
        metadataSources { artifact() }
    }
}

dependencies {
    gradleDependency("gradle:bin:$gradleVersion@zip")
}

tasks {

    val assembleTask = register<Zip>("assembleDistribution") {
        from(provider { zipTree(gradleDependency.singleFile) })
        from(layout.projectDirectory.dir("src/init.d")) {
            into("gradle-$gradleVersion/init.d")
        }
        destinationDirectory.set(layout.buildDirectory)
        archiveFileName.set("custom-gradle-$gradleVersion.zip")
    }

    assemble.configure {
        dependsOn(assembleTask)
    }

}
