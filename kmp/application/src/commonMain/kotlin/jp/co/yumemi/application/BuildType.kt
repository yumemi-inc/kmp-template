package jp.co.yumemi.application

/**
 * ビルド環境
 */
sealed interface BuildType {
    /** 開発 */
    data object Develop : BuildType
    /** モック */
    data class Mock(val host: String) : BuildType
    /** 試験 */
    data object Staging : BuildType
    /** 製品 */
    data object Production : BuildType
}
