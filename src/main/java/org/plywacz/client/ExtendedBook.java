package org.plywacz.client;

record ExtendedBook(Book coreBook, Author author, String someAdditionalData) {
}

record Book(String title, long authorId) {
}

record Author(String name, long id) {
}


