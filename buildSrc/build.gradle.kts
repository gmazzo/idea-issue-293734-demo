plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(embeddedKotlin("gradle-plugin"))
}

println(
    """
    build: ${project.name}
    gradleHomeDir: ${gradle.gradleHomeDir}
    initScripts: ${gradle.startParameter.allInitScripts.joinToString(separator = "") { "\n    - $it" }}
    """.trimIndent()
)
