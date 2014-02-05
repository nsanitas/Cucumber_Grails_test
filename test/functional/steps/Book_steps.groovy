import cucumber.api.PendingException
import data.Data
import books.BookController

// Scenario State
BookController bookController 

this.metaClass.mixin (cucumber.api.groovy.EN)

Given(~'^I open the book tracker\$') { ->
	// nothing to do while we test 'under the skin'
}
When(~'^I add "([^"]*)"\$') { String bookTitle ->
	bookController = new BookController ()
	bookController.params << Data.findByTitle (bookTitle)
	bookController.add ()
}
Then(~'^I see "([^"]*)"s details\$') { String bookTitle ->
	def expected = Data.findByTitle (bookTitle)
	def actual = bookController.response.json
	assert actual.id
	assert actual.title  == expected.title
	assert actual.author == expected.author
}

Given(~'^I have already added "([^"]*)"$') { String bookTitle ->
	def bookService = appCtx.getBean ("bookService")
	bookService.add (Data.findByTitle (bookTitle))
}
When(~'^I view the book list$') { ->
	bookController = new BookController ()
	bookController.all ()
}
Then(~'^my book list contains "([^"]*)"$') { String bookTitle ->
	def expected = Data.findByTitle (bookTitle)
	def all = bookController.response.json
	actual = all.getJSONObject (0)
	assert actual.id
	assert actual.title  == expected.title
	assert actual.author == expected.author
}
