package com.network.worldnews

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.network.worldnews.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source?): String {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun toSource(sourceString: String?): Source? {
        return Gson().fromJson(sourceString, Source::class.java)
    }
}
