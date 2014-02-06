import cucumber.api.PendingException
import data.Data
import invoices.InvoiceController

// Scenario State
InvoiceController invoiceController 

this.metaClass.mixin (cucumber.api.groovy.EN)

Given(~'^I open the POS app$') { ->
	// nothing to do while we test 'under the skin'
}
When(~'^I add a EUR (\\d+) invoice$') { int amount ->
	invoiceController = new InvoiceController ()
	invoiceController.params << Data.findByAmount (amount)
	invoiceController.add ()
}
Then(~'^I see (\\d+) invoice details$') { int amount ->
	def expected = Data.findByAmount (amount)
	def actual = invoiceController.response.json
	assert actual.id
	assert actual.merchant  == expected.merchant
	assert actual.amount == expected.amount
}

Given(~'^I have already created a EUR (\\d+) invoice$') { int amount ->
	def invoiceService = appCtx.getBean ("invoiceService")
	invoiceService.add (Data.findByAmount (amount))
}
When(~'^I view the invoice list$') { ->
	invoiceController = new InvoiceController ()
	invoiceController.all ()
}
Then(~'^my book list contains the EUR (\\d+) invoice$') { int amount ->
	def expected = Data.findByAmount (amount)
	def all = invoiceController.response.json
	actual = all.getJSONObject (0)
	assert actual.id
	assert actual.amount  == expected.amount
	assert actual.merchant == expected.merchant
}
