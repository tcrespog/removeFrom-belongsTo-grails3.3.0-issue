package sampleapp

class Author {

    String name

    static hasMany = [books: Book]

    static constraints = {
    }
}
