package com.example.object.domain.chapter10;

public class PersonalPlayList extends PlayList {
    public void remove(Song song) {
        getTracks().remove(song);
    }
}
