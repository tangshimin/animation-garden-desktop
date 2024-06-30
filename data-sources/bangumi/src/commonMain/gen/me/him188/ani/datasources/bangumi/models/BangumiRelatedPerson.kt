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

import me.him188.ani.datasources.bangumi.models.BangumiPersonCareer
import me.him188.ani.datasources.bangumi.models.BangumiPersonImages
import me.him188.ani.datasources.bangumi.models.BangumiPersonType

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 *
 *
 * @param id
 * @param name
 * @param type `1`, `2`, `3` 表示 `个人`, `公司`, `组合`
 * @param career
 * @param relation
 * @param images object with some size of images, this object maybe `null`
 */
@Serializable

data class BangumiRelatedPerson(

    @SerialName(value = "id") @Required val id: kotlin.Int,

    @SerialName(value = "name") @Required val name: kotlin.String,

    /* `1`, `2`, `3` 表示 `个人`, `公司`, `组合` */
    @SerialName(value = "type") @Required val type: BangumiPersonType,

    @SerialName(value = "career") @Required val career: kotlin.collections.List<BangumiPersonCareer>,

    @SerialName(value = "relation") @Required val relation: kotlin.String,

    /* object with some size of images, this object maybe `null` */
    @SerialName(value = "images") val images: BangumiPersonImages? = null

)

