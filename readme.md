# Kotlin JS Test Prototype

Prototype for basic software testing in Kotlin JS. The testing library is in a separate [package](src/main/kotlin/org/example/kotlinjstest/testlib). Entry point for the program being tested is in a [single file](src/main/kotlin/org/example/kotlinjstest/main.kt). All test output is directed to the web browser console.

## Usage

**IMPORTANT:** Ensure that Gradle 4.4 is used. If needed change the Gradle wrapper version to **4.4** before proceeding!

In order to run the program do the following:

1. Deploy the program via the terminal: ```./gradlew deployProgram```
2. In IntelliJ right click on [index.html](web/index.html) file
3. Select **Open in Browser** entry and click on **Default** option
