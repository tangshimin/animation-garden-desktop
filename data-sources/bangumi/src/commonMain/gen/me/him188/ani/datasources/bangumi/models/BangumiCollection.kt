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


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 *
 *
 * @param wish
 * @param collect
 * @param doing
 * @param onHold
 * @param dropped
 */
@Serializable

data class BangumiCollection(

    @SerialName(value = "wish") @Required val wish: kotlin.Int,

    @SerialName(value = "collect") @Required val collect: kotlin.Int,

    @SerialName(value = "doing") @Required val doing: kotlin.Int,

    @SerialName(value = "on_hold") @Required val onHold: kotlin.Int,

    @SerialName(value = "dropped") @Required val dropped: kotlin.Int

)

