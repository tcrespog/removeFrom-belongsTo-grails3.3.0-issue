package sampleapp

class AuthorController {

    AuthorService authorService

    def index() {
        render Author.get(1).books.collect { it.title }.sort()
    }

    def addNewBooks() {
        authorService.update([new Book(title: 'Book4').save(), new Book(title: 'Book5').save(), new Book(title: 'Book6').save()], Author.get(1))

        redirect(action: 'index')
    }

    def clearBooks() {
        authorService.clearAllBooks(Author.get(1))

        redirect(action: 'index')
    }
}
