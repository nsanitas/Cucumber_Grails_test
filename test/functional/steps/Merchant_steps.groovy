import cucumber.api.PendingException
import data.Data
import invoices.InvoiceController

// Scenario State
InvoiceController invoiceController

this.metaClass.mixin (cucumber.api.groovy.EN)

Given(~'^I have already created a "([^"]*)" merchant$') { String arg1 ->
	def invoiceService = appCtx.getBean ("invoiceService")
	invoiceService.add (Data.findByMerchant (arg1))
}
When(~'^I view the merchant list$') { ->
	invoiceController = new InvoiceController ()
	invoiceController.all ()
}
Then(~'^my merchant list contains the "([^"]*)" merchant$') { String arg1 ->
	def expected = Data.findByMerchant (arg1)
	def all = invoiceController.response.json
	actual = all.getJSONObject (0)
	assert actual.id
	assert actual.merchant == expected.merchant
}