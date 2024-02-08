sealed interface KmpModule : Module {
    enum class Base(override val path: String) : KmpModule {
        Application(":kmp:application"),
        Domain(":kmp:domain"),
        Data(":kmp:data"),
        Remote(":kmp:remote"),
        Local(":kmp:local"),
        Utils(":kmp:utils"),
    }

    enum class Feature(override val path: String) : KmpModule {
        Sample(":kmp:presentation:sample-shared"),
    }
}
