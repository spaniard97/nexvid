/**
 * Created by Samuel on 16/03/17.
 */

//import "searchResults" as SR;

$("#button1").click(function() {
    var title = $("#searchBar").val();
    console.log(title);

    var media = $("input[name=media]:radio:checked").val();
    console.log(media);

    var url = "https://api.themoviedb.org/3/search/" + media + "?include_adult=false&page=1&query=" + title + "&language=en-US&api_key=08ed131daa0c896e2a6a31e1869d656d"

    var settings = {
        "async": true,
        "crossDomain": true,
        "url": url,
        "method": "GET",
        "headers": {},
        "data": "{}",
        "dataType": "json",
    }

    $.ajax(settings).done(function(response) {

        //Loggin response to conse for debugging
        console.log(response);
        //total pages of result
        var totalPages = response.total_pages;
        console.log("Total pages: " + totalPages);
        //current page in the search
        var currentPage = response.page;
        console.log("Current page: " + currentPage);



        for (i = 0; i < response.results.length; i++) {
            //Movie title
            var movieTitle = response.results[i].title;
            console.log("Movie Title: " + movieTitle);
            //If the media is a TvShow, the title changes to name
            //var tvShowName = response.results[0].name;
            //image url
            var image = "https://image.tmdb.org/t/p/w154" + response.results[i].poster_path;
            // document.getElementById("resultList").innerHTML += '<img src="' + image + '" />';
            //Online Id
            var onlineID = response.results[i].id;
            console.log("Online ID:" + onlineID);
            //image url
            var image = "https://image.tmdb.org/t/p/w154" + response.results[i].poster_path;
            //Overview
            var overview = response.results[i].overview;
            console.log("Overview:" + overview);
            //Release date
            var releaseDate = response.results[i].release_date;
            console.log("Release date: " + releaseDate);

            document.getElementById("resultList").innerHTML +=
                '<li class = "result"><img class="resultImage" src= "' + image + '" / > <div class="restultsRight"><h2 class = "resultHeader">' + movieTitle + '</h2><p class="resultDescrip" > ' + overview + ' </p > </div></li > ';
        }
    });


});