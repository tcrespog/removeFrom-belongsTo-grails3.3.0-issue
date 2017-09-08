import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import sampleapp.Author
import sampleapp.AuthorService
import sampleapp.Book
import spock.lang.Specification

@Integration
@Rollback
class AuthorServiceIntegrationSpec extends Specification {

    AuthorService authorService

    void "clear the books from an author"() {
        given: 'an author'
        Author author = new Author(name: 'Author1').save()

        and: 'some books related with the author'
        List<Book> books = [new Book(title: 'Book1').save(), new Book(title: 'Book2').save(), new Book(title: 'Book3').save()]
        books.each { Book book ->
            author.addToBooks(book)
        }

        when: 'clear the books from the author'
        authorService.clearAllBooks(author)

        then: "the author doesn't have any books"
        !author.books
    }


}
