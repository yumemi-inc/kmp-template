allprojects {
    group = Config.group
    version = getProperty(key = "VERSION", default = Config.version)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
