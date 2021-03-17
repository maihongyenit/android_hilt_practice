package com.example.hilt_practice.di

import com.example.hilt_practice.datasource.network.BlogRetrofitService
import com.example.hilt_practice.datasource.network.BlogRetrofitServiceImpl
import com.example.hilt_practice.datasource.network.mappers.NetworkMapper
import com.example.hilt_practice.datasource.network.retrofit.BlogRetrofit
import com.example.hilt_practice.domain.data.network.NetworkDataSource
import com.example.hilt_practice.domain.data.network.NetworkDataSourceImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkDataSource(
        blogRetrofitService: BlogRetrofitService,
        networkMapper: NetworkMapper
    ): NetworkDataSource {
        return NetworkDataSourceImpl(blogRetrofitService, networkMapper)
    }

    @Singleton
    @Provides
    fun provideBlogRetrofitService(blogRetrofit: BlogRetrofit): BlogRetrofitService {
        return BlogRetrofitServiceImpl(blogRetrofit)
    }

    @Singleton
    @Provides
    fun provideBlogRetrofit(retrofit: Retrofit): BlogRetrofit {
        return retrofit.create(BlogRetrofit::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyz/placeholder/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Singleton
    @Provides
    fun provideNetworkMapper() = NetworkMapper()
}