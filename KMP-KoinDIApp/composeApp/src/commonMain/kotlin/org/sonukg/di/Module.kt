package org.sonukg.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.sonukg.data.repository.PostRepositoryImpl
import org.sonukg.data.service.PostService
import org.sonukg.domain.repository.PostRepository
import org.sonukg.domain.usecase.GetFavoritesUseCase
import org.sonukg.domain.usecase.GetPostsUseCase
import org.sonukg.domain.usecase.ToggleFavoriteUseCase
import org.sonukg.presentation.home.HomeViewModel
import org.sonukg.presentation.fav.FavViewModel

val appModule = module {
    // Network
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    }

    singleOf(::PostService)

    // Data
    singleOf(::PostRepositoryImpl) bind PostRepository::class

    // Domain
    singleOf(::GetPostsUseCase)
    singleOf(::ToggleFavoriteUseCase)
    singleOf(::GetFavoritesUseCase)

    // Presentation
    viewModelOf(::HomeViewModel)
    viewModelOf(::FavViewModel)
}
