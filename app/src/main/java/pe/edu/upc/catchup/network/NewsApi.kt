package pe.edu.upc.catchup.network

class NewsApi{
    companion object {
        val baseUrl = "https://newsapi.org"
        val topHeadLinesUrl = "$baseUrl/v2/top-headlines"
        val everythingUrl = "$baseUrl/v2/everything"
        val sourceUrl = "$baseUrl/v2/sources"
    }
}