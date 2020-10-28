package com.example.notetakingapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

// This interface is where we store the exact end URLs to append to our base URL
// to do different HTTP requests. For example, we say that at the URL endpoint below,
// we'd like to perform a "GET" request.
public interface GetNotes {
    @GET("/omidmogasemi/hackdavisAPI/posts")
    Call<List<Note>> getNotes();
}
