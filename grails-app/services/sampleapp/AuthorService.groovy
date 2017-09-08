package sampleapp

import grails.gorm.transactions.Transactional

@Transactional
class AuthorService {

    Author update(List<Book> newBooks, Author author) {
        List<Book> oldBooks = author.books.collect()
        oldBooks.each { Book book ->
            author.removeFromBooks(book)
        }

        newBooks.each { Book book ->
            author.addToBooks(book)
        }

        author.save()
    }

    void clearAllBooks(Author author) {
        author.books.collect().each { Book book ->
            author.removeFromBooks(book)
        }
    }
}
