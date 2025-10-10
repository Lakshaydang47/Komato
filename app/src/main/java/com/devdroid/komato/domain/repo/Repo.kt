package com.devdroid.komato.domain.repo

import com.devdroid.komato.comman.ResultState
import com.devdroid.komato.data.models.UserData
import kotlinx.coroutines.flow.Flow

interface Repo {

    fun loginWithEmailAndPassword(userData: UserData): Flow<ResultState<String>>
    fun registerWithEmailAndPassword(userData: UserData): Flow<ResultState<String>>
}