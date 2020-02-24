package com.example.helloworld;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Word(String word) {this.mWord = word;}

    public String getWord(){return this.mWord;}
}*/

/*@Entity(tableName = "word_table")  //SAME
public class Word { //SAME

    @PrimaryKey //SAME
    @NonNull    //SAME
    @ColumnInfo(name = "first_name")
    private String mWord;

    //@ColumnInfo(name = "last_name")
    //private String lastName;

    public Word(String word) {this.mWord = word;}

    public String getWord(){return this.mWord;}

}*/

/*public class Word {
    public String title;
    public String description;
    public int imageId;

    Word(String title, String description, int imageId) {
        this.title = title;
        this.description = description;
        this.imageId = imageId;
    }

}*/