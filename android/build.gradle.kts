tasks.register("clean", Delete::class) {
    group = "cleanup"
    delete(rootProject.buildDir)
}
