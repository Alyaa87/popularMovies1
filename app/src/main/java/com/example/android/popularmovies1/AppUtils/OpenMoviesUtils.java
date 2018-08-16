package com.example.android.popularmovies1.AppUtils;

import com.example.android.popularmovies1.MovieData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.provider.ContactsContract.CommonDataKinds.Organization.TITLE;
import static com.example.android.popularmovies1.Contract.Contract.OVERVIEW;
import static com.example.android.popularmovies1.Contract.Contract.POSTER_PATHE;
import static com.example.android.popularmovies1.Contract.Contract.RELEASE_DATE;
import static com.example.android.popularmovies1.Contract.Contract.RESULTS;
import static com.example.android.popularmovies1.Contract.Contract.VOTE_AVERAGE;

public class OpenMoviesUtils {

    public static ArrayList<MovieData> getMovies(String moviesJsonStr)

            throws JSONException {
        //  final String TOTAL_ٌُPAGES = "total_pages";
        MovieData movies;
        ArrayList<MovieData> moviesArrayList = new ArrayList<>();


        /* String array to hold each ellements String */
        JSONObject forecastJson = new JSONObject(moviesJsonStr);
        //get all data inside JSONObject forecastJson
        JSONArray moviesArrayResults = forecastJson.getJSONArray(RESULTS);
        //get all position of array-->  parsedMoviesData that come from JSONArray-->  moviesArrayResults
        for (int i = 0; i < moviesArrayResults.length(); i++) {
            /* These are the values that will be collected */

            movies = new MovieData();
            //    long voteCount;
            long voteAverage;
            String title;
            String posterPath;
            String overview;
            String releasDate;

            /* Get the JSON object representing the results */
            JSONObject objResult = moviesArrayResults.getJSONObject(i);
            /* Get the JSON object representing the--> ...vote_average... from -->JSONObject(results)*/
            voteAverage = objResult.optLong(VOTE_AVERAGE);
            /* Get the JSON object representing the -->...title... from--> JSONObject(results)*/
            title = objResult.optString(TITLE);
            /* Get the JSON object representing the -->...poster_path... from -->JSONObject(results)*/
            posterPath = objResult.optString(POSTER_PATHE);
            /* Get the JSON object representing the -->....overview.... from--> JSONObject(results)*/
            overview = objResult.optString(OVERVIEW);
            /* Get the JSON object representing the -->....release_date.... from--> JSONObject(results)*/
            releasDate = objResult.optString(RELEASE_DATE);
            movies.setVotAverage(voteAverage);
            movies.setOriginal_title(title);
            movies.setPoster_image(posterPath);
            movies.setOverview(overview);
            movies.setReleaseDate(releasDate);

            moviesArrayList.add(movies);

        }

        return moviesArrayList;
    }

}
