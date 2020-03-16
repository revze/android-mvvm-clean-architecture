package com.example.belajardagger.domain.usecase.games

import com.example.belajardagger.data.services.api.Resource
import com.example.belajardagger.data.model.Games
import com.example.belajardagger.data.repository.IgdbRepository
import javax.inject.Inject

class GetGamesUseCaseImpl @Inject constructor(private val repository: IgdbRepository) :
    GetGamesUseCase {

//    override operator fun invoke(scope: CoroutineScope): LiveData<State<List<Games>>> =
//        liveData(scope.coroutineContext) {
//            emit(State.Loading())
//
//            withContext(Dispatchers.IO) {
//                when (val result = repository.getGames()) {
//                    is Resource.Success -> {
//                        emit(State.Success(result.data))
//                    }
//                    is Resource.Error -> {
//                        emit(State.Error(result.message))
//                    }
//                }
//            }
//        }

    override suspend fun invoke(): Resource<List<Games>> {
        return repository.getGames()
    }
}