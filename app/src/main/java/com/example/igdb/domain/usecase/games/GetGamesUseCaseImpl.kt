package com.example.igdb.domain.usecase.games

import com.example.igdb.data.services.api.Resource
import com.example.igdb.data.model.Games
import com.example.igdb.data.repository.IgdbRepository
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