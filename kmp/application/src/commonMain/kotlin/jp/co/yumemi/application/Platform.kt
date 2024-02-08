package jp.co.yumemi.application

expect class Platform {
    val operatingSystem: OperatingSystem
    val osVersion: String
    val device: String
}
