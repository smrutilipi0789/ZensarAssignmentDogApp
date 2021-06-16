package com.smruti.doggo.view.remote

import androidx.lifecycle.*
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map

import com.smruti.doggo.data.DogImageRepo
import com.smruti.doggo.model.DogImageModel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@ExperimentalPagingApi
class RemoteViewModel(
    val repository: DogImageRepo = DogImageRepo.getInstance()
) : ViewModel() {

    /**
     * we just mapped the data received from the repository to [PagingData<String>] to show the map
     * function you can always return the original model if needed, in our case it would be [DogImageModel]
     */
    fun fetchDoggoImages(): Flow<PagingData<String>> {
        return repository.letDoggoImagesFlow()
            .map { it.map { it.url } }
            .cachedIn(viewModelScope)
    }


}