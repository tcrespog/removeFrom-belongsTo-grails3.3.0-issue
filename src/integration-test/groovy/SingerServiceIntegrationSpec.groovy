import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import sampleapp.Singer
import sampleapp.SingerService
import sampleapp.Song
import spock.lang.Specification

@Integration
@Rollback
class SingerServiceIntegrationSpec extends Specification {

    SingerService singerService

    void "clear the songs from a singer"() {
        given: 'a singer'
        Singer singer = new Singer(name: 'Singer1').save()

        and: 'some songs related with the singer'
        List<Song> Songs = [new Song(title: 'Song1').save(), new Song(title: 'Song2').save(), new Song(title: 'Song3').save()]
        Songs.each { Song song ->
            singer.addToSongs(song)
        }

        when: 'clear the songs from the singer'
        singerService.clearAllSongs(singer)

        then: "the singer doesn't have any songs"
        !singer.songs
    }


}