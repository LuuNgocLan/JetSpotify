package com.jetspotify.data.model

import android.content.Context
import com.jetspotify.data.model.PlaylistData
import com.jetspotify.data.model.SpotifyPlaylist
import com.jetspotify.model.Album
import com.jetspotify.model.Episode
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

    fun loadPlaylists(context: Context): List<SpotifyPlaylist> {
        val json = loadJSONFromAsset(context, "playlists_data.json")
        val playlistData = Json.decodeFromString<PlaylistData>(json.toString())
        return playlistData.items
    }

    fun loadAlbums(): List<Album> = listOf(
        Album(
            name = "Happier Than Ever",
            availableMarkets = listOf("US", "CA", "MX"),
            href = "https://api.spotify.com/v1/albums/1ZfK0eV4hjw7Z5z9Z0Z8lJ",
            id = "1ZfK0eV4hjw7Z5z9Z0Z8lJ",
            images = "https://is1-ssl.mzstatic.com/image/thumb/Music115/v4/2d/f3/c9/2df3c9fd-e0eb-257c-c035-b04f05a66580/21UMGIM36691.rgb.jpg/1200x1200bb.jpg",
        ),

        Album(
            name = "Taylor Swift eras ranking – The Marquee",
            availableMarkets = listOf("US", "CA", "MX"),
            href = "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/fa9d29113106917.6021714777c0e.png",
            id = "7fJJK56U9fHixgO0HQkhtI",
            images = "https://www.mhsmarquee.com/wp-content/uploads/2023/12/taylor-swift-960x1200.jpg",
        ),
        Album(
            name = "Raised Up Right",
            availableMarkets = listOf("US", "CA", "MX"),
            href = "https://api.spotify.com/v1/albums/4yP0hdKOZPNshxUOjY0cZj",
            id = "4yP0hdKOZPNshxUOjY0cZj",
            images = "https://cdns-images.dzcdn.net/images/cover/2ecc057464cd10bdce436adafcc92ba2/0x1900-000000-80-0-0.jpg",
        ),
        Album(
            name = "SOUR",
            availableMarkets = listOf("US", "CA", "MX"),
            href = "https://api.spotify.com/v1/albums/6s84u2TUpR3wdUv4NgKA2j",
            id = "6s84u2TUpR3wdUv4NgKA2j",
            images = "https://i.scdn.co/image/ab67616d0000b273f4b3b3b3b3b3b3b3b3b3b3",
        ),
    )

    fun sampleEpisodeData(): List<Episode> {
        return listOf(
            Episode(
                id = "1",
                title = "With AI, anyone can be a coder now",
                speaker = "Thomas Dohmke",
                showName = "TED Talks Daily",
                publishDate = "23 May",
                duration = "15min",
                description = "What if you could code just by talking out loud? GitHub CEO Thomas Dohmke shows how, thanks to AI, the barrier to entry to coding is rapidly disappearing — and creating software is becoming as simple (and joyful) as building LEGO. In a mind-blowing live demo, he introduces Copilot Workspace: an AI assistant that helps you create code when you speak to it, in any language.",
                thumbnailUrl = "https://pi.tedcdn.com/r/talkstar-assets.s3.amazonaws.com/production/talks/talk_140316/2e0bec30-0254-4de7-83db-5670bda214fe/TAC-HowToBeABetterHuman.jpg?u%5Br%5D=2&u%5Bs%5D=0.5&u%5Ba%5D=0.8&u%5Bt%5D=0.03&quality=80&w=1080",
                isDownloaded = true,
            ),
            Episode(
                id = "2",
                title = "How a Hi level mindset helps you realize your potential",
                speaker = "Cordae",
                showName = "TED Talks Daily",
                publishDate = "22 May",
                duration = "20min",
                description = "Brené Brown studies human connection -- our ability to empathize, belong, love. In a poignant, funny talk at TEDxHouston, she shares a deep insight from her research, one that sent her on a personal quest to know herself as well as to understand humanity. A talk to share.",
                thumbnailUrl = "https://pi.tedcdn.com/r/talkstar-assets.s3.amazonaws.com/production/talks/talk_137123/b23cc055-2d83-486f-899a-1f2cf19469b5/HrundGunnsteinsdottir_2024T-embed.jpg?u%5Br%5D=2&u%5Bs%5D=0.5&u%5Ba%5D=0.8&u%5Bt%5D=0.03&quality=80&w=1080",
                isDownloaded = false,
            ),
            Episode(
                id = "3",
                title = "Understanding Human Psychology",
                speaker = "Brené Brown",
                showName = "TED Talks Daily",
                publishDate = "22 May",
                duration = "20min",
                description = "Explore the fascinating world of human psychology with our expert guest discussing latest research in behavioral sciences.",
                thumbnailUrl = "https://pi.tedcdn.com/r/talkstar-assets.s3.amazonaws.com/production/talks/talk_139428/26a18550-7d97-4dbb-94a8-7c54e6178e61/FranziskaTrautmann_2024N-embed.jpg?u%5Br%5D=2&u%5Bs%5D=0.5&u%5Ba%5D=0.8&u%5Bt%5D=0.03&quality=80&w=1080",
                isDownloaded = false,
            ),
            Episode(
                id = "4",
                title = "Digital Art Revolution",
                speaker = "Brené Brown",
                showName = "TED Talks Daily",
                publishDate = "22 May",
                duration = "20min",
                description = "Discover how digital technologies are transforming the art world, featuring interviews with leading digital artists.",
                thumbnailUrl = "https://pi.tedcdn.com/r/talkstar-assets.s3.amazonaws.com/production/talks/talk_139914/be18855e-1dd8-4467-8fc0-8859e9919268/LeopoldoLopez_2024N-embed.jpg?u%5Br%5D=2&u%5Bs%5D=0.5&u%5Ba%5D=0.8&u%5Bt%5D=0.03&quality=80&w=1080",
                isDownloaded = true,
            ),
            Episode(
                id = "5",
                title = "The Future of Sustainable Technology",
                speaker = "Brené Brown",
                showName = "TED Talks Daily",
                publishDate = "22 May",
                duration = "20min",
                description = "Join us for an insightful discussion about sustainable technology and its impact on our future. Our guest expert shares valuable perspectives on renewable energy innovations.\"",
                thumbnailUrl = "https://pi.tedcdn.com/r/talkstar-assets.s3.amazonaws.com/production/talks/talk_139302/e0fddc91-9b73-4b5b-8e28-de4a21808c4f/monkeyspaw_textless.jpg?u%5Br%5D=2&u%5Bs%5D=0.5&u%5Ba%5D=0.8&u%5Bt%5D=0.03&quality=80&w=1080",
                isDownloaded = false,
            ),
        )
    }

    fun sampleShowsData(): List<Show> = listOf(
        Show(
            id = "1",
            showName = "TED Talks Daily",
            description = "Every weekday, this podcast brings you the ideas that matter in the world of ideas. Join host and journalist Elise Hu for thought-provoking ideas on every subject imaginable — from Artificial Intelligence to Zoology, and everything in between — given by the world's leading thinkers and creators. With TED Talks Daily, find some space in your day to change your perspectives, ignite your curiosity, and learn something new.",
            thumbnail = "https://pi.tedcdn.com/r/pb-assets.tedcdn.com/system/baubles/files/000/005/187/original/TED_Talks_Podcast_Thumbnail_Audio_600px.png?u%5Br%5D=2&u%5Bs%5D=0.5&u%5Ba%5D=0.8&u%5Bt%5D=0.03&quality=82",
            category = listOf("Arts & Entertainment", "Business", "Education"),
            showType = "TED",
        ),
        Show(
            id = "2",
            showName = "The Daily",
            description = "This is how the news should sound. Twenty minutes a day, five days a week, hosted by Michael Barbaro and powered by New York Times journalism.",
            thumbnail = "https://play-lh.googleusercontent.com/SorSPVeYVg5hYDO7TIf7jT77jYlkaRCmvTfvPiL33XLodM9x6hRfF2ahujCbviAU0meIiyAr2jxNHsa0gA",
            category = listOf("News & Politics"),
            showType = "News",
        ),
        Show(
            id = "3",
            showName = "The Joe Rogan Experience",
            description = "The Joe Rogan Experience podcast is a long form conversation hosted by comedian Joe Rogan with friends and guests that have included comedians, actors, musicians, MMA fighters, authors, artists, and beyond.",
            thumbnail = "https://is1-ssl.mzstatic.com/image/thumb/Podcasts211/v4/56/8e/98/568e984f-d307-f8ed-dfe4-5d78f155a891/mza_13284941915068760437.jpg/1200x1200bf.webp",
            category = listOf("Comedy", "Health", "Music"),
            showType = "Comedy",
        ),
        Show(
            id = "4",
            showName = "The Michelle Obama Podcast",
            description = "The Michelle Obama Podcast features the former First Lady diving deep into conversations with loved ones—family, friends, and colleagues—on the relationships in our lives that make us who we are.",
            thumbnail = "https://media.vanityfair.com/photos/5ea70d5125995900086fa019/master/w_2560%2Cc_limit/GettyImages-1148536496.jpg",
            category = listOf("Society & Culture", "Health", "Music"),
            showType = "Comedy",
        ),
        Show(
            id = "5",
            showName = "The Daily Show With Trevor Noah",
            description = "Trevor Noah and The Daily Show correspondents tackle the biggest stories in news, politics and pop culture.",
            thumbnail = "https://www.emmys.com/sites/default/files/logos/logo-daily-show-2-2022-noms-600x600.jpg",
            category = listOf("Comedy", "Health", "Music"),
            showType = "Comedy",
        ),
        Show(
            id = "6",
            showName = "The Tim Ferriss Show",
            description = "The Tim Ferriss Show is often the #1 business podcast on all of Apple Podcasts, and it's been ranked #1 out of 500,000+ podcasts on many occasions. It is the first business/interview podcast to pass 100,000,000 downloads, and it has been selected as \"Best of\" Apple Podcasts for three years running (2016, 2017, 2018). Each episode, Tim deconstructs world-class performers from eclectic areas (investing, sports, business, art, etc.) to extract the tactics, tools, and routines you can use. This includes favorite books, morning routines, exercise habits, time-management tricks, and much more.",
            thumbnail = "https://podcastle.ai/blog/content/images/2023/10/tim-ferriss.webp",
            category = listOf("Business", "Health", "Music"),
            showType = "Business",
        ),
        Show(
            id = "7",
            showName = "The Dave Ramsey Show",
            description = "The Dave Ramsey Show offers up straight talk on life and money. Millions listen in as callers from all walks of life learn how to get out of debt and start building for the future. Check out the fifth most downloaded podcast! For more information, visit www.daveramsey.com",
            thumbnail = "https://is1-ssl.mzstatic.com/image/thumb/Podcasts113/v4/0b/7b/7b/0b7b7b7b-1b1b-4b1b-8b7b-7b0b7b0b7b0b/mza_1160730730190190977.jpg/1200x1200bf.webp",
            category = listOf("Business", "Health", "Music"),
            showType = "Business",
        ),
        Show(
            id = "8",
            showName = "The Tony Robbins Podcast",
            description = "The Tony Robbins podcast gives you access to the best minds in the world. Whether you want to learn how to build a business, improve your health, or master your finances, Tony and his team will give you the tools you need to take your life to the next level.",
            thumbnail = "https://is1-ssl.mzstatic.com/image/thumb/Podcasts221/v4/82/1f/43/821f43a6-a4bf-3f89-f424-6f26e7236be6/mza_12390086600980659063.jpeg/1200x1200bf.webp",
            category = listOf("Business", "Health", "Music"),
            showType = "Business",
        ),
        Show(
            id = "9",
            showName = "The Ed Mylett Show",
            description = "Showcasing the greatest peak performers across all industries in one place, sharing their journey, knowledge and thought leadership. With guests from the world of entrepreneurship, sports, entertainment, health, wellness, and philanthropy.",
            thumbnail = "https://is1-ssl.mzstatic.com/image/thumb/Podcasts113/v4/0b/7b/7b/0b7b7b7b-1b1b-4b1b-8b7b-7b0b7b0b7b0b/mza_1160730730190190977.jpg/1200x1200bf.webp",
            category = listOf("Business", "Health", "Music"),
            showType = "Business",
        ),
    )
}