package com.devdroid.komato.domain.repo.useCases

import com.devdroid.komato.comman.ResultState
import com.devdroid.komato.data.models.UserData
import com.devdroid.komato.domain.repo.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(val repo : Repo) {

    fun createUser(userData: UserData): Flow<ResultState<String>> {
        return repo.registerWithEmailAndPassword(userData)
    }
}