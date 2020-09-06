package com.example.retrofitmvvmmovie.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "popularity")
    @JvmField val popularity: Double,
    @Json(name = "vote_count")
    val voteCount: Int,
    @Json(name = "video")
    val video: Boolean,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "genre_ids")
    val genreIds: List<Int>,
    @Json(name = "title")
    val title: String,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "release_date")
    val releaseDate: String
):Parcelable

/*
@JsonClass(generateAdapter = true)
class Result : Parcelable {
    @Json(name = "popularity")
    var popularity: Double? = null

    @Json(name = "vote_count")
    var voteCount: Int? = null

    @Json(name = "video")
    var video: Boolean? = null

    @Json(name = "poster_path")
    var posterPath: String? = null

    @Json(name = "id")
    var id: Int? = null

    @Json(name = "adult")
    var adult: Boolean? = null

    @Json(name = "backdrop_path")
    var backdropPath: String? = null

    @Json(name = "original_language")
    var originalLanguage: String? = null

    @Json(name = "original_title")
    var originalTitle: String? = null

    @Json(name = "genre_ids")
    var genreIds: List<Int?>? = null

    @Json(name = "title")
    var title: String? = null

    @Json(name = "vote_average")
    var voteAverage: Double? = null

    @Json(name = "overview")
    var overview: String? = null

    @Json(name = "release_date")
    var releaseDate: String? = null

    protected constructor(`in`: Parcel) {
        popularity =
            `in`.readValue(Double::class.java.classLoader) as Double?
        voteCount = `in`.readValue(Int::class.java.classLoader) as Int?
        video =
            `in`.readValue(Boolean::class.java.classLoader) as Boolean?
        posterPath =
            `in`.readValue(String::class.java.classLoader) as String?
        id = `in`.readValue(Int::class.java.classLoader) as Int?
        adult =
            `in`.readValue(Boolean::class.java.classLoader) as Boolean?
        backdropPath =
            `in`.readValue(String::class.java.classLoader) as String?
        originalLanguage =
            `in`.readValue(String::class.java.classLoader) as String?
        originalTitle =
            `in`.readValue(String::class.java.classLoader) as String?
        `in`.readList(genreIds, Int::class.java.classLoader)
        title =
            `in`.readValue(String::class.java.classLoader) as String?
        voteAverage =
            `in`.readValue(Double::class.java.classLoader) as Double?
        overview =
            `in`.readValue(String::class.java.classLoader) as String?
        releaseDate =
            `in`.readValue(String::class.java.classLoader) as String?
    }

    constructor() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(popularity)
        dest.writeValue(voteCount)
        dest.writeValue(video)
        dest.writeValue(posterPath)
        dest.writeValue(id)
        dest.writeValue(adult)
        dest.writeValue(backdropPath)
        dest.writeValue(originalLanguage)
        dest.writeValue(originalTitle)
        dest.writeList(genreIds)
        dest.writeValue(title)
        dest.writeValue(voteAverage)
        dest.writeValue(overview)
        dest.writeValue(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Result> = object : Creator<Result> {
            override fun createFromParcel(`in`: Parcel): Result? {
                return Result(`in`)
            }

            override fun newArray(size: Int): Array<Result?> {
                return arrayOfNulls(size)
            }
        }
    }
}
*/
