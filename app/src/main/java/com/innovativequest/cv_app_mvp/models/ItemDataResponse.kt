package com.innovativequest.cv_app_mvp.models

import com.google.gson.annotations.SerializedName

data class ItemDataResponse(

	@field:SerializedName("achievements")
	val achievements: String? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("jobTitle")
	val jobTitle: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null
)