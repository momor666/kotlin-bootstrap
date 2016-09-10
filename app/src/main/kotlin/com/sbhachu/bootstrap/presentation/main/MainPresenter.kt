package com.sbhachu.bootstrap.presentation.main

import com.sbhachu.bootstrap.presentation.main.IMainViewContract
import com.sbhachu.bootstrap.presentation.common.BasePresenter


class MainPresenter(view: IMainViewContract) : BasePresenter<IMainViewContract>(view) {

    private val TAG: String = this@MainPresenter.javaClass.simpleName

}


