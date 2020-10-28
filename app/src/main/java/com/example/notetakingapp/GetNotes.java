package com.example.notetakingapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetNotes {

    @GET("/omidmogasemi/hackdavisAPI/posts")
    Call<List<Note>> getNotes();
}
