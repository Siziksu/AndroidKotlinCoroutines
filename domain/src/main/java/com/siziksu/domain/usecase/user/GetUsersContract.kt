package com.siziksu.domain.usecase.user

import com.siziksu.domain.common.base.UseCaseContract
import com.siziksu.domain.model.UserDomain

interface GetUsersContract : UseCaseContract<GetUsersContract.Param, List<UserDomain>> {

    class Param
}