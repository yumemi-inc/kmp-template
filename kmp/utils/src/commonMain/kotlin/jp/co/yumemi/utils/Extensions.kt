package jp.co.yumemi.utils

inline fun <T> Iterable<T>.transformIf(condition: (T) -> Boolean, transform: (T) -> T): List<T> = map {
    if (condition(it)) {
        transform(it)
    } else {
        it
    }
}
