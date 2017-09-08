package sampleapp

class SingerController {

    SingerService singerService

    def index() {
        render Singer.get(1).songs.collect { it.title }.sort()
    }

    def clearSongs() {
        singerService.clearAllSongs(Singer.get(1))

        redirect(action: 'index')
    }
}
