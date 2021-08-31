package com.example.phase1;

import android.os.Build;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.O)
public class testing {

    String name = "Yashwanth";
    String comment = "This app is still in its development mode";

    boolean check = FeedBackClass.addComment(name , comment);

}
