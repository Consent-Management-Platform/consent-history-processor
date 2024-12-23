plugins {
    java
    application
    checkstyle
    jacoco
}

repositories {
    mavenCentral()
}

checkstyle {
    toolVersion = "10.16.0"
    setIgnoreFailures(false)
}

dependencies {
    implementation(libs.guava)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "com.consentframework.consenthistory.consentingestor.ConsentStreamIngestor"
}

tasks {
    withType<Test> {
        useJUnitPlatform()

        // Always run jacoco test report after tests
        finalizedBy(jacocoTestReport)
    }

    jacocoTestCoverageVerification {
        violationRules {
            rule {
                limit {
                    minimum = BigDecimal.valueOf(0.95)
                }
            }
        }
    }

    check {
        // Fail build if under min test coverage thresholds
        dependsOn(jacocoTestCoverageVerification)
    }
}