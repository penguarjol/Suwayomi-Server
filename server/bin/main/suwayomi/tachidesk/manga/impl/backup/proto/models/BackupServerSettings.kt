@file:Suppress("ktlint")

/*
 * Copyright (C) Contributors to the Suwayomi project
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

package suwayomi.tachidesk.manga.impl.backup.proto.models


import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import suwayomi.tachidesk.graphql.types.Settings
import suwayomi.tachidesk.graphql.types.WebUIFlavor
import suwayomi.tachidesk.graphql.types.WebUIInterface
import suwayomi.tachidesk.graphql.types.WebUIChannel
import org.jetbrains.exposed.sql.SortOrder
import suwayomi.tachidesk.graphql.types.AuthMode
import suwayomi.tachidesk.manga.impl.backup.proto.models.BackupSettingsDownloadConversionType
import suwayomi.tachidesk.graphql.types.KoreaderSyncChecksumMethod
import suwayomi.tachidesk.graphql.types.KoreaderSyncLegacyStrategy
import kotlin.time.Duration
import suwayomi.tachidesk.graphql.types.DatabaseType
import suwayomi.tachidesk.graphql.types.KoreaderSyncConflictStrategy
import suwayomi.tachidesk.graphql.types.CbzMediaType


@Serializable
data class BackupServerSettings(
    @ProtoNumber(1) override var ip: String? = null,
    @ProtoNumber(2) override var port: Int? = null,
    @ProtoNumber(3) override var socksProxyEnabled: Boolean? = null,
    @ProtoNumber(4) override var socksProxyVersion: Int? = null,
    @ProtoNumber(5) override var socksProxyHost: String? = null,
    @ProtoNumber(6) override var socksProxyPort: String? = null,
    @ProtoNumber(7) override var socksProxyUsername: String? = null,
    @ProtoNumber(8) override var socksProxyPassword: String? = null,
    @ProtoNumber(9) override var webUIFlavor: WebUIFlavor? = null,
    @ProtoNumber(10) override var initialOpenInBrowserEnabled: Boolean? = null,
    @ProtoNumber(11) override var webUIInterface: WebUIInterface? = null,
    @ProtoNumber(12) override var electronPath: String? = null,
    @ProtoNumber(13) override var webUIChannel: WebUIChannel? = null,
    @ProtoNumber(14) override var webUIUpdateCheckInterval: Double? = null,
    @ProtoNumber(15) override var downloadAsCbz: Boolean? = null,
    @ProtoNumber(16) override var downloadsPath: String? = null,
    @ProtoNumber(17) override var autoDownloadNewChapters: Boolean? = null,
    @ProtoNumber(18) override var excludeEntryWithUnreadChapters: Boolean? = null,
    @Deprecated("Replaced with autoDownloadNewChaptersLimit", ReplaceWith("autoDownloadNewChaptersLimit"))
    @ProtoNumber(19) override var autoDownloadAheadLimit: Int? = null,
    @ProtoNumber(20) override var autoDownloadNewChaptersLimit: Int? = null,
    @ProtoNumber(21) override var autoDownloadIgnoreReUploads: Boolean? = null,
    @ProtoNumber(22) override var extensionRepos: List<String>? = null,
    @ProtoNumber(23) override var maxSourcesInParallel: Int? = null,
    @ProtoNumber(24) override var excludeUnreadChapters: Boolean? = null,
    @ProtoNumber(25) override var excludeNotStarted: Boolean? = null,
    @ProtoNumber(26) override var excludeCompleted: Boolean? = null,
    @ProtoNumber(27) override var globalUpdateInterval: Double? = null,
    @ProtoNumber(28) override var updateMangas: Boolean? = null,
    @Deprecated("Removed - prefer authMode", ReplaceWith("authMode"))
    @ProtoNumber(29) override var basicAuthEnabled: Boolean? = null,
    @ProtoNumber(30) override var authUsername: String? = null,
    @ProtoNumber(31) override var authPassword: String? = null,
    @ProtoNumber(32) override var debugLogsEnabled: Boolean? = null,
    @Deprecated("Removed - does not do anything")
    @ProtoNumber(33) override var gqlDebugLogsEnabled: Boolean? = null,
    @ProtoNumber(34) override var systemTrayEnabled: Boolean? = null,
    @ProtoNumber(35) override var maxLogFiles: Int? = null,
    @ProtoNumber(36) override var maxLogFileSize: String? = null,
    @ProtoNumber(37) override var maxLogFolderSize: String? = null,
    @ProtoNumber(38) override var backupPath: String? = null,
    @ProtoNumber(39) override var backupTime: String? = null,
    @ProtoNumber(40) override var backupInterval: Int? = null,
    @ProtoNumber(41) override var backupTTL: Int? = null,
    @ProtoNumber(42) override var localSourcePath: String? = null,
    @ProtoNumber(43) override var flareSolverrEnabled: Boolean? = null,
    @ProtoNumber(44) override var flareSolverrUrl: String? = null,
    @ProtoNumber(45) override var flareSolverrTimeout: Int? = null,
    @ProtoNumber(46) override var flareSolverrSessionName: String? = null,
    @ProtoNumber(47) override var flareSolverrSessionTtl: Int? = null,
    @ProtoNumber(48) override var flareSolverrAsResponseFallback: Boolean? = null,
    @ProtoNumber(49) override var opdsUseBinaryFileSizes: Boolean? = null,
    @ProtoNumber(50) override var opdsItemsPerPage: Int? = null,
    @ProtoNumber(51) override var opdsEnablePageReadProgress: Boolean? = null,
    @ProtoNumber(52) override var opdsMarkAsReadOnDownload: Boolean? = null,
    @ProtoNumber(53) override var opdsShowOnlyUnreadChapters: Boolean? = null,
    @ProtoNumber(54) override var opdsShowOnlyDownloadedChapters: Boolean? = null,
    @ProtoNumber(55) override var opdsChapterSortOrder: SortOrder? = null,
    @ProtoNumber(56) override var authMode: AuthMode? = null,
    @ProtoNumber(57) override var downloadConversions: List<BackupSettingsDownloadConversionType>? = null,
    @ProtoNumber(58) override var jwtAudience: String? = null,
    @Deprecated("Moved to preference store. User is supposed to use a login/logout mutation", ReplaceWith("MOVE TO PREFERENCES"))
    @ProtoNumber(59) override var koreaderSyncServerUrl: String? = null,
    @Deprecated("Moved to preference store. User is supposed to use a login/logout mutation", ReplaceWith("MOVE TO PREFERENCES"))
    @ProtoNumber(60) override var koreaderSyncUsername: String? = null,
    @Deprecated("Moved to preference store. User is supposed to use a login/logout mutation", ReplaceWith("MOVE TO PREFERENCES"))
    @ProtoNumber(61) override var koreaderSyncUserkey: String? = null,
    @Deprecated("Moved to preference store. Is supposed to be random and gets auto generated", ReplaceWith("MOVE TO PREFERENCES"))
    @ProtoNumber(62) override var koreaderSyncDeviceId: String? = null,
    @ProtoNumber(63) override var koreaderSyncChecksumMethod: KoreaderSyncChecksumMethod? = null,
    @Deprecated("Replaced with koreaderSyncStrategyForward and koreaderSyncStrategyBackward", ReplaceWith("koreaderSyncStrategyForward, koreaderSyncStrategyBackward"))
    @ProtoNumber(64) override var koreaderSyncStrategy: KoreaderSyncLegacyStrategy? = null,
    @ProtoNumber(65) override var koreaderSyncPercentageTolerance: Double? = null,
    @ProtoNumber(66) override var jwtTokenExpiry: Duration? = null,
    @ProtoNumber(67) override var jwtRefreshExpiry: Duration? = null,
    @ProtoNumber(68) override var webUIEnabled: Boolean? = null,
    @ProtoNumber(69) override var databaseType: DatabaseType? = null,
    @ProtoNumber(70) override var databaseUrl: String? = null,
    @ProtoNumber(71) override var databaseUsername: String? = null,
    @ProtoNumber(72) override var databasePassword: String? = null,
    @ProtoNumber(73) override var koreaderSyncStrategyForward: KoreaderSyncConflictStrategy? = null,
    @ProtoNumber(74) override var koreaderSyncStrategyBackward: KoreaderSyncConflictStrategy? = null,
    @ProtoNumber(75) override var webUISubpath: String? = null,
    @ProtoNumber(76) override var autoBackupIncludeManga: Boolean? = null,
    @ProtoNumber(77) override var autoBackupIncludeCategories: Boolean? = null,
    @ProtoNumber(78) override var autoBackupIncludeChapters: Boolean? = null,
    @ProtoNumber(79) override var autoBackupIncludeTracking: Boolean? = null,
    @ProtoNumber(80) override var autoBackupIncludeHistory: Boolean? = null,
    @ProtoNumber(81) override var autoBackupIncludeClientData: Boolean? = null,
    @ProtoNumber(82) override var autoBackupIncludeServerSettings: Boolean? = null,
    @ProtoNumber(83) override var opdsCbzMimetype: CbzMediaType? = null,
    @ProtoNumber(84) override var serveConversions: List<BackupSettingsDownloadConversionType>? = null,
    @ProtoNumber(85) override var useHikariConnectionPool: Boolean? = null,
    @Deprecated("Removed - prefer authUsername", ReplaceWith("authUsername"))
    @ProtoNumber(99991) override var basicAuthUsername: String? = null,
    @Deprecated("Removed - prefer authPassword", ReplaceWith("authPassword"))
    @ProtoNumber(99992) override var basicAuthPassword: String? = null,
) : Settings

