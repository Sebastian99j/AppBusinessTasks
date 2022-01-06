package com.appbusinesstasks.core.base

sealed class Failure {
    object UnknownFailure: Failure()
    object NetworkConnection: Failure()
    object ServerError: Failure()
    object ServerWrongResponseBody: Failure()
    object NoData: Failure()
    object DatabaseOperationError: Failure()
    object NoObjectInDatabase: Failure()
    object NoResults: Failure()

    abstract class FeatureFailure: Failure()
}