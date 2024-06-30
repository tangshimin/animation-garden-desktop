package me.him188.ani.app.ui.subject.collection

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking
import me.him188.ani.app.data.media.EpisodeCacheStatus
import me.him188.ani.app.data.subject.EpisodeCollection
import me.him188.ani.app.data.subject.EpisodeInfo
import me.him188.ani.app.data.subject.SubjectCollection
import me.him188.ani.app.data.subject.SubjectInfo
import me.him188.ani.app.tools.caching.LazyDataCache
import me.him188.ani.app.tools.caching.mutate
import me.him188.ani.app.ui.cache.testMediaCache1
import me.him188.ani.app.ui.foundation.ProvideCompositionLocalsForPreview
import me.him188.ani.app.ui.foundation.rememberViewModel
import me.him188.ani.datasources.api.EpisodeSort
import me.him188.ani.datasources.api.paging.SinglePagePagedSource
import me.him188.ani.datasources.api.topic.FileSize.Companion.megaBytes
import me.him188.ani.datasources.api.topic.UnifiedCollectionType

@Composable
@Preview
internal actual fun PreviewCollectionPage() {
    ProvideCompositionLocalsForPreview {
        rememberViewModel {
            MyCollectionsViewModelImpl().apply {
                val testData = testCollections()
                runBlocking {
                    collectionsByType.forEach { c ->
                        c.cache.mutate {
                            testData.filter { it.collectionType == c.type }
                        }
                    }
                }
            }
        }

        CollectionPage(
            onClickCaches = {},
            contentPadding = PaddingValues(0.dp),
        )
    }
}

private fun testCollections(): List<SubjectCollection> {
    return buildList {
        var id = 0
        val eps = listOf(
            EpisodeCollection(
                episodeInfo = EpisodeInfo(
                    id = 6385,
                    name = "Diana Houston",
                    nameCn = "Nita O'Donnell",
                    comment = 5931,
                    duration = "",
                    desc = "gubergren",
                    disc = 2272,
                    sort = EpisodeSort(1),
                    ep = EpisodeSort(1),
                ),
                collectionType = UnifiedCollectionType.DONE,
            ),
            EpisodeCollection(
                episodeInfo = EpisodeInfo(
                    id = 6386,
                    name = "Diana Houston",
                    nameCn = "Nita O'Donnell",
                    sort = EpisodeSort(2),
                    comment = 5931,
                    duration = "",
                    desc = "gubergren",
                    disc = 2272,
                    ep = EpisodeSort(2),
                ),
                collectionType = UnifiedCollectionType.DONE,
            ),

            )
        val latestEp = eps[1]
        add(
            SubjectCollection(
                info = SubjectInfo.Empty,
                episodes = eps,
                collectionType = UnifiedCollectionType.DOING,
            ),
        )
        add(
            SubjectCollection(
                info = SubjectInfo.Empty,
                episodes = eps,
                collectionType = UnifiedCollectionType.DOING,
            ),
        )
        add(
            SubjectCollection(
                info = SubjectInfo.Empty,
                episodes = eps,
                collectionType = UnifiedCollectionType.DOING,
            ),
        )
        add(
            SubjectCollection(
                info = SubjectInfo.Empty,
                episodes = eps,
                collectionType = UnifiedCollectionType.WISH,
            ),
        )
        repeat(20) {
            add(
                SubjectCollection(
                    info = SubjectInfo.Empty,
                    episodes = eps + EpisodeCollection(
                        episodeInfo = EpisodeInfo(
                            id = 6386,
                            name = "Diana Houston",
                            nameCn = "Nita O'Donnell",
                            sort = EpisodeSort(2),
                            comment = 5931,
                            duration = "",
                            desc = "gubergren",
                            disc = 2272,
                            ep = EpisodeSort(2),
                        ),
                        collectionType = UnifiedCollectionType.DONE,
                    ),
                    collectionType = UnifiedCollectionType.WISH,
                ),
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewSubjectCollectionsColumnPhone() {
    ProvideCompositionLocalsForPreview {
        SubjectCollectionsColumn(
            testLazyDataCache(),
            onRequestMore = {},
            item = {
                SubjectCollectionItem(
                    item = it,
                    episodeCacheStatus = { _, _ ->
                        EpisodeCacheStatus.Cached(300.megaBytes, testMediaCache1)
                    },
                    onClick = { },
                    onClickEpisode = {},
                    onClickSelectEpisode = { },
                    onSetAllEpisodesDone = { },
                    onSetCollectionType = {},
                )
            },
            onEmpty = {},
        )
    }
}

@Preview(
    heightDp = 1600, widthDp = 1600,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL,
)
@Preview(
    heightDp = 1600, widthDp = 1600,
)
@Composable
private fun PreviewSubjectCollectionsColumnDesktopLarge() {
    ProvideCompositionLocalsForPreview {
        SubjectCollectionsColumn(
            testLazyDataCache(),
            onRequestMore = {},
            item = {
                SubjectCollectionItem(
                    item = it,
                    episodeCacheStatus = { _, _ ->
                        EpisodeCacheStatus.Cached(300.megaBytes, testMediaCache1)
                    },
                    onClick = { },
                    onClickEpisode = {},
                    onClickSelectEpisode = { },
                    onSetAllEpisodesDone = { },
                    onSetCollectionType = {},
                )
            },
            onEmpty = {},
        )
    }
}

private fun testLazyDataCache(): LazyDataCache<SubjectCollection> {
    return LazyDataCache(
        {
            SinglePagePagedSource {
                testCollections().asFlow()
            }
        },
        debugName = "test",
    ).apply {
        runBlocking { requestMore() }
    }
}
