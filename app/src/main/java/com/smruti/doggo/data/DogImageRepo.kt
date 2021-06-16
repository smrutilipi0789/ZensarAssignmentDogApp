package com.smruti.doggo.data

import androidx.lifecycle.LiveData
import androidx.paging.*
import androidx.paging.rxjava2.observable
import com.smruti.doggo.model.DogImageModel

import com.smruti.doggo.repository.remote.DoggoApiService
import com.smruti.doggo.repository.remote.RemoteInjector
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

/**
 * repository class to manage the data flow and map it if needed
 */
@ExperimentalPagingApi
class DogImageRepo(
    val doggoApiService: DoggoApiService = RemoteInjector.injectDoggoApiService()) {

    companion object {
        const val DEFAULT_PAGE_INDEX = 1
        const val DEFAULT_PAGE_SIZE = 20

        //get dog repository instance
        fun getInstance() = DogImageRepo()
    }

    /**
     * calling the paging source to give results from api calls
     * and returning the results in the form of flow [Flow<PagingData<DoggoImageModel>>]
     * since the [PagingDataAdapter] accepts the [PagingData] as the source in later stage
     */
    fun letDoggoImagesFlow(pagingConfig: PagingConfig = getDefaultPageConfig()): Flow<PagingData<DogImageModel>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { DogImagePagingSource(doggoApiService) }
        ).flow
    }
    /**
     *  defining page size, page size is the only required param, rest is optional
     */
    fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = DEFAULT_PAGE_SIZE, enablePlaceholders = true)
    }



}