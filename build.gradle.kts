plugins {
    kotlin
}

dependencies {
    implementation("com.google.code.gson:gson:2.9.0")
}

println(
    """
    build: ${project.name}
    gradleHomeDir: ${gradle.gradleHomeDir}
    initScripts: ${gradle.startParameter.allInitScripts.joinToString(separator = "") { "\n    - $it" }}
    """.trimIndent()
)
