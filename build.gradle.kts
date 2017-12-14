import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

group = "org.example"
version = "0.1-SNAPSHOT"

buildscript {
    var kotlinVer: String by extra

    kotlinVer = "1.2.10"

    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath(kotlin(module = "gradle-plugin", version = kotlinVer))
    }
}

val kotlinVer: String by extra

apply {
    plugin("kotlin2js")
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    "compile"(kotlin(module = "stdlib-js", version = kotlinVer))
}

val compileKotlin2Js by tasks.getting(Kotlin2JsCompile::class) {
    val fileName = "kotlinjs-test-proto.js"

    kotlinOptions.outputFile = "${projectDir.absolutePath}/web/js/$fileName"
    kotlinOptions.sourceMap = true
    doFirst { File("${projectDir.absolutePath}/web/js").deleteRecursively() }
}
val assembleWeb by tasks.creating(Copy::class) {
    dependsOn("classes")
    configurations["compile"].forEach { file ->
        from(zipTree(file.absolutePath)) {
            includeEmptyDirs = false
            include { fileTreeElement ->
                val path = fileTreeElement.path

                path.endsWith(".js") && path.startsWith("META-INF/resources/") || !path.startsWith("META_INF/")
            }
        }
    }
    from(compileKotlin2Js.destinationDir)
    into("${projectDir.absolutePath}/web/js")
}
task<Copy>("deployProgram") {
    dependsOn(assembleWeb)
    from("${projectDir.absolutePath}/src/main/resources")
    into("${projectDir.absolutePath}/web")
}