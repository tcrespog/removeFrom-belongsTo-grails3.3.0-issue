package sampleapp

import grails.gorm.transactions.Transactional

@Transactional
class SingerService {

    void clearAllSongs(Singer singer) {
        singer.songs.collect().each { Song song ->
            singer.removeFromSongs(song)
        }
    }
}
