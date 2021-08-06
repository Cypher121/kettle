tasks.register<Copy>("installGitHooks") {
    group = "build setup"
    description = "Installs recommended git hooks for the project"
    duplicatesStrategy = DuplicatesStrategy.INCLUDE

    from("git_hooks")
    into(".git/hooks")
    fileMode = 0b111111111
}

group = "coffee.cypher.kettle"
version = "2.0.0-alpha.2"

tasks.wrapper {
    gradleVersion = "7.2-rc-1"
    distributionType = Wrapper.DistributionType.ALL
}