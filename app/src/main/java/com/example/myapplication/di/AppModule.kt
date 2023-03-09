package com.example.myapplication.di

import android.app.Application
import androidx.room.Room
import com.example.myapplication.common.Constants.BASE_URL
import com.example.myapplication.data.local.LoremDB
import com.example.myapplication.data.remote.LoremApi
import com.example.myapplication.data.repository.FavRepositoryImpl
import com.example.myapplication.data.repository.RepositoryImpl
import com.example.myapplication.domain.model.Lorem
import com.example.myapplication.domain.repository.FavRepository
import com.example.myapplication.domain.repository.Repository
import com.example.myapplication.domain.use_case.local.DeleteFavUseCase
import com.example.myapplication.domain.use_case.local.FavUseCases
import com.example.myapplication.domain.use_case.local.GetFavsUseCase
import com.example.myapplication.domain.use_case.local.InsertFavUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): LoremApi{
        return retrofit.create(LoremApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: LoremApi): Repository = RepositoryImpl(api)

    @Singleton
    @Provides
    fun provideFavRepository(db: LoremDB): FavRepository = FavRepositoryImpl(db.loremDao())

    @Singleton
    @Provides
    fun provideRoomDatabase(app: Application): LoremDB {
        return Room.databaseBuilder(
            app,
            LoremDB::class.java,
            "database_name"
        ).build()
    }

    @Singleton
    @Provides
    fun provideUseCases(
        getFavsUseCase: GetFavsUseCase,
        insertFavUseCase: InsertFavUseCase,
        deleteFavUseCase: DeleteFavUseCase): FavUseCases{

        return FavUseCases(
            getFavsUseCase = getFavsUseCase,
            insertFavUseCase = insertFavUseCase,
            deleteFavUseCase = deleteFavUseCase
        )
    }


}
