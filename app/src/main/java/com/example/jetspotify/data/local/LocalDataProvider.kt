package com.example.jetspotify.data.model

import android.content.Context
import kotlinx.serialization.json.Json
import java.io.IOException

object LocalDataProvider {
    fun loadJSONFromAsset(context: Context, fileName: String): String? {
        return try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadCategories(context: Context): List<Category> {
        val json = loadJSONFromAsset(context, "categories_data.json")
        val categoryData = Json.decodeFromString<CategoryData>(json.toString())
        return categoryData.items ?: emptyList()

    }
}