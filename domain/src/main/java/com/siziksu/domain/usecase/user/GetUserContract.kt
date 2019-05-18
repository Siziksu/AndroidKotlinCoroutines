package com.siziksu.domain.usecase.user

import com.siziksu.domain.common.base.UseCaseContract
import com.siziksu.domain.model.UserDomain

interface GetUserContract : UseCaseContract<GetUserContract.Param, UserDomain> {

    class Param(val userId: Int)
}