package com.gabrielbmoro.programmingchallenge.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "favoritemovie")
data class FavoriteMovie(
        @PrimaryKey(autoGenerate = true) val mnDataBaseId : Long?,
        @ColumnInfo(name = "id") val mnId: Int,
        @ColumnInfo(name = "title") var mstrTitle : String,
        @ColumnInfo(name = "releasedate") var mstrReleaseDate : String,
        @ColumnInfo(name = "voteaverage") var msVoteAverage: Float)