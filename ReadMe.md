Microservices DEMO app:

	-- Uses async communication with Webflux !!!.

	    Api: returns 3 hardcoded data (books). It takes 1 sec (simulate heavy data fetch from DB).
        No async call threaad is blocked.
	    
	    Client: calls api for books using WebClient, gets Mono<List<Book>>.
	    Then applies heavy processing operation on every book using .map <-callback. from Mono wich takes 700ms.
	    Returns Mono<List<ExtendedBooks>> from controller so that thread is not blocked !!!.
        
        Example of async on controller:
        2022-10-05 12:49:42.205 DEBUG 6148 --- [nio-2001-exec-2] org.plywacz.client.BookController        : Thread comes to->allExtendedBooks: requesting mono
        2022-10-05 12:49:42.222 DEBUG 6148 --- [nio-2001-exec-2] org.plywacz.client.BookController        : Thread gets Mono and is released from allExtendedBooks: returning mono
        2022-10-05 12:49:43.917 DEBUG 6148 --- [ctor-http-nio-2] org.plywacz.client.BookService           : Processing one book from remote service: will take 700ms (heavy operation)
        2022-10-05 12:49:44.629 DEBUG 6148 --- [ctor-http-nio-2] org.plywacz.client.BookService           : Processing one book from remote service: will take 700ms (heavy operation)
        2022-10-05 12:49:45.344 DEBUG 6148 --- [ctor-http-nio-2] org.plywacz.client.BookService           : Processing one book from remote service: will take 700ms (heavy operation)

	