package org.plywacz.client;

record ExtendedBook(Book coreBook, String someAdditionalData) {
}
record Book(String title, String author, int year) {
}

