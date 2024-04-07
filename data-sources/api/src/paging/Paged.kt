package me.him188.ani.datasources.api.paging


data class Paged<T>(
    val total: Int?,
    val hasMore: Boolean,
    val page: List<T>,
) {
    companion object
}

inline fun <T, R> Paged<T>.map(block: (T) -> R): Paged<R> {
    return Paged(
        total = total,
        hasMore = hasMore,
        page = page.map(block),
    )
}

fun <T> Paged.Companion.processPagedResponse(total: Int?, pageSize: Int, data: List<T>?) =
    if (data == null) {
        Paged(total, false, emptyList())
    } else {
        Paged(
            total,
            data.isNotEmpty() && data.size >= pageSize,
            data
        )
    }
