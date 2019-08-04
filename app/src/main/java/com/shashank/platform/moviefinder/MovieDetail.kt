package com.shashank.platform.moviefinder

import com.google.gson.annotations.SerializedName

class MovieDetail {

    @SerializedName("Response")
    private var response: String? = null
    @SerializedName("Website")
    private var website: String? = null
    @SerializedName("Production")
    private var production: String? = null
    @SerializedName("BoxOffice")
    private var boxoffice: String? = null
    @SerializedName("DVD")
    private var dvd: String? = null
    @SerializedName("Type")
    private var type: String? = null
    @SerializedName("imdbID")
    private var imdbid: String? = null
    @SerializedName("imdbVotes")
    private var imdbvotes: String? = null
    @SerializedName("imdbRating")
    private var imdbrating: String? = null
    @SerializedName("Metascore")
    private var metascore: String? = null
    @SerializedName("Ratings")
    private var ratings: List<Ratings>? = null
    @SerializedName("Poster")
    private var poster: String? = null
    @SerializedName("Awards")
    private var awards: String? = null
    @SerializedName("Country")
    private var country: String? = null
    @SerializedName("Language")
    private var language: String? = null
    @SerializedName("Plot")
    private var plot: String? = null
    @SerializedName("Actors")
    private var actors: String? = null
    @SerializedName("Writer")
    private var writer: String? = null
    @SerializedName("Director")
    private var director: String? = null
    @SerializedName("Genre")
    private var genre: String? = null
    @SerializedName("Runtime")
    private var runtime: String? = null
    @SerializedName("Released")
    private var released: String? = null
    @SerializedName("Rated")
    private var rated: String? = null
    @SerializedName("Year")
    private var year: String? = null
    @SerializedName("Title")
    private var title: String? = null

    inner class Ratings {
        @SerializedName("Value")
        var value: String? = null
        @SerializedName("Source")
        var source: String? = null
    }

    fun getResponse(): String? {
        return response
    }

    fun setResponse(response: String) {
        this.response = response
    }

    fun getWebsite(): String? {
        return website
    }

    fun setWebsite(website: String) {
        this.website = website
    }

    fun getProduction(): String? {
        return production
    }

    fun setProduction(production: String) {
        this.production = production
    }

    fun getBoxoffice(): String? {
        return boxoffice
    }

    fun setBoxoffice(boxoffice: String) {
        this.boxoffice = boxoffice
    }

    fun getDvd(): String? {
        return dvd
    }

    fun setDvd(dvd: String) {
        this.dvd = dvd
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getImdbid(): String? {
        return imdbid
    }

    fun setImdbid(imdbid: String) {
        this.imdbid = imdbid
    }

    fun getImdbvotes(): String? {
        return imdbvotes
    }

    fun setImdbvotes(imdbvotes: String) {
        this.imdbvotes = imdbvotes
    }

    fun getImdbrating(): String? {
        return imdbrating
    }

    fun setImdbrating(imdbrating: String) {
        this.imdbrating = imdbrating
    }

    fun getMetascore(): String? {
        return metascore
    }

    fun setMetascore(metascore: String) {
        this.metascore = metascore
    }

    fun getRatings(): List<Ratings>? {
        return ratings
    }

    fun setRatings(ratings: List<Ratings>) {
        this.ratings = ratings
    }

    fun getPoster(): String? {
        return poster
    }

    fun setPoster(poster: String) {
        this.poster = poster
    }

    fun getAwards(): String? {
        return awards
    }

    fun setAwards(awards: String) {
        this.awards = awards
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String) {
        this.country = country
    }

    fun getLanguage(): String? {
        return language
    }

    fun setLanguage(language: String) {
        this.language = language
    }

    fun getPlot(): String? {
        return plot
    }

    fun setPlot(plot: String) {
        this.plot = plot
    }

    fun getActors(): String? {
        return actors
    }

    fun setActors(actors: String) {
        this.actors = actors
    }

    fun getWriter(): String? {
        return writer
    }

    fun setWriter(writer: String) {
        this.writer = writer
    }

    fun getDirector(): String? {
        return director
    }

    fun setDirector(director: String) {
        this.director = director
    }

    fun getGenre(): String? {
        return genre
    }

    fun setGenre(genre: String) {
        this.genre = genre
    }

    fun getRuntime(): String? {
        return runtime
    }

    fun setRuntime(runtime: String) {
        this.runtime = runtime
    }

    fun getReleased(): String? {
        return released
    }

    fun setReleased(released: String) {
        this.released = released
    }

    fun getRated(): String? {
        return rated
    }

    fun setRated(rated: String) {
        this.rated = rated
    }

    fun getYear(): String? {
        return year
    }

    fun setYear(year: String) {
        this.year = year
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

}
