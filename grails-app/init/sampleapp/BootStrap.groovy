package sampleapp

class BootStrap {

    def init = { servletContext ->

        List<Book> books = [new Book(title: 'Book1').save(), new Book(title: 'Book2').save(), new Book(title: 'Book3').save()]
        Author author = new Author(name: 'Author1').save()
        books.each { Book book ->
            author.addToBooks(book)
        }

        List<Song> songs = [new Song(title: 'Song1').save(), new Song(title: 'Song2').save(), new Song(title: 'Song3').save()]
        Singer singer = new Singer(name: 'Artist1').save()
        songs.each { Song song ->
            singer.addToSongs(song)
        }

    }
    def destroy = {
    }
}
