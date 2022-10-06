package org.plywacz.client;

import java.util.Collection;
import java.util.Optional;

record ExtendedBookOutput(Optional<String> error, Collection<ExtendedBook> extendedBooks) {
}
