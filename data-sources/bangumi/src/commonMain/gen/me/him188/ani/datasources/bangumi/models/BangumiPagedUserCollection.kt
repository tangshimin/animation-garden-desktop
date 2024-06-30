/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport",
)

package me.him188.ani.datasources.bangumi.models

import me.him188.ani.datasources.bangumi.models.BangumiUserSubjectCollection

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 *
 *
 * @param total
 * @param limit
 * @param offset
 * @param `data`
 */
@Serializable

data class BangumiPagedUserCollection(

    @SerialName(value = "total") val total: kotlin.Int? = 0,

    @SerialName(value = "limit") val limit: kotlin.Int? = 0,

    @SerialName(value = "offset") val offset: kotlin.Int? = 0,

    @SerialName(value = "data") val `data`: kotlin.collections.List<BangumiUserSubjectCollection>? = arrayListOf()

)

