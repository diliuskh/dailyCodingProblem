plugins {
    val kotlinVersion = "1.8.20"
    java
    kotlin("jvm") version kotlinVersion
}

group = "net.dilius"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val kotlinVersion = "1.8.20"
val coroutinesVersion = "1.6.4"
val arrowVersion = "1.0.1"

val junitVersion = "5.9.2"
val mockitoVersion = "5.1.0"
val mockitoKotlinVersion = "4.1.0"

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", coroutinesVersion)
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-jdk8", coroutinesVersion)

    implementation("io.arrow-kt", "arrow-core", arrowVersion)

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter", "junit-jupiter")
    testImplementation("org.junit.jupiter", "junit-jupiter-params")
    testImplementation("org.jetbrains.kotlin", "kotlin-test-junit5", kotlinVersion)
    testImplementation("org.mockito", "mockito-core", mockitoVersion)
    testImplementation("org.mockito", "mockito-junit-jupiter", mockitoVersion)
    testImplementation("org.mockito.kotlin", "mockito-kotlin", mockitoKotlinVersion)
}
tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(19))
    }
}
tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "19"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "19"
        }
    }
}
