@file:Suppress("ktlint")

/*
 * Copyright (C) Contributors to the Suwayomi project
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

package suwayomi.tachidesk.manga.impl.backup.proto.handlers


import suwayomi.tachidesk.server.settings.SettingsUpdater
import suwayomi.tachidesk.manga.impl.backup.BackupFlags
import suwayomi.tachidesk.manga.impl.backup.proto.models.BackupServerSettings
import suwayomi.tachidesk.server.serverConfig
import suwayomi.tachidesk.server.settings.SettingsRegistry
import suwayomi.tachidesk.graphql.types.WebUIFlavor
import suwayomi.tachidesk.graphql.types.WebUIInterface
import suwayomi.tachidesk.graphql.types.WebUIChannel
import suwayomi.tachidesk.manga.impl.backup.proto.models.BackupSettingsDownloadConversionType
import suwayomi.tachidesk.graphql.types.AuthMode
import kotlin.time.Duration
import org.jetbrains.exposed.sql.SortOrder
import suwayomi.tachidesk.graphql.types.CbzMediaType
import suwayomi.tachidesk.graphql.types.KoreaderSyncChecksumMethod
import suwayomi.tachidesk.graphql.types.KoreaderSyncLegacyStrategy
import suwayomi.tachidesk.graphql.types.KoreaderSyncConflictStrategy
import suwayomi.tachidesk.graphql.types.DatabaseType


object BackupSettingsHandler {
    fun backup(flags: BackupFlags): BackupServerSettings? {
        if (!flags.includeServerSettings) { return null }

        return BackupServerSettings(
            // Network
            ip = null,
            port = null,
            // Proxy
            socksProxyEnabled = serverConfig.socksProxyEnabled.value,
            socksProxyVersion = serverConfig.socksProxyVersion.value,
            socksProxyHost = serverConfig.socksProxyHost.value,
            socksProxyPort = serverConfig.socksProxyPort.value,
            socksProxyUsername = null,
            socksProxyPassword = null,
            // WebUI
            webUIFlavor = serverConfig.webUIFlavor.value,
            initialOpenInBrowserEnabled = serverConfig.initialOpenInBrowserEnabled.value,
            webUIInterface = serverConfig.webUIInterface.value,
            electronPath = null,
            webUIChannel = serverConfig.webUIChannel.value,
            webUIUpdateCheckInterval = serverConfig.webUIUpdateCheckInterval.value,
            webUIEnabled = serverConfig.webUIEnabled.value,
            webUISubpath = null,
            // Downloader
            downloadAsCbz = serverConfig.downloadAsCbz.value,
            downloadsPath = null,
            autoDownloadNewChapters = serverConfig.autoDownloadNewChapters.value,
            excludeEntryWithUnreadChapters = serverConfig.excludeEntryWithUnreadChapters.value,
            autoDownloadAheadLimit = null,
            autoDownloadNewChaptersLimit = serverConfig.autoDownloadNewChaptersLimit.value,
            autoDownloadIgnoreReUploads = serverConfig.autoDownloadIgnoreReUploads.value,
            downloadConversions = SettingsRegistry.get("downloadConversions")!!.typeInfo.convertToBackupType!!(serverConfig.downloadConversions.value) as? List<BackupSettingsDownloadConversionType>,
            serveConversions = SettingsRegistry.get("serveConversions")!!.typeInfo.convertToBackupType!!(serverConfig.serveConversions.value) as? List<BackupSettingsDownloadConversionType>,
            // Extension/Source
            extensionRepos = serverConfig.extensionRepos.value,
            maxSourcesInParallel = serverConfig.maxSourcesInParallel.value,
            // Library updates
            excludeUnreadChapters = serverConfig.excludeUnreadChapters.value,
            excludeNotStarted = serverConfig.excludeNotStarted.value,
            excludeCompleted = serverConfig.excludeCompleted.value,
            globalUpdateInterval = serverConfig.globalUpdateInterval.value,
            updateMangas = serverConfig.updateMangas.value,
            // Authentication
            basicAuthEnabled = null,
            authUsername = null,
            authPassword = null,
            authMode = null,
            jwtAudience = serverConfig.jwtAudience.value,
            jwtTokenExpiry = serverConfig.jwtTokenExpiry.value,
            jwtRefreshExpiry = serverConfig.jwtRefreshExpiry.value,
            basicAuthUsername = null,
            basicAuthPassword = null,
            // Misc
            debugLogsEnabled = serverConfig.debugLogsEnabled.value,
            gqlDebugLogsEnabled = null,
            systemTrayEnabled = serverConfig.systemTrayEnabled.value,
            maxLogFiles = serverConfig.maxLogFiles.value,
            maxLogFileSize = serverConfig.maxLogFileSize.value,
            maxLogFolderSize = serverConfig.maxLogFolderSize.value,
            // Backup
            backupPath = null,
            backupTime = serverConfig.backupTime.value,
            backupInterval = serverConfig.backupInterval.value,
            backupTTL = serverConfig.backupTTL.value,
            autoBackupIncludeManga = serverConfig.autoBackupIncludeManga.value,
            autoBackupIncludeCategories = serverConfig.autoBackupIncludeCategories.value,
            autoBackupIncludeChapters = serverConfig.autoBackupIncludeChapters.value,
            autoBackupIncludeTracking = serverConfig.autoBackupIncludeTracking.value,
            autoBackupIncludeHistory = serverConfig.autoBackupIncludeHistory.value,
            autoBackupIncludeClientData = serverConfig.autoBackupIncludeClientData.value,
            autoBackupIncludeServerSettings = serverConfig.autoBackupIncludeServerSettings.value,
            // Local source
            localSourcePath = null,
            // Cloudflare
            flareSolverrEnabled = null,
            flareSolverrUrl = serverConfig.flareSolverrUrl.value,
            flareSolverrTimeout = serverConfig.flareSolverrTimeout.value,
            flareSolverrSessionName = serverConfig.flareSolverrSessionName.value,
            flareSolverrSessionTtl = serverConfig.flareSolverrSessionTtl.value,
            flareSolverrAsResponseFallback = serverConfig.flareSolverrAsResponseFallback.value,
            // OPDS
            opdsUseBinaryFileSizes = serverConfig.opdsUseBinaryFileSizes.value,
            opdsItemsPerPage = serverConfig.opdsItemsPerPage.value,
            opdsEnablePageReadProgress = serverConfig.opdsEnablePageReadProgress.value,
            opdsMarkAsReadOnDownload = serverConfig.opdsMarkAsReadOnDownload.value,
            opdsShowOnlyUnreadChapters = serverConfig.opdsShowOnlyUnreadChapters.value,
            opdsShowOnlyDownloadedChapters = serverConfig.opdsShowOnlyDownloadedChapters.value,
            opdsChapterSortOrder = serverConfig.opdsChapterSortOrder.value,
            opdsCbzMimetype = null,
            // KOReader sync
            koreaderSyncServerUrl = null,
            koreaderSyncUsername = null,
            koreaderSyncUserkey = null,
            koreaderSyncDeviceId = null,
            koreaderSyncChecksumMethod = serverConfig.koreaderSyncChecksumMethod.value,
            koreaderSyncStrategy = null,
            koreaderSyncPercentageTolerance = serverConfig.koreaderSyncPercentageTolerance.value,
            koreaderSyncStrategyForward = serverConfig.koreaderSyncStrategyForward.value,
            koreaderSyncStrategyBackward = serverConfig.koreaderSyncStrategyBackward.value,
            // Database
            databaseType = null,
            databaseUrl = null,
            databaseUsername = null,
            databasePassword = null,
            useHikariConnectionPool = null,
        )
    }

    fun restore(backupServerSettings: BackupServerSettings?) {
        if (backupServerSettings == null) { return }

        SettingsUpdater.updateAll(
            backupServerSettings.copy(
                basicAuthEnabled = SettingsRegistry.get("basicAuthEnabled")!!.typeInfo.restoreLegacy!!(backupServerSettings.basicAuthEnabled) as? Boolean,
                ip = null,
                port = null,
                socksProxyUsername = null,
                socksProxyPassword = null,
                electronPath = null,
                webUISubpath = null,
                downloadsPath = null,
                authUsername = null,
                authPassword = null,
                authMode = null,
                backupPath = null,
                localSourcePath = null,
                flareSolverrEnabled = null,
                opdsCbzMimetype = null,
                databaseType = null,
                databaseUrl = null,
                databaseUsername = null,
                databasePassword = null,
                useHikariConnectionPool = null,
            ),
        )
    }
}

