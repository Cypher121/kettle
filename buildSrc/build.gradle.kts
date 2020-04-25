plugins {
    groovy
    `kotlin-dsl`
}


repositories {
    jcenter()
}

dependencies {
    implementation("blue.endless:jankson:1.1.0")
    implementation("com.moandjiezana.toml:toml4j:0.7.2")
}

val compileGroovy by tasks.existing(GroovyCompile::class)

compileGroovy.configure {
    dependsOn -= "compileJava"
}
tasks.compileKotlin.configure {
    dependsOn(compileGroovy)
    classpath += files(compileGroovy.map { it.destinationDir }.get())
}
tasks.classes.configure {
    dependsOn(tasks.compileKotlin)
}