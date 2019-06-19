package com.innovativequest.cv_app_mvp.utils

import android.widget.ProgressBar
import com.squareup.picasso.Callback
import java.lang.Exception

open class ImageLoadedCallback(internal var progressBar: ProgressBar?) : Callback {
    override fun onError(e: Exception?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess() {

    }


}