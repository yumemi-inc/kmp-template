package jp.co.yumemi.utils

fun <K, V> Map<K, V>.update(key: K, block: (V?) -> V): Map<K, V> = toMutableMap().apply {
    put(key, block(this[key]))
}

fun <K, V> Map<K, V>.updateAll(block: (V) -> V): Map<K, V> = toMutableMap().mapValues { (_, value) ->
    block(value)
}
