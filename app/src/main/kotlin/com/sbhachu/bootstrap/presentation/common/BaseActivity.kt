package com.sbhachu.bootstrap.presentation.common

import android.app.Dialog
import android.content.SharedPreferences
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import com.sbhachu.bootstrap.R
import com.sbhachu.bootstrap.extensions.action
import com.sbhachu.bootstrap.extensions.snack
import com.sbhachu.bootstrap.presentation.common.BasePresenter


abstract class BaseActivity<T : BasePresenter<*>> : AppCompatActivity() {

    protected var presenter: T?

    protected abstract var layoutId: Int

    var snackbarContainer: LinearLayout? = null

    private lateinit var dialog: Dialog
     var snackbar: Snackbar? = null

    init {
        presenter = initialisePresenter()
    }

    protected abstract fun initialisePresenter(): T
    protected abstract fun initialiseViews(): Unit
    protected abstract fun initialiseListeners(): Unit
    protected abstract fun handleExtras(bundle: Bundle?): Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        handleExtras(intent?.extras)

        snackbarContainer = findViewById(R.id.snackbar_container) as LinearLayout?

        initialiseViews()
        initialiseListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.dispose()
        presenter = null
    }

    /**
     * Show a custom alertDialog
     *
     * dialogBuilder - Configure and pass in an instance of an AlertDialog.Builder
     */
    protected fun showDialog(dialogBuilder: AlertDialog.Builder?) {
        dialog = dialogBuilder?.create() as Dialog
        dialog.show()
    }

    /**
     * Show a custom snackbar
     *
     * message - Snackbar text
     * duration - Snackbar duration, defaults to LENGTH_LONG
     * actionLabel - Snackbar action label, for example Dismiss
     * actionFunction - Snackbar action handler function
     */
    protected fun showSnackbar(message: String, duration: Int?, actionLabel: String, actionFunction: () -> Unit): Unit {
        if (snackbar?.isShown ?: false) return

        snackbar = snackbarContainer?.snack(message, duration ?: Snackbar.LENGTH_LONG) {
            action(actionLabel) { actionFunction() }
        }

        snackbar?.show()
    }

    /**
     * Hide custom snackbar
     */
    protected fun hideSnackbar(): () -> Unit = { snackbar?.dismiss() }
}