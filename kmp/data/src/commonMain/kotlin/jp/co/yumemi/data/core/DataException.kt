package jp.co.yumemi.data.core

/**
 * Data exception
 *
 * Wrapper for remote and local [Throwable]s
 *
 * [Exception]s should be caught in the remote and local layer and thrown as [DataException]s to the domain layer
 */
sealed class DataException : Throwable() {
    abstract override val message: String?
    abstract override val cause: Throwable?

    /**
     * Unknown
     *
     * All non-mapped exceptions are classified as unknown
     */
    data class Unknown(
        override val message: String? = null,
        override val cause: Throwable? = null,
    ) : DataException()

    /**
     * Local exception
     *
     * Exceptions from the local layer
     */
    sealed class Local : DataException() {
        /**
         * Database exception
         *
         * Error when the database is accessed
         */
        data class Database(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : Local()

        /**
         * Missing field exception
         *
         * When a required parameter is missing
         */
        data class MissingField(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : Local()

        /**
         * Missing field exception
         *
         * When a required value is missing
         */
        data class MissingValue(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : Local()
    }

    /**
     * Remote
     *
     * Exceptions from the remote layer
     */
    sealed class Remote : DataException() {
        /**
         * Missing field exception
         *
         * When a required parameter is missing
         */
        data class MissingField(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : Remote()

        /**
         * Network exception
         *
         * When host is not found or there is no connection
         */
        data class Network(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : Remote()

        /**
         * Unauthorized exception
         *
         * Http Error 401
         */
        data class Unauthorized(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : Remote()

        /**
         * UnprocessableEntity exception
         *
         * Http Error 422
         */
        data class UnprocessableEntity(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : Remote()
    }
}
