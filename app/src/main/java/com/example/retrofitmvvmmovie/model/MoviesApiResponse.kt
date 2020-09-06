package com.example.retrofitmvvmmovie.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class MoviesApiResponse(
    @Json(name = "page")
    @JvmField val page: Int,
    @Json(name = "total_results")
    val totalResults: Int,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "results")
    val results: List<Result>
) : Parcelable
/*@Parcelize
@JsonClass(generateAdapter = true)
open class MoviesApiResponse() : Parcelable {
    @Json(name = "page")
    var page: Int? = null

    @Json(name = "total_results")
    var totalResults: Int? = null

    @Json(name = "total_pages")
    var totalPages: Int? = null

    @Json(name = "results")
    var results: List<Result?>? =
        null

    protected constructor(`in`: Parcel) : this() {
        page = `in`.readValue(Int::class.java.classLoader) as Int?
        totalResults = `in`.readValue(Int::class.java.classLoader) as Int?
        totalPages = `in`.readValue(Int::class.java.classLoader) as Int?
        `in`.readList(results, com.example.retrofitmvvmmovie.model.Result::class.java.classLoader)
    }

    constructor() : this() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(page)
        dest.writeValue(totalResults)
        dest.writeValue(totalPages)
        dest.writeList(results)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
         val CREATOR: Creator<MoviesApiResponse> = object : Creator<MoviesApiResponse> {
            override fun createFromParcel(parcel: Parcel): MoviesApiResponse? {
                return MoviesApiResponse(parcel)
            }

            override fun newArray(size: Int): Array<MoviesApiResponse?> {
                return arrayOfNulls(size)
            }
        }
    }
}*/
